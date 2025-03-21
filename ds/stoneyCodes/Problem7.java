/*
Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.


Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem7
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((List<Integer>) clazz.getMethod("spiralOrder", int[][].class).invoke(problem, (Object) matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println((List<Integer>) clazz.getMethod("spiralOrder", int[][].class).invoke(problem, (Object) matrix));

        matrix = new int[][]{{1}, {2}, {3}, {4}};
        System.out.println((List<Integer>) clazz.getMethod("spiralOrder", int[][].class).invoke(problem, (Object) matrix));

        matrix = new int[][]{{1, 2, 3, 4}};
        System.out.println((List<Integer>) clazz.getMethod("spiralOrder", int[][].class).invoke(problem, (Object) matrix));

	}

	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int index = 0;

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] visited = new boolean[rows][columns];

        int row = 0;
        int column = 0;

        for(int i = 0; i < rows * columns; i++)
        {
            result.add(matrix[row][column]);

            visited[row][column] = true;

            int newRow = row + directions[index][0];
            int newColumn = column + directions[index][1];

            if(newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && !visited[newRow][newColumn])
            {
                row = newRow;
                column = newColumn;
            }
            else
            {
                index = ((index + 1) % 4);
                row += directions[index][0];
                column += directions[index][1];
            }
        }

        return result;
    }
}


/*
Time complexity: O(m * n)
Space complexity: O(m * n)
*/
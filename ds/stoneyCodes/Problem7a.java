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

public class Problem7a
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

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int top = 0;
        int right = columns - 1;
        int bottom = rows - 1;

        while(top <= bottom && left <= right)
        {
            for(int i = left; i <= right; i++)
            {
                result.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++)
            {
                result.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom)
            {
                for(int i = right; i >= left; i--)
                {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right)
            {
                for(int i = bottom; i >= top; i--)
                {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}


/*
Time complexity: O(m * n)
Space complexity: O(m * n) [for result]
*/
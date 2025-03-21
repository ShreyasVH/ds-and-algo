/*
Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem8
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        char[][] matrix = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println((int) clazz.getMethod("numIslands", char[][].class).invoke(problem, (Object) matrix));

        matrix = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println((int) clazz.getMethod("numIslands", char[][].class).invoke(problem, (Object) matrix));
	}

	public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int islandCount = 0;
        for(int row = 0; row < rows; row++)
        {
            for(int column = 0; column < columns; column++)
            {
                if(grid[row][column] == '1')
                {
                    islandCount++;
                    dfs(grid, row, column);
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][] grid, int row, int column)
    {
        int rows = grid.length;
        int columns = grid[0].length;
        if(row >= 0 && row < rows && column >= 0 && column < columns && grid[row][column] == '1')
        {
            grid[row][column] = '0';

            dfs(grid, row + 1, column);
            dfs(grid, row - 1, column);
            dfs(grid, row, column + 1);
            dfs(grid, row, column - 1);
        }
    }
}


/*
Time complexity: O(m * n)
Space complexity: O(m * n)
*/
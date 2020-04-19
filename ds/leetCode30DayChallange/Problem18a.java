/*
	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.

	Example:
	Input:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	Output: 7
	Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
class Solution
{
    public int minPathSum(int[][] grid)
    {
        if((0 == grid.length) || (0 == grid[0].length))
        {
        	return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] cache = new int[m][n];

        cache[0][0] = grid[0][0];

        for(int i = 1; i < n; i++)
        {
            cache[0][i] = grid[0][i] + cache[0][i - 1];
        }

        for(int i = 1; i < m; i++)
        {
            cache[i][0] = grid[i][0] + cache[i - 1][0];
        }

        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                int r1 = cache[i - 1][j];
                int r2 = cache[i][j - 1];
                cache[i][j] = grid[i][j] + Integer.min(r1, r2);
            }
        }

        return cache[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.minPathSum(new int[][]{
    		{1, 3, 1},
    		{1, 5, 1},
    		{4, 2, 1}
    	}));
    }
}
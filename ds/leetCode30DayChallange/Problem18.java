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

        return dfs(grid, 0, 0, m, n);
    }

    public int dfs(int[][] grid, int i, int j, int m, int n)
    {
    	if((i == m - 1) && (j == n - 1))
    	{
    		return grid[i][j];
    	}

    	if((i < (m - 1)) && (j < (n - 1)))
    	{
    		int r1 = dfs(grid, i + 1, j, m, n);
    		int r2 = dfs(grid, i, j + 1, m, n);
    		return grid[i][j] + Integer.min(r1, r2);
    	}

    	if(i < (m - 1))
    	{
    		return (grid[i][j] + dfs(grid, i + 1, j, m, n));
    	}

    	if(j < (n - 1))
    	{
    		return (grid[i][j] + dfs(grid, i, j + 1, m, n));
    	}

    	return 0;
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
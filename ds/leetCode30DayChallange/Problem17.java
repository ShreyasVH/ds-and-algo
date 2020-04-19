/*
	Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

	Example 1:

	Input:
	11110
	11010
	11000
	00000

	Output: 1
	Example 2:

	Input:
	11000
	11000
	00100
	00011

	Output: 3
*/

class Solution
{
	boolean[] visited;

    public int numIslands(char[][] grid)
    {
        int count = 0;
        int m = grid.length;
        if(m > 0)
        {
        	int n = grid[0].length;

        	if(n > 0)
        	{
        		visited = new boolean[grid.length * grid[0].length];
        		for(int i = 0; i < grid.length; i++)
        		{
        			for(int j = 0; j < grid[0].length; j++)
        			{
        				if(grid[i][j] == '1' && !visited[getKey(i, j, m, n)])
        				{
        					boolean isNew = visitNode(grid, i, j);
        					if(isNew)
        					{
        						count++;
        					}
        				}
        			}
        		}
        	}
        }

        return count;
    }

    public int getKey(int i, int j, int m, int n)
    {
    	return (i * n + j);
    }

    public boolean visitNode(char[][] grid, int i, int j)
    {
    	int m = grid.length;
    	int n = grid[0].length;
    	int key = getKey(i, j, m, n);
    	boolean isNew = !visited[key];

    	if(isNew)
    	{
    		visited[key] = true;

    		boolean left = isWater(grid, i, j - 1);
    		if(!left && !visited[getKey(i, j - 1, m, n)])
    		{
    			visitNode(grid, i, j - 1);
    		}

    		boolean top = isWater(grid, i - 1, j);
    		if(!top && !visited[getKey(i - 1, j, m, n)])
    		{
    			visitNode(grid, i - 1, j);
    		}

    		boolean right = isWater(grid, i, j + 1);
    		if(!right && !visited[getKey(i, j + 1, m, n)])
    		{
    			visitNode(grid, i, j + 1);
    		}

    		boolean bottom = isWater(grid, i + 1, j);
    		if(!bottom && !visited[getKey(i + 1, j, m, n)])
    		{
    			visitNode(grid, i + 1, j);
    		}
    	}

    	return isNew;
    }

    public boolean isWater(char[][] grid, int i, int j)
    {
    	int m = grid.length;
    	int n = grid[0].length;

    	return ((i < 0) || (i >= m) || (j < 0) || (j >= n) || (grid[i][j] == '0'));
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.numIslands(new char[][]{
    		{'1', '1', '1', '1', '0'},
    		{'1', '1', '0', '1', '0'},
    		{'1', '1', '0', '0', '0'},
    		{'0', '0', '0', '0', '0'}
    	}));

    	System.out.println(s.numIslands(new char[][]{
    		{'1', '1', '0', '0', '0'},
    		{'1', '1', '0', '0', '0'},
    		{'0', '0', '1', '0', '0'},
    		{'0', '0', '0', '1', '1'}
    	}));

    	System.out.println(s.numIslands(new char[][]{}));

    	System.out.println(s.numIslands(new char[][]{
    		{'1', '1', '0'}
    	}));

    	System.out.println(s.numIslands(new char[][]{
    		{'1'},
    		{'0'},
    		{'1'}
    	}));
    }
}
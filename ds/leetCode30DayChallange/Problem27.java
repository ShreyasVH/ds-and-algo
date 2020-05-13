/*
	Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

	Example:

	Input: 

	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0

	Output: 4
*/
class Solution
{
	public int maximalSquare(char[][] matrix)
	{
		if((0 == matrix.length) || (0 == matrix[0].length))
    	{
    		return 0;
    	}
		int offset = 48;
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] sub = new int[rows][columns];
		for (int i = 0; i < columns; i++) {
			sub[0][i] = matrix[0][i] - offset;
		}

		for (int i = 0; i < rows; i++) {
			sub[i][0] = matrix[i][0] - offset;
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (matrix[i][j] - offset == 1) {
					sub[i][j] = Math.min(sub[i - 1][j - 1],
							Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
				} else {
					sub[i][j] = 0;
				}
			}
		}

		int maxSize = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (sub[i][j] > maxSize) {
					maxSize = sub[i][j];
				}
			}
		}
		return maxSize * maxSize;
	}

	public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.maximalSquare(new char[][]{
    		{'1', '0', '1', '0', '0'},
    		{'1', '0', '1', '1', '1'},
    		{'1', '1', '1', '1', '1'},
    		{'1', '0', '0', '1', '0'}
    	}));
    } 
}
/*
	(This problem is an interactive problem.)

	A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

	Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

	You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

	BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
	BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
	Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

	For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

	 

	Example 1:



	Input: mat = [[0,0],[1,1]]
	Output: 0
	Example 2:



	Input: mat = [[0,0],[0,1]]
	Output: 1
	Example 3:



	Input: mat = [[0,0],[0,0]]
	Output: -1
	Example 4:



	Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
	Output: 1
	 

	Constraints:

	1 <= mat.length, mat[i].length <= 100
	mat[i][j] is either 0 or 1.
	mat[i] is sorted in a non-decreasing way.
*/
import java.util.List;
import java.util.ArrayList;
class Solution
{
	public static class BinaryMatrix
	{
		int[][] matrix;
		static int count;
		public BinaryMatrix(int[][] matrix)
		{
			this.matrix = matrix;
			count = 0;
		}


		public int get(int x, int y)
		{
			count++;
			int result = -1;
			if(x < matrix.length && y < matrix[0].length)
			{
				result = matrix[x][y];
			}
			return result;
		}
		public List<Integer> dimensions()
		{
			List<Integer> dimensions = new ArrayList<>();

			if((matrix.length > 0) && (matrix[0].length > 0))
			{
				dimensions.add(matrix.length);
				dimensions.add(matrix[0].length);
			}

			return dimensions;
		}
	}

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix)
    {
        int result = Integer.MAX_VALUE;

        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int columns = dimensions.get(1);

        for(int i = 0; i < rows; i++)
        {
        	int firstZero = getFirstOne(binaryMatrix, i, columns);
        	result = Integer.min(result, firstZero);
        }

        if(result == Integer.MAX_VALUE)
        {
        	result = -1;
        }

        return result;
    }

    public int getFirstOne(BinaryMatrix binaryMatrix, int row, int columns)
    {
    	int result = Integer.MAX_VALUE;
    	for(int j = 0; j < columns; j++)
    	{
    		if(binaryMatrix.get(row, j) == 1)
    		{
    			result = j;
    			break;
    		}
    	}
    	return result;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {1, 1}})));
    	// System.out.println(BinaryMatrix.count);

    	System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {0, 1}})));
    	// System.out.println(BinaryMatrix.count);

    	System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {0, 0}})));
    	// System.out.println(BinaryMatrix.count);

    	System.out.println(s.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}})));
    	// System.out.println(BinaryMatrix.count);
    }
}
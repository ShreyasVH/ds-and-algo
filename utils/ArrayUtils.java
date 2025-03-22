package utils;

public class ArrayUtils
{
	public static void print(Object[][] matrix, int rows, int columns)
    {
    	for(int i = 0; i < rows; i++)
        {
        	for(int j = 0; j < columns; j++)
        	{
        		System.out.print(matrix[i][j] + " ");
        	}
        	System.out.println();
        }
    }

    public static void print(int[][] matrix, int rows, int columns)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[] arr)
    {
    	for (int i = 0; i < arr.length; i++)
    	{
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
}
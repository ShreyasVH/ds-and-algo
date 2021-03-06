/*
	Program for array rotation
	Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements. 
*/

class Solution
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6};

		rotate(arr, 4);
		print(arr);
	}

	public static void print(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void rotate(int[] arr, int d)
	{
		for(int i = 1; i <= d; i++)
		{
			int temp = arr[0];

			for(int j = 0; j < arr.length - 1; j++)
			{
				arr[j] = arr[j+1];
			}
			arr[arr.length - 1] = temp;
		}
	}
}

/*
	Time Complexity: O(n * d)
	Space Complexity: O(1)
*/
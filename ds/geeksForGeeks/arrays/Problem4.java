/*
	Program to cyclically rotate an array by one
	Given an array, cyclically rotate the array clockwise by one.
*/
class Solution
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};

		rotate(arr);
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

	public static void rotate(int[] arr)
	{
		int n = arr.length;

		if(n == 0)
		{
			return;
		}

		int temp = arr[n - 1];
		for(int i = n - 1; i >= 1; i--)
		{
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
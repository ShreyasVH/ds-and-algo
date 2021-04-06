/*
	Reversal algorithm for array rotation
	Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements. 
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
		int n = arr.length;
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);
	}

	public static void reverse(int[] arr, int start, int end)
	{
		for(int i = 0; i <= ((end - start) / 2); i++)
		{
			int temp = arr[start + i];
			arr[start + i] = arr[end - i];
			arr[end - i] = temp;
		}
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
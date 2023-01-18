/*
	Block swap algorithm for array rotation
	Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
*/
class Solution
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6};

		rotate(arr, arr.length, 0, 4);
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

	public static void rotate(int[] arr, int n, int start, int d)
	{
		if(d == (n - d))
		{
			swap(arr, start, start + d, d);
		}
		else if(d < (n - d))
		{
			swap(arr, start, start + n - d, d);
			rotate(arr, n - d, start, d);
		}
		else
		{
			swap(arr, start, start + d, n - d);
			rotate(arr, d, start + n - d, 2 * d - n);
		}
	}

	public static void swap(int[] arr, int start1, int start2, int n)
	{
		for(int i = 0; i < n; i++)
		{
			int temp = arr[start1 + i];
			arr[start1 + i] = arr[start2 + i];
			arr[start2 + i] = temp;
		}
	}
}


/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
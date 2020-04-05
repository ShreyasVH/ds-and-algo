/*
	Given an array, cyclically rotate the array clockwise by one.
*/
public class Problem4
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};
		rotate(arr);
		print(arr);

	}

	public static void rotate(int[] arr)
	{
		int n = arr.length;
		int temp = arr[n - 1];

		for(int i = (n - 1); i > 0; i--)
		{
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}

	public static void print(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
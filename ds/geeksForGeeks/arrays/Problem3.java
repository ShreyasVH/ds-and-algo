/*
	Block swap algorithm for array rotation anti-clockwise (Recursive)
*/
public class Problem3
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};
		rotate(arr, 3);
		print(arr);
	}

	public static void rotate(int[] arr, int d)
	{
		rotate(arr, arr.length, 0, d);

		//Right Rotate
		// rotate(arr, arr.length, 0, (arr.length - d));
	}

	public static void rotate(int[] arr, int n, int arrayStart, int d)
	{
		if((n - d) == d)
		{
			swap(arr, arrayStart, (d + arrayStart), d);
		}
		else if(d < (n - d))
		{
			swap(arr, arrayStart, (arrayStart + n - d), d);
			rotate(arr, (n - d), arrayStart, d);
		}
		else
		{
			swap(arr, arrayStart, d, (n - d));
			rotate(arr, d, (n - d), (2 * d - n));
		}
	}

	public static void swap(int[] arr, int fi, int si, int d)
	{
		for(int i = 0; i < d; i++)
		{
			int temp = arr[fi + i];
			arr[fi + i] = arr[si + i];
			arr[si + i] = temp;
		}
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
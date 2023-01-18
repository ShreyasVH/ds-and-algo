/*
	Block swap algorithm for array rotation
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
		int n = arr.length;

		int start1 = 0;
		int start2;

		while(true)
		{
			int len1 = d;
			int len2 = (n - d);

			if(len1 == len2)
			{
				break;
			}
			else if(len1 < len2)
			{
				start2 = (start1 + n - d);
				swap(arr, start1, start2, d);
				n = n - d;
			}
			else
			{
				start2 = (start1 + d);
				swap(arr, start1, start2, n - d);
				int temp = d;
				start1 = n - d;
				d = 2 * temp - n;
				n = temp;
			}
		}

		swap(arr, start1, start1 + d, d);
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
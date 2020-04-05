/*
	Block swap algorithm for array rotation anti-clockwise (Iterative)
*/
public class Problem3a
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};
		rotate(arr, 3);
		print(arr);
	}

	public static void rotate(int[] arr, int d)
	{
		int n = arr.length;
		int len1 = d;
		int len2 = (n - d);
		int start1 = 0;
		int start2 = d;

		while(len1 != len2)
		{
			if(len1 < len2)
			{
				start2 = (start1 + (n - d));
				swap(arr, start1, start2, d);
				start2 = (start1 + d);
				len2 = (len2 - len1);
				n = (n - d);
			}
			else
			{
				start2 = (start1 + d);
				swap(arr, start1, start2, (n - d));
				start1 = (start1 + (n - d));
				len1 = (len1 - len2);
				int nPrev = n;
				n = d;
				d = (2 * d - nPrev);
			}
		}

		swap(arr, start1, start2, len1);

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
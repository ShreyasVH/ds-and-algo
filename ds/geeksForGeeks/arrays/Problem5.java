/*
	Search an element in a sorted and rotated array
*/

class Solution
{
	public static void main(String[] args)
	{
		int[] arr = {3, 4, 5, 1, 2};

		for(int i = 0; i <= arr.length + 1; i++)
		{
			System.out.println(search(arr, i, 0, arr.length - 1));
		}
	}

	public static int search(int[] arr, int key, int l, int r)
	{
		int pos = -1;

		if(l <= r)
		{
			int m = ((l + r) / 2);
			if(arr[m] == key)
			{
				pos = m;
			}
			else if(key >= arr[l] && key < arr[m])
			{
				pos = search(arr, key, l, m - 1);
			}
			else
			{
				pos = search(arr, key, m + 1, r);
			}
		}

		return pos;
	}
}


/*
	Time Complexity: O(logn)
	Space Complexity: O(logn)
*/
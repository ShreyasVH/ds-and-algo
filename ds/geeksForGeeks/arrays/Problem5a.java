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
			System.out.println(search(arr, i));
		}
	}

	public static int search(int[] arr, int key)
	{
		int pos = -1;
		int n = arr.length;

		int l = 0;
		int r = (n - 1);

		while(l <= r)
		{
			int m = ((l + r) / 2);
			if(arr[m] == key)
			{
				pos = m;
				break;
			}
			else if(key >= arr[l] && key < arr[m])
			{
				r = (m - 1);
			}
			else
			{
				l = (m + 1);
			}
		}

		return pos;
	}
}


/*
	Time Complexity: O(logn)
	Space Complexity: O(1)
*/
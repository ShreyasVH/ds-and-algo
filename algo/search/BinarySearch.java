class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		for(int i = 0; i <= 8; i++)
		{
			System.out.println(s.searchIterative(arr, i));
			System.out.println(s.searchRecursive(arr, i, 0, (arr.length - 1)));
		}

		System.out.println("---------------------------");

		System.out.println(s.searchIterative(new int[]{1}, 1));
		System.out.println(s.searchRecursive(new int[]{1}, 1, 0, 0));
		System.out.println(s.searchIterative(new int[]{1}, 10));
		System.out.println(s.searchRecursive(new int[]{1}, 10, 0, 0));
	}

	public int searchIterative(int[] arr, int key)
	{
		int pos = -1;

		int n = arr.length;
		int start = 0;
		int end = (n - 1);
		

		while(start <= end)
		{
			int mid = ((start + end) / 2);
			if(arr[mid] == key)
			{
				pos = mid;
				break;
			}
			else if(key < arr[mid])
			{
				end = (mid - 1);
			}
			else
			{
				start = (mid + 1);
			}
		}


		return pos;
	}

	public int searchRecursive(int[] arr, int key, int start, int end)
	{
		int pos = -1;
		// System.out.println("Start: " + start + " End: " + end);
		if(start <= end)
		{
			int mid = ((start + end) / 2);
			if(arr[mid] == key)
			{
				pos = mid;
			}
			else if(key < arr[mid])
			{
				pos = searchRecursive(arr, key, start, (mid - 1));
			}
			else
			{
				pos = searchRecursive(arr, key, (mid + 1), end);
			}
		}
		return pos;
	}
}

/*
	Time Complexity: O[log(n)] base 2
	Space Complexity: O[1]
*/
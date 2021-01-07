class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		System.out.println(s.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
		System.out.println(s.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 14));
	}

	public int search(int[] arr, int key)
	{
		int pos = -1;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == key)
			{
				pos = i;
				break;
			}
		}
		return pos;
	}
}

/*
	Time Complexity: O[n]
	Space Complexity: O[1]
*/
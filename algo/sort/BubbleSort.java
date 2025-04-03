class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		// int[] a = {5, 4, 3, 2, 1};
		int[] a = {5, 7, 1, 2, 5};
		s.sort(a);
		s.print(a);
	}

	public void sort(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			for(int j = 0; j < arr.length - i - 1; j++)
			{
				if(arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public void print(int[] a)
	{
		for(int e: a)
		{
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
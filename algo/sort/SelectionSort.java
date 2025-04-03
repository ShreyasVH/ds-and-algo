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
		for(int i = 0; i < arr.length; i++)
		{
			int smallest = i;
			for(int j = i; j < arr.length; j++)
			{
				if(arr[j] < arr[smallest])
				{
					smallest = j;
				}
			}

			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
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
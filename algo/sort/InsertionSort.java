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
		for(int i = 1; i < arr.length; i++)
		{
			int j = i - 1;
			int temp = arr[i];

			while(j >= 0 && arr[j] > temp)
			{
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;
		}
	}

	public void print(int[] a)
	{
		for(int e: a)
		{
			System.out.println(e + " ");
		}
	}
}
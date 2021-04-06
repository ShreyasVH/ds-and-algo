class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		int[] a = {5, 4, 3, 2, 1};
		// int[] a = {5, 7, 1, 2, 5};
		s.sort(a, 0, a.length - 1);
		s.print(a);
	}

	public void sort(int[] arr, int start, int end)
	{
		if(start < end)
		{
			int pos = partition(arr, start, end);

			sort(arr, start, pos - 1);
			sort(arr, pos + 1, end);
		}
	}

	public int partition(int[] arr, int start, int end)
	{
		int pivot = arr[end];
		int i = start;

		for(int j = start; j < end; j++)
		{
			if(arr[j] < pivot)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
			}
		}

		int temp = arr[i];
		arr[i] = pivot;
		arr[end] = temp;
		return i;
	}

	public void print(int[] a)
	{
		for(int e: a)
		{
			System.out.println(e + " ");
		}
	}
}
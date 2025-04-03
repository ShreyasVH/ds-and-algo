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
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int[] arr, int l, int r)
	{
		if(l < r)
		{
			int m = l + (r - l) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	public void merge(int[] arr, int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for(int i = 0; i < n1; i++)
		{
			L[i] = arr[l + i];
		}

		for(int i = 0; i < n2; i++)
		{
			R[i] = arr[m + 1 + i];
		}

		int i = 0;
		int j = 0;

		int k = l;

		while(i < n1 && j < n2)
		{
			if(L[i] <= R[j])
			{
				arr[k++] = L[i];
				i++;
			}
			else
			{
				arr[k++] = R[j];
				j++;
			}
		}

		while(i < n1)
		{
			arr[k++] = L[i];
			i++;
		}

		while(j < n2)
		{
			arr[k++] = R[j];
			j++;
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
/*
	Quick Sort
*/

public class Problem1
{
	public static void main(String[] args)
	{
		int[] a = {2, 4, 3, 5, 1};
		sort(a, 0, (a.length - 1));
		print(a);
	}

	public static void print(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	public static void sort(int[] a, int low, int high)
	{
		if(low < high)
		{
			int p = partition(a, low, high);

			sort(a, low, (p - 1));
			sort(a, (p + 1), high);
		}
	}

	public static int partition(int[] a, int low, int high)
	{
		int i = low;
		int pivot = a[high];

		for(int j = low; j < high; j++)
		{
			if(a[j] < pivot)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}

		int temp = a[i];
		a[i] = a[high];
		a[high] = temp;

		return i;
	}
}
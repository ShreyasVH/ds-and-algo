/*
	Given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
*/

public class Problem2
{
	public static void main(String[] args)
	{

		// int[] start = {1, 3, 2, 5, 8, 5};
		// int[] end = {2, 4, 6, 7, 9, 9};

		// int[] start = {1, 3, 2, 5};
		// int[] end = {2, 4, 3, 6};

		// System.out.println(getMaxActivityCount(start, end));


		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for(int i = 0; i < N; i++)
		{
		    int n = scanner.nextInt();
		    int[] start = new int[n];
		    int[] end = new int[n];
		    for(int j = 0; j < n; j++)
		    {
		        start[j] = scanner.nextInt();
		    }
		    
		    for(int j = 0; j < n; j++)
		    {
		        end[j] = scanner.nextInt();
		    }   
		    
		    System.out.println(getMaxActivityCount(start, end));
		}
	}

	public static void print(int[] start, int[] end)
	{
		for(int i = 0; i < start.length; i++)
		{
			System.out.print(start[i] + " ");
		}
		System.out.println("");

		for(int i = 0; i < end.length; i++)
		{
			System.out.print(end[i] + " ");
		}
		System.out.println("");

	}

	public static int getMaxActivityCount(int[] start, int[] end)
	{
		int count = 1;
		sortByEndTimes(start, end, 0, (start.length - 1));
		// print(start, end);
		

		int i = 0;

		for(int j = 1; j < start.length; j++)
		{
			if(start[j] >= end[i])
			{
				count++;
				i = j;
			}
		}
		return count;
	}

	public static void sortByEndTimes(int[] start, int[] end, int low, int high)
	{
		if(low < high)
		{
			int p = partition(start, end, low, high);

			sortByEndTimes(start, end, low, (p - 1));
			sortByEndTimes(start, end, (p + 1), high);
		}
	}

	public static int partition(int[] start, int[] end, int low, int high)
	{
		int i = low;
		int pivot = end[high];

		for(int j = low; j < high; j++)
		{
			if(end[j] < pivot)
			{
				int temp = end[j];
				end[j] = end[i];
				end[i] = temp;

				temp = start[j];
				start[j] = start[i];
				start[i] = temp;
				i++;
			}
		}

		int temp = end[i];
		end[i] = end[high];
		end[high] = temp;

		temp = start[i];
		start[i] = start[high];
		start[high] = temp;

		return i;
	}
}
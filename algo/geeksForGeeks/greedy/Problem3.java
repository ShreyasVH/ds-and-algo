/*
	Job Sequencing Problem
*/
public class Problem3
{

	static class Job
	{
		char id;
		int deadLine;
		int profit;

		Job(char id, int deadLine, int profit)
		{
			this.id = id;
			this.deadLine = deadLine;
			this.profit = profit;
		}
	}

	public static void main(String[] args)
	{
		// Job[] jobs = {new Job('a', 4, 20), new Job('b', 1, 10), new Job('c', 1, 40), new Job('d', 1, 30)};

		// Job[] jobs = {new Job('a', 2, 100), new Job('b', 1, 19), new Job('c', 2, 27), new Job('d', 1, 25), new Job('e', 3, 15)};

		Job[] jobs = {new Job('a', 5, 200), new Job('b', 3, 180), new Job('c', 3, 190), new Job('d', 2, 300), new Job('e', 4, 120), new Job('f', 2, 100)};
		print(getMaxProfitJobs(jobs));
	}

	public static Job[] getMaxProfitJobs(Job[] jobs)
	{
		Job[] result = new Job[jobs.length];

		sort(jobs, 0, jobs.length - 1);
		int max = max(jobs);

		boolean[] slots = new boolean[max];

		Integer[] order = new Integer[max];

		for(int i = 0; i < jobs.length; i++)
		{
			for(int j = (jobs[i].deadLine - 1); j >= 0; j--)
			{
				if(!slots[j])
				{
					slots[j] = true;
					order[j] = i;
					break;
				}
			}
		}

		int j = 0;
		for(int i = 0; i < order.length; i++)
		{
			if(slots[i])
			{
				result[j++] = jobs[order[i]];
			}
		}


		return result;
	}

	public static int max(Job[] jobs)
	{
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < jobs.length; i++)
		{
			if(jobs[i].deadLine > max)
			{
				max = jobs[i].deadLine;
			}
		}

		return max;
	}

	public static void sort(Job[] jobs, int start, int end)
	{
		if(start < end)
		{
			int pi = partition(jobs, start, end);

			sort(jobs, start, (pi - 1));
			sort(jobs, (pi + 1), end);
		}
	}

	public static int partition(Job[] jobs, int start, int end)
	{
		int i = start;
		Job pivot = jobs[end];

		for(int j = start; j < end; j++)
		{
			if(jobs[j].profit >= pivot.profit)
			{
				Job temp = new Job(jobs[i].id, jobs[i].deadLine, jobs[i].profit);
				jobs[i] = jobs[j];
				jobs[j] = temp;
				i++;
			}
		}

		Job temp = new Job(jobs[i].id, jobs[i].deadLine, jobs[i].profit);
		jobs[i] = jobs[end];
		jobs[end] = temp;
		return i;
	}

	public static void print(Job[] jobs)
	{
		for(int i = 0; i < jobs.length; i++)
		{
			if(null != jobs[i])
			{
				System.out.print(jobs[i].id + " ");
			}
		}
		System.out.println();
	}
}
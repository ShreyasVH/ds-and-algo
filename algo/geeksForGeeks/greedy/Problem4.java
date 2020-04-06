/*
	Job Sequencing Problem (Using Disjoint sets)
*/
public class Problem4
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

	static class DisjointSet
	{
		int[] parent;

		DisjointSet(int count)
		{
			parent = new int[count + 1];

			for(int i = 0; i <= count; i++)
			{
				parent[i] = i;
			}
		}

		public int find(int i)
		{
			if(parent[i] == i)
			{
				return i;
			}

			return find(parent[i]);
		}

		public void union(int u, int v)
		{
			parent[v] = u;
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
		Job[] result;

		sort(jobs, 0, jobs.length - 1);
		int maxDeadline = max(jobs);
		result = new Job[maxDeadline + 1];

		DisjointSet set = new DisjointSet(maxDeadline);

		for(int i = 0; i < jobs.length; i++)
		{
			int slot = set.find(jobs[i].deadLine);

			if(slot > 0)
			{
				set.union(slot - 1, slot);
				result[slot] = jobs[i];
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
/*
	Job Sequencing Problem – Loss Minimization
	We are given N jobs numbered 1 to N. For each activity, let Ti denotes the number of days required to complete the job. For each day of delay before starting to work for job i, a loss of Li is incurred.
	We are required to find a sequence to complete the jobs so that overall loss is minimized. We can only work on one job at a time.

	If multiple such solutions are possible, then we are required to give the lexicographically least permutation (i.e earliest in dictionary order).
*/

/*

	NOTE:

	Instead of sorting by Loss or Time we have to sort by (Loss / Time).
	This is based on the following reasons
	1. If all times are same, it is better to sequence jobs with bigger loss first
	2. If all losses are same, it is better to sequence jobs with lesser times first

	In order to maintain precision, do not compare with decimals.
	Instead, if we have to compare (a / b) and (c / d), compare ad and bc.
*/

import java.util.Arrays;
public class Problem5
{
	static class Job implements Comparable<Job>
	{
		int id;
		int loss;
		int days;

		Job(int id, int loss, int days)
		{
			this.id = id;
			this.loss = loss;
			this.days = days;
		}

		public int compareTo(Job b)
		{
			return ((b.loss * this.days) - (b.days * this.loss));
		}
	}

	public static void main(String[] args)
	{
		// Job[] jobs = {new Job(1, 3, 4), new Job(2, 1, 1000), new Job(3, 2, 2), new Job(4, 4, 5)};
		Job[] jobs = {new Job(1, 1, 2), new Job(2, 2, 4), new Job(3, 3, 1), new Job(4, 5, 3), new Job(5, 6, 2)};
		printJobs(getMinimumLossJobs(jobs));
	}

	public static Job[] getMinimumLossJobs(Job[] jobs)
	{
		Arrays.sort(jobs);
		return jobs;
	}

	public static void printJobs(Job[] jobs)
	{
		for(int i = 0; i < jobs.length; i++)
		{
			System.out.print(jobs[i].id + " ");
		}
		System.out.println();
	}
}

/*
	Time Complexity: O(nlogn)
	Space Complexity: O(1)
*/

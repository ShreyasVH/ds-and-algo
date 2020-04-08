/*
	Job Selection Problem – Loss Minimization Strategy | Set 2
	We have discussed one loss minimization strategy before: Job Sequencing Problem – Loss Minimization. In this article, we will look at another strategy that applies to a slightly different problem.

	We are given a sequence of N goods of production numbered from 1 to N. Each good has a volume denoted by (Vi). The constraint is that once a good has been completed its volume starts decaying at a fixed percentage (P) per day. All goods decay at the same rate and further each good take one day to complete.

	We are required to find the order in which the goods should be produced so that overall volume of goods is maximized.



	Example-1:

	Input: 4, 2, 151, 15, 1, 52, 12 and P = 10%
	Output: 222.503
	Solution: In the optimum sequence of jobs, the total volume of goods left at the end of all jobs is 222.503

	Example-2:

	Input: 3, 1, 41, 52, 15, 4, 1, 63, 12 and P = 20%
	Output: 145.742
	Solution: In the optimum sequence of jobs the total volume of goods left at the end of all jobs is 145.72
*/
import java.util.Arrays;
public class Problem6
{
	public static void main(String[] args)
	{
		System.out.println(getMaxVolume(new int[]{4, 2, 151, 15, 1, 52, 12}, 10));

		System.out.println(getMaxVolume(new int[]{3, 1, 41, 52, 15, 4, 1, 63, 12}, 20));

		System.out.println(getMaxVolume(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
	}

	public static double getMaxVolume(int[] volumes, int decayRate)
	{
		Arrays.sort(volumes);
		double result = 0;

		for(int i = 0; i < volumes.length; i++)
		{
			result += (volumes[i] * pow((1 - (decayRate / 100.0)), (volumes.length - 1 - i)));
		}

		return result;
	}

	public static double pow(double d, int n)
	{
		double result = 1;

		for(int i = 1; i <= n; i++)
		{
			result *= d;
		}

		return result;
	}
}
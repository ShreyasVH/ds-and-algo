/*
	Given an array arr[] of n integers, find the maximum that maximizes the sum of the value of i*arr[i] where i varies from 0 to n-1.
*/

public class Problem8a
{
	public static void main(String[] args)
	{
		int[] nums = {1, 20, 2, 10};
		// int[] nums = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		// int[] nums = {8, 3, 1, 2};
		// int[] nums = {3, 2, 1};
		System.out.println(maxSum(nums));
	}

	public static int maxSum(int[] nums)
	{
		int n = nums.length;
		int maxSum = Integer.MIN_VALUE;

		for(int i = 0; i < n; i++)
		{
			int sum = 0;
			for(int j = 0; j < n; j++)
			{
				sum += (j * nums[(i + j) % n]);
			}
			if(sum > maxSum)
			{
				maxSum = sum;
			}
		}

		return maxSum;
	}
}

/*
	Time Complexity: O(n^2)
	Space Complexity: O(1)
*/
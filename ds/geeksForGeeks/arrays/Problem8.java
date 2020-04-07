/*
	Given an array arr[] of n integers, find the maximum that maximizes the sum of the value of i*arr[i] where i varies from 0 to n-1.
*/

public class Problem8
{
	public static void main(String[] args)
	{
		// int[] nums = {1, 20, 2, 10};
		// int[] nums = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		// int[] nums = {8, 3, 1, 2};
		int[] nums = {3, 2, 1};
		System.out.println(maxSum(nums));
	}

	public static int maxSum(int[] nums)
	{
		int n = nums.length;
		int sum = 0;
		int[] s = new int[n];
		for(int i = 0; i < n; i++)
		{
			sum += nums[i];
			s[0] += (i * nums[i]);
		}
		int maxSum = s[0];

		for(int i = 1; i < n; i++)
		{
			s[i] = (s[i - 1] + sum - (n * nums[n - i]));
			if(s[i] > maxSum)
			{
				maxSum = s[i];
			}
		}

		return maxSum;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
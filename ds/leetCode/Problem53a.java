/*
	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

	Example:

	Input: [-2,1,-3,4,-1,2,1,-5,4],
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
*/

class Solution
{
	public static void main(String[] args)
	{
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		Solution problem = new Solution();
		System.out.println(problem.maxSubArray(nums));
	}

	public int maxSumThroughMiddle(int[] nums, int low, int high, int middle)
	{
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = middle; i >= low; i--)
		{
			sum += nums[i];

			if(sum > leftSum)
			{
				leftSum = sum;
			}
		}

		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for(int i = (middle + 1); i <= high; i++)
		{
			sum += nums[i];

			if(sum > rightSum)
			{
				rightSum = sum;
			}
		}

		return (leftSum + rightSum);
	}

	public int maxSubArray(int[] nums)
	{
		return maxSubArray(nums, 0, nums.length - 1);
	}

	public int maxSubArray(int[] nums, int low, int high)
	{
		int sum = Integer.MIN_VALUE;
		if(low == high)
		{
			sum = nums[low];
		}
		else
		{
			int middle = ((low + high) / 2);
			sum = Integer.max(Integer.max(maxSubArray(nums, low, middle), maxSubArray(nums, (middle + 1), high)), maxSumThroughMiddle(nums, low, high, middle));
		}

		return sum;
    }
}

/*
	Time complexity: O(nlogn)
	Space Complexity: O(1)
*/
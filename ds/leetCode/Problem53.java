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

	public int maxSubArray(int[] nums)
	{
    	int maxSum = nums[0];
    	int curSum = nums[0];

    	for(int i = 1; i < nums.length; i++)
    	{
    		curSum = Integer.max((curSum + nums[i]), nums[i]);
    		maxSum = Integer.max(maxSum, curSum);
    	}

    	return maxSum;
    }
}

/*
	Time complexity: O(n)
	Space Complexity: O(1)
*/
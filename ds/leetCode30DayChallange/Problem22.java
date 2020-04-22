/*
	Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

	Example 1:
	Input:nums = [1,1,1], k = 2
	Output: 2
	Note:
	The length of the array is in range [1, 20,000].
	The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/
import java.util.Map;
import java.util.HashMap;
class Solution
{
	public int subarraySum(int[] nums, int k)
	{
		int result = 0;
		Map<Integer, Integer> m = new HashMap<>();

		int curSum = 0;
		for(int i = 0; i < nums.length; i++)
		{
			curSum += nums[i];

			if(curSum == k)
			{
				result++;
			}

			if(m.containsKey(curSum - k))
			{
				result += m.get(curSum - k);
			}

			if(m.containsKey(curSum))
			{
				m.put(curSum, m.get(curSum) + 1);
			}
			else
			{
				m.put(curSum, 1);
			}
		}
		return result;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
    	System.out.println(s.subarraySum(new int[]{1}, 0));
    	System.out.println(s.subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }
}
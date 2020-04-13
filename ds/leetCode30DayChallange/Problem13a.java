/*
	Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

	Example 1:
	Input: [0,1]
	Output: 2
	Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
	Example 2:
	Input: [0,1,0]
	Output: 2
	Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
	Note: The length of the given binary array will not exceed 50,000.
*/

class Solution
{
	public int findMaxLength(int[] nums)
	{
		int maxLength = 0;

		int n = nums.length;
		
		for(int i = 1; i < n; i++)
		{
			int start = i - 1;
			int end = i;

			int sum = 0;
			while((start >= 0) && (end < n))
			{
				sum += nums[start] + nums[end];
				int length = (end + 1 - start);
				if((sum == (length / 2)) && length > maxLength)
				{
					maxLength = length;
				}
				start--;
				end++;
			}
		}

		return maxLength;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.findMaxLength(new int[]{0, 1}));
    	System.out.println(s.findMaxLength(new int[]{0, 1, 0}));
    }
}
/*
	Time Complexity: O(n^2)
	Space Complexity: O(1)
*/
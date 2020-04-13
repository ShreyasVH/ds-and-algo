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
		
		for(int start = 0; start < (n - 1); start++)
		{
			int sum = nums[start];
			for(int end = start + 1; end < n; end++)
			{
				sum += nums[end];
				
				int length = (end + 1 - start);
				if(((length % 2) == 0) && (sum == (length / 2)) && (length > maxLength))
				{
					maxLength = length;
				}
			}
		}

		return maxLength;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.findMaxLength(new int[]{0, 1}));
    	System.out.println(s.findMaxLength(new int[]{0, 1, 0}));
    	System.out.println(s.findMaxLength(new int[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1}));
    	System.out.println(s.findMaxLength(new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0}));
    	System.out.println(s.findMaxLength(new int[]{0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1}));
    	System.out.println(s.findMaxLength(new int[]{1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0}));
    	System.out.println(s.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
    }
}

/*
	Time Complexity: O(n^2)
	Space Complexity: O(1)
*/
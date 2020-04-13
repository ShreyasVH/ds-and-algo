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
		int[][] sum = new int[n][n];

		for(int i = 0; i < n; i++)
		{
			sum[i][i] = nums[i];
		}

		for(int len = 2; len <= n; len++)
		{
			for(int i = 0; i <= (n - len); i++)
			{
				sum[i][i + len - 1] = sum[i][i + len - 2] + nums[i + len - 1];

				if(((len % 2) == 0) && (sum[i][i + len - 1] == (len / 2)) && (len > maxLength))
				{
					maxLength = len;
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
    }
}
/*
	Time Complexity: O(n^2)
	Space Complexity: O(n^2)
*/
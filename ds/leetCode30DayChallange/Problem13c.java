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
import java.util.Map;
import java.util.HashMap;
class Solution
{
	public int findMaxLength(int[] nums)
	{
		int maxLength = 0;

		int n = nums.length;
		
		for(int i = 0; i < n; i++)
		{
			if(nums[i] == 0)
			{
				nums[i] = -1;
			}
		}

		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum += nums[i];

			if(0 == sum)
			{
				int length = (i + 1);
				if(length > maxLength)
				{
					maxLength = length;
				}
			}
			else
			{
				if(map.containsKey(sum))
				{
					int lastIndex = map.get(sum);
					int length = (i - lastIndex);
					if(length > maxLength)
					{
						maxLength = length;
					}
				}
				else
				{
					map.put(sum, i);
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
	Time Complexity: O(n)
	Space Complexity: O(n)
*/
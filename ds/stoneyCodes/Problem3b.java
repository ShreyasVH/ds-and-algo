/*
Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

*/

package ds.stoneyCodes;

import java.util.*;

public class Problem3b
{
	public static void main(String args[])
	{

		Problem3b problem = new Problem3b();

		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		System.out.println(problem.findDisappearedNumbers(nums));

		nums = new int[]{1, 1};
		System.out.println(problem.findDisappearedNumbers(nums));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num: nums)
        {
    		markIndex(nums, num);
        }

        for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] > 0)
        	{
        		result.add(i + 1);
        	}
        }

        return result;
    }

    public void markIndex(int[] nums, int num)
    {
    	int index = Math.abs(num) - 1;
    	if(nums[index] > 0)
    	{
    		nums[index] = -1 * nums[index];
    	}
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for output list]
*/
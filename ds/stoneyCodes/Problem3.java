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

public class Problem3
{
	public static void main(String args[])
	{

		Problem3 problem = new Problem3();

		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		System.out.println(problem.findDisappearedNumbers(nums));

		nums = new int[]{1, 1};
		System.out.println(problem.findDisappearedNumbers(nums));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int num: nums)
        {
        	set.add(num);
        }

        for(int i = 1; i <= nums.length; i++)
        {
        	if(!set.contains(i))
        	{
        		result.add(i);
        	}
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
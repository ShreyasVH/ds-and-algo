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

public class Problem3a
{
	public static void main(String args[])
	{

		Problem3a problem = new Problem3a();

		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		System.out.println(problem.findDisappearedNumbers(nums));

		nums = new int[]{1, 1};
		System.out.println(problem.findDisappearedNumbers(nums));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
        	while(nums[nums[i] - 1] != nums[i])
        	{
        		int num = nums[i];
	        	int correctIndex = num - 1;

	        	if(nums[correctIndex] != num)
	        	{
	        		int temp = nums[correctIndex];
	        		nums[correctIndex] = num;
	        		nums[i] = temp;
	        	}
        	}
        }

        for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] != i + 1)
        	{
        		result.add(i + 1);
        	}
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for output list]
*/
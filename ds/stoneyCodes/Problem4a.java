/*
Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;

public class Problem4a
{
	public static void main(String args[])
	{

		Problem4a problem = new Problem4a();

		int[] nums = {2, 7, 11, 15};
        int target = 9;
		ArrayUtils.print(problem.twoSum(nums, target));

		nums = new int[]{3, 2, 4};
        target = 6;
		ArrayUtils.print(problem.twoSum(nums, target));

        nums = new int[]{3, 3};
        target = 6;
        ArrayUtils.print(problem.twoSum(nums, target));
	}

	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            int requiredNum = target - nums[i];
            if(map.containsKey(requiredNum))
            {
                return new int[]{i, map.get(requiredNum)};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
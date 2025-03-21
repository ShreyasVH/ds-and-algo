/*
Maximum Subarray

Given an integer array nums, find the subarray with the largest sum, and return its sum. 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem19
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println((int) clazz.getMethod("maxSubArray", int[].class).invoke(problem, nums));

        nums = new int[]{1};
        System.out.println((int) clazz.getMethod("maxSubArray", int[].class).invoke(problem, nums));

        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println((int) clazz.getMethod("maxSubArray", int[].class).invoke(problem, nums));
	}

	public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
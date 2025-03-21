/*
Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4


*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem15
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println((int) clazz.getMethod("minSubArrayLen", int.class, int[].class).invoke(problem, target, nums));

        nums = new int[]{1,4,4};
        target = 4;
        System.out.println((int) clazz.getMethod("minSubArrayLen", int.class, int[].class).invoke(problem, target, nums));

        nums = new int[]{1,1,1,1,1,1,1,1};
        target = 11;
        System.out.println((int) clazz.getMethod("minSubArrayLen", int.class, int[].class).invoke(problem, target, nums));
	}

	public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for(int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if(sum >= target)
                {
                    len = Math.min(len, j - i + 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}


/*
Time complexity: 
Space complexity: 
*/
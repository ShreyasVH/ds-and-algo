/*
Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1 

Constraints:

1 <= nums.length <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element which appears only once.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem16
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {2,2,1};
        System.out.println((int) clazz.getMethod("singleNumber", int[].class).invoke(problem, nums));

        nums = new int[]{4,1,2,1,2};
        System.out.println((int) clazz.getMethod("singleNumber", int[].class).invoke(problem, nums));

        nums = new int[]{1};
        System.out.println((int) clazz.getMethod("singleNumber", int[].class).invoke(problem, nums));
	}

	public int singleNumber(int[] nums) {
        if(nums.length == 1)
        {
            return nums[0];
        }

        for(int i = 0; i < nums.length; i++)
        {
            int count = 0;
            for(int j = 0; j < nums.length; j++)
            {
                if(nums[i] == nums[j])
                {
                    count++;
                }
            }

            if(count == 1)
            {
                return nums[i];
            }
        }

        return -1;
    }
}


/*
Time complexity: O(n^2)
Space complexity: O(1)
*/
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

public class Problem16a
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
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if(entry.getValue() == 1)
            {
                return entry.getKey();
            }
        }

        return -1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
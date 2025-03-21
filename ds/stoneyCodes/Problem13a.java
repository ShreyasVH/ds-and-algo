/*
Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem13a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println((boolean) clazz.getMethod("containsNearbyDuplicate", int[].class, int.class).invoke(problem, nums, k));

        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println((boolean) clazz.getMethod("containsNearbyDuplicate", int[].class, int.class).invoke(problem, nums, k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println((boolean) clazz.getMethod("containsNearbyDuplicate", int[].class, int.class).invoke(problem, nums, k));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(set.contains(nums[i]))
            {
                return true;
            }

            set.add(nums[i]);

            if(set.size() > k)
            {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}


/*
Time complexity: O(n)
Space complexity: O(k)
*/
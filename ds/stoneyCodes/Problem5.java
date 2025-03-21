/*
How Many Numbers Are Smaller Than the Current Number

Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100



*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem5
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        // Create an instance using the default constructor
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {8, 1, 2, 2, 3};
        ArrayUtils.print((int[]) clazz.getMethod("smallerNumbersThanCurrent", int[].class).invoke(problem, nums));

        nums = new int[]{6, 5, 4, 8};
        ArrayUtils.print((int[]) clazz.getMethod("smallerNumbersThanCurrent", int[].class).invoke(problem, nums));

        nums = new int[]{7, 7, 7, 7};
        ArrayUtils.print((int[]) clazz.getMethod("smallerNumbersThanCurrent", int[].class).invoke(problem, nums));
	}

	public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            int count = 0;
            for (int num: nums)
            {
                if(num < nums[i])
                {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }
}


/*
Time complexity: O(n^2)
Space complexity: O(n) [for result]
*/
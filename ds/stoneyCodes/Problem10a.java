/*
Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem10a
{
    public static void main(String args[]) throws Exception
    {

        Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {-4, -1, 0, 3, 10};
        ArrayUtils.print((int[]) clazz.getMethod("sortedSquares", int[].class).invoke(problem, nums));

        nums = new int[]{-7, -3, 2, 3, 11};
        ArrayUtils.print((int[]) clazz.getMethod("sortedSquares", int[].class).invoke(problem, nums));
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;

        int index = nums.length - 1;

        while(l <= r)
        {
            if(nums[l] * nums[l] > nums[r] * nums[r])
            {
                result[index] = nums[l] * nums[l];
                l++;
            }
            else
            {
                result[index] = nums[r] * nums[r];
                r--;
            }
            index--;
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) for result
*/
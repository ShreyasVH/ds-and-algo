/*
Longest Mountain in Array

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.
 

Constraints:

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^4

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem12
{
    public static void main(String args[]) throws Exception
    {

        Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {2,1,4,7,3,2,5};
        System.out.println((int) clazz.getMethod("longestMountain", int[].class).invoke(problem, nums));

        nums = new int[]{2,2,2};
        System.out.println((int) clazz.getMethod("longestMountain", int[].class).invoke(problem, nums));
    }

    public int longestMountain(int[] arr) {
        int len = 0;

        for(int i = 0; i < arr.length; i++)
        {
            int j = i + 1;
            int inc = 0;
            int dec = 0;

            while (j < arr.length && arr[j] > arr[j - 1])
            {
                inc = 1;
                j++;
            }

            while(j < arr.length && arr[j] < arr[j - 1])
            {
                dec = 1;
                j++;
            }

            if(inc == 1 && dec == 1)
            {
                len = Math.max(len, j - i);
            }

        }

        return len;
        
    }
}


/*
Time complexity: O(n) [at max each element is visited twice]
Space complexity: O(1)
*/
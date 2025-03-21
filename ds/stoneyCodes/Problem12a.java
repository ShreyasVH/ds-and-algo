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

public class Problem12a
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

        for(int i = 1; i < arr.length - 1; i++)
        {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
            {
                int l = i - 1;
                int r = i + 1;
                while(l > 0 && arr[l] > arr[l - 1])
                {
                    l--;
                }

                while(r < arr.length - 1 && arr[r] > arr[r + 1])
                {
                    r++;
                }

                len = Math.max(len, r - l + 1);

                i = r;
            }

        }

        return len;
        
    }
}


/*
Time complexity: O(n) [at max each element is visited twice]
Space complexity: O(1)
*/
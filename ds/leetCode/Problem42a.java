/*
Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5
*/

package ds.leetCode;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem42a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println((int) clazz.getMethod("trap", int[].class).invoke(problem, arr));

        System.out.println("---------------------------------");

        arr = new int[]{4,2,0,3,2,5};
        System.out.println((int) clazz.getMethod("trap", int[].class).invoke(problem, arr));
	}

	public int trap(int arr[]) {
        int l = 0;
        int r = arr.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int total = 0;

        while(l < r)
        {
            if(arr[l] < arr[r])
            {
                if(arr[l] > leftMax)
                {
                    leftMax = arr[l];
                }
                else
                {
                    total += leftMax - arr[l];
                }
                l++;
            }
            else
            {
                if(arr[r] > rightMax)
                {
                    rightMax = arr[r];
                }
                else
                {
                    total += rightMax - arr[r];
                }
                r--;
            }
        }

        return total;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
/*
Trapping Rain Water

Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.

Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.

Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.

Constraints:
1 < arr.size() < 10^5
0 < arr[i] < 10^3

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem701211a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {3, 0, 1, 0, 4, 0, 2};
        System.out.println((int) clazz.getMethod("maxWater", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------");

        arr = new int[]{3, 0, 2, 0, 4};
        System.out.println((int) clazz.getMethod("maxWater", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------");

        arr = new int[]{1, 2, 3, 4};
        System.out.println((int) clazz.getMethod("maxWater", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------");

        arr = new int[]{2, 1, 5, 3, 1, 0, 4};
        System.out.println((int) clazz.getMethod("maxWater", int[].class).invoke(problem, arr));
	}

	public int maxWater(int arr[]) {
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
Time complexity: 
Space complexity: 
*/
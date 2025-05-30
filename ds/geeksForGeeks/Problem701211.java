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

public class Problem701211
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
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = 0;
        right[0] = 0;

        for(int i = 1; i < arr.length; i++)
        {
            left[i] = Math.max(left[i - 1], arr[i - 1]);
        }

        for(int i = arr.length - 2; i >= 0; i--)
        {
            right[i] = Math.max(right[i + 1], arr[i + 1]);
        }

        int total = 0;

        for(int i = 0; i < arr.length; i++)
        {
            int min = Math.min(left[i], right[i]);
            if(arr[i] < min)
            {
                total += (min - arr[i]);
            }
        }

        return total;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
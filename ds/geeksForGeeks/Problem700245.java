/*
Largest subarray of 0's and 1's

Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

Examples:

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.

Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.

Input: arr[] = [0]
Output: 0
Explnation: There is no subarray with an equal number of 0s and 1s.

Constraints:
1 <= arr.size() <= 10^5
0 <= arr[i] <= 1

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700245
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        System.out.println((int) clazz.getMethod("maxLen", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------------------------");

        arr = new int[]{0, 0, 1, 1, 0};
        System.out.println((int) clazz.getMethod("maxLen", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------------------------");

        arr = new int[]{0};
        System.out.println((int) clazz.getMethod("maxLen", int[].class).invoke(problem, arr));
	}

	public int maxLen(int[] arr) {
        int[] sumArray = new int[arr.length + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            sumArray[i] = sumArray[i + 1] + arr[i];
        }

        int max = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int len = j - i + 1;
                int sum = sumArray[i] - sumArray[j + 1];

                if ((2 * sum == len) && len > max) {
                    max = len;
                }
            }
        }

        return max;
    }
}


/*
Time complexity: O(n ^ 2)
Space complexity: O(n)
*/
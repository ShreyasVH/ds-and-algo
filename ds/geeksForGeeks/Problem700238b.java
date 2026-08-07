/*
First Occurrence in Sorted

Given a sorted array arr[] and an integer k, find the position(0-based indexing) at which k is present in the array using binary search. If k doesn't exist in arr[] return -1. 

Note: If multiple occurrences are there, please return the smallest index.

Examples:

Input: arr[] = [1, 2, 3, 4, 5], k = 4
Output: 3
Explanation: 4 appears at index 3.
Input: arr[] = [11, 22, 33, 44, 55], k = 445
Output: -1
Explanation: 445 is not present.
Input: arr[] = [1, 1, 1, 1, 2], k = 1
Output: 0
Explanation: 1 appears at index 0.
Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^6
1 ≤ k ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700238b
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.println((int) clazz.getMethod("firstSearch", int[].class, int.class).invoke(problem, arr, k));

        System.out.println("-------------------------------------------------------");

        arr = new int[]{11, 22, 33, 44, 55};
        k = 445;
        System.out.println((int) clazz.getMethod("firstSearch", int[].class, int.class).invoke(problem, arr, k));

        System.out.println("-------------------------------------------------------");

        arr = new int[]{1, 1, 1, 1, 2};
        k = 1;
        System.out.println((int) clazz.getMethod("firstSearch", int[].class, int.class).invoke(problem, arr, k));
	}

	public int firstSearch(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        int pos = -1;

        while (l <= r) {
            int m = l + ((r - l) / 2);

            if (arr[m] == k) {
                if (m == 0 || arr[m - 1] != k) {
                    pos = m;
                    break;
                }
                r = m - 1;
            } else if (k < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return pos;
    }
}


/*
Time complexity: O(log n)
Space complexity: O(1)
*/
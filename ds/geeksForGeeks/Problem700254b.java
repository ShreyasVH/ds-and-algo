/*
Largest subarray with 0 sum

Given an array arr[] containing both positive and negative integers, the task is to find the length of the longest subarray with a sum equals to 0.

Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].

Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.

Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]

Constraints:
1 ≤ arr.size() ≤ 10^6
−10^3 ≤ arr[i] ≤ 10^3
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700254b
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println((int) clazz.getMethod("maxLength", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------------------------");

        arr = new int[]{2, 10, 4};
        System.out.println((int) clazz.getMethod("maxLength", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------------------------");

        arr = new int[]{1, 0, -4, 3, 1, 0};
        System.out.println((int) clazz.getMethod("maxLength", int[].class).invoke(problem, arr));
	}

	public int maxLength(int arr[]) {
        int max = 0;

        Map<Integer, Integer> firstSeen = new HashMap<>();

        int sum = 0;
        firstSeen.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (firstSeen.containsKey(sum)) {
                max = Math.max(max, i - firstSeen.get(sum));
            } else {
                firstSeen.put(sum, i);
            }
        }

        return max;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
/*
Find Transition Point
Difficulty: EasyAccuracy: 37.9%Submissions: 273K+Points: 2Average Time: 20m
Given a sorted array, arr[] containing only 0s and 1s, find the transition point, i.e., the first index where 1 was observed, and before that, only 0 was observed.  If arr does not have any 1, return -1. If array does not have any 0, return 0.

Examples:

Input: arr[] = [0, 0, 0, 1, 1]
Output: 3
Explanation: index 3 is the transition point where 1 begins.

Input: arr[] = [0, 0, 0, 0]
Output: -1
Explanation: Since, there is no "1", the answer is -1.

Input: arr[] = [1, 1, 1]
Output: 0
Explanation: There are no 0s in the array, so the transition point is 0, indicating that the first index (which contains 1) is also the first position of the array.

Input: arr[] = [0, 1, 1]
Output: 1
Explanation: Index 1 is the transition point where 1 starts, and before it, only 0 was observed.

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 1

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700194
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {0, 0, 0, 1, 1};
        System.out.println((int) clazz.getMethod("transitionPoint", int[].class).invoke(problem, arr));

        System.out.println("-----------------");

        arr = new int[]{0, 0, 0, 0};
        System.out.println((int) clazz.getMethod("transitionPoint", int[].class).invoke(problem, arr));

        System.out.println("-----------------");

        arr = new int[]{1, 1, 1};
        System.out.println((int) clazz.getMethod("transitionPoint", int[].class).invoke(problem, arr));

        System.out.println("-----------------");

        arr = new int[]{0, 1, 1};
        System.out.println((int) clazz.getMethod("transitionPoint", int[].class).invoke(problem, arr));
	}

	public int transitionPoint(int arr[]) {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}


/*
Time complexity: 
Space complexity: 
*/
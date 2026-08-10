/*
Max Sum Path in Two Arrays

Given two sorted arrays of distinct integers in increasing order a[] and b[], which may have some common elements, find the maximum sum of a path from the beginning of any array to the end of any array. You may switch from one array to the other only at common elements.

Note:  When switching, count the common element only once.

Examples : 

Input: a[] = [2, 3, 7, 10, 12], b[] = [1, 5, 7, 8]
Output: 35
Explanation: The path will be (1 + 5 + 7 + 10 + 12) = 35, where 1 and 5 come from arr2 and then 7 is common so we switch to arr1 and add 10 and 12.

Input: a[] = [1, 2, 3], b[] = [3, 4, 5]
Output: 15
Explanation: The path will be (1 + 2 + 3 + 4 + 5) = 15.

Constraints:
1 ≤ a.size(), b.size() ≤ 104
1 ≤ a[i], b[i] ≤ 105

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700241a
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] a = {2, 3, 7, 10, 12};
        int[] b = {1, 5, 7, 8};
        System.out.println((int) clazz.getMethod("maxPathSum", int[].class, int[].class).invoke(problem, a, b));

        System.out.println("-------------------------------------------------------");

        a = new int[]{1, 2, 3};
        b = new int[]{3, 4, 5};
        System.out.println((int) clazz.getMethod("maxPathSum", int[].class, int[].class).invoke(problem, a, b));

        System.out.println("-------------------------------------------------------");

        a = new int[]{1, 2, 3};
        b = new int[]{4, 5, 6};
        System.out.println((int) clazz.getMethod("maxPathSum", int[].class, int[].class).invoke(problem, a, b));

        System.out.println("-------------------------------------------------------");

        a = new int[]{1, 2, 3, 4};
        b = new int[]{4, 5, 6};
        System.out.println((int) clazz.getMethod("maxPathSum", int[].class, int[].class).invoke(problem, a, b));
	}

	public int maxPathSum(int[] a, int[] b) {
        List<Integer> common = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int i: b) {
            set.add(i);
        }

        for (int j: a) {
            if (set.contains(j)) {
                common.add(j);
            }
        }

        // System.out.println(common);

        int i = 0;
        int j = 0;
        int result = 0;

        int sumA = 0;
        int sumB = 0;

        for (int c: common) {    
            while (i < a.length && a[i] < c) {
                sumA += a[i];
                i++;
            }

            while (j < b.length && b[j] < c) {
                sumB += b[j];
                j++;
            }

            result += Math.max(sumA, sumB) + c;
            sumA = 0;
            sumB = 0;

            i++;
            j++;
        }

        while (i < a.length) {
            sumA += a[i];
            i++;
        }

        while (j < b.length) {
            sumB += b[j];
            j++;
        }
        result += Math.max(sumA, sumB);

        return result;
    }
}


/*
Time complexity: O(n + m)
Space complexity: O(n + m)
*/
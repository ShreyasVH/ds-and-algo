/*
Unique Number I

Given a unsorted array arr[] of positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

Examples :

Input: arr[] = [1, 2, 1, 5, 5]
Output: 2
Explanation: Since 2 occurs once, while other numbers occur twice, 2 is the answer.

Input: arr[] = [2, 30, 2, 15, 20, 30, 15]
Output: 20
Explanation: Since 20 occurs once, while other numbers occur twice, 20 is the answer.

Constraints
1 ≤  arr.size()  ≤ 10^6
0 ≤ arr[i] ≤ 10^9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem893307b
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {1, 2, 1, 5, 5};
        System.out.println((int) clazz.getMethod("findUnique", int[].class).invoke(problem, arr));

        System.out.println("---------------------");

        arr = new int[]{2, 30, 2, 15, 20, 30, 15};
        System.out.println((int) clazz.getMethod("findUnique", int[].class).invoke(problem, arr));
	}

	public int findUnique(int[] arr) {
        int unique = 0;

        for(int num: arr)
        {
            unique ^= num;
        }

        return unique;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
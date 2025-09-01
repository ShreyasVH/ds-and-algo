/*
Square Root

Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number.

Examples:

Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.

Input: n = 11
Output: 3
Explanation: Since, 11 is not a perfect square, floor of square root of 11 is 3.

Input: n = 1
Output: 1
Explanation: 1 is a perfect sqaure, so its square root is 1.

Constraints:
1 ≤ n ≤ 3*10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700226a
{
    public static void main(String args[]) throws Exception
    {

        Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int n = 4;
        System.out.println((int) clazz.getMethod("floorSqrt", int.class).invoke(problem, n));

        System.out.println("-------------------------------------------------------");

        n = 11;
        System.out.println((int) clazz.getMethod("floorSqrt", int.class).invoke(problem, n));

        System.out.println("-------------------------------------------------------");

        n = 1;
        System.out.println((int) clazz.getMethod("floorSqrt", int.class).invoke(problem, n));
    }

    public int floorSqrt(int n) {
        int sqrt = 1;

        int l = 1;
        int r = n;

        int mid = 1;
        while(l <= r)
        {
            mid = l + (r - l) / 2;

            if(mid * mid <= n)
            {
                sqrt = mid;
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }

        return sqrt;
    }
}


/*
Time complexity: O(log n)
Space complexity: O(1)
*/
/*
Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 10^5

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem20
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int n = 2;
        ArrayUtils.print((int[]) clazz.getMethod("countBits", int.class).invoke(problem, n));

        n = 5;
        ArrayUtils.print((int[]) clazz.getMethod("countBits", int.class).invoke(problem, n));
	}

	public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int offset = 1;

        for(int i = 1; i <= n; i++)
        {
            if (offset * 2 == i)
            {
                offset = i;
            }

            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
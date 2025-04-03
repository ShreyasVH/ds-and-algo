/*
Power of Four

Given a number N, check if N is power of 4 or not.

Example 1:

Input: 
N = 64
Output: 1
Explanation:
43= 64

Example 2:

Input: 
N = 75
Output : 0
Explanation :
75 is not a power of 4.

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700129c
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        long n = 64l;
        System.out.println((int) clazz.getMethod("isPowerOfFour", long.class).invoke(problem, n));

        n = 75l;
        System.out.println((int) clazz.getMethod("isPowerOfFour", long.class).invoke(problem, n));

        n = 384l;
        System.out.println((int) clazz.getMethod("isPowerOfFour", long.class).invoke(problem, n));
	}

	public int isPowerOfFour(long n)
    {
        if(n <= 0)
        {
            return 0;
        }

        if(((n & (n - 1)) == 0) && ((n & 0xAAAAAAAA) == 0))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}


/*
Time complexity: O(1)
Space complexity: O(1)
*/
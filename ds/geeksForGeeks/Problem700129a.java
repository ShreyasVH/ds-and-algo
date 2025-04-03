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

public class Problem700129a
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
        if(n == 0)
        {
            return 0;
        }
        while(n != 1)
        {
            if(n % 4 != 0)
            {
                return 0;
            }
            n = n / 4;
        }
        return 1;
    }
}


/*
Time complexity: O(log n) [base 4]
Space complexity: O(1)
*/
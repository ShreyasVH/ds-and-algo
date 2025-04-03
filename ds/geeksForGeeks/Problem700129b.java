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

public class Problem700129b
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
        if (n != 0 && Math.ceil(Math.log(n) * 1.0 / Math.log(4)) == Math.floor(Math.log(n) * 1.0 / Math.log(4))) {
            return 1;
        }
        return 0;
    }
}


/*
Time complexity: O(1)
Space complexity: O(1)
*/
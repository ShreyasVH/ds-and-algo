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

public class Problem700129
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
        StringBuilder sb = new StringBuilder();

        while(n >= 4)
        {
            long reminder = n % 4;
            sb.append(reminder);
            n = n / 4;
        }

        sb.append(n);

        int length = sb.length();
        int setBits = 0;

        for (int i = 0; i < length; i++)
        {
            if(sb.charAt(i) == '0')
            {
                continue;
            }
            else if(sb.charAt(i) == '1')
            {
                setBits++;
            }
            else
            {
                return 0;
            }
        }

        return (setBits == 1) ? 1 : 0;
    }
}


/*
Time complexity: O(log n) [base 4]
Space complexity: O(log n) [for stringbuilder]
*/
/*
Check for Binary String


Given a non-empty sequence of characters s, return true if sequence is Binary, else return false.

Examples:

Input: s = "101"
Output: true
Explanation: Since string contains only '0' and '1', output is true.

Input: s = "75"
Output: false
Explanation: Since string contains digits other than '0' and '1', output is false.

Constraints:
1 <= s.size() <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700133
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        String s = "101";
        System.out.println((boolean) clazz.getMethod("isBinary", String.class).invoke(problem, s));

        System.out.println("---------------------------");

        s = "75";
        System.out.println((boolean) clazz.getMethod("isBinary", String.class).invoke(problem, s));
	}

	public boolean isBinary(String s) {
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch != '1' && ch != '0')
            {
                return false;
            }
        }

        return true;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
/*
Run Length Encoding

Given a string s, implement a function encode that performs run-length encoding on the string. Run-length encoding is a form of compression where consecutive occurrences of the same character are replaced by the character followed by the count of its occurrences.

Examples:

Input: s = aaaabbbccc
Output: a4b3c3
Explanation: The character 'a' repeated 4 times consecutively and 'b' 3 times, 'c' also 3 times, so answer for this test case is a4b3c3.

Input: s = abbbcdddd
Output: a1b3c1d4
Explanation:  The character 'a' is repeated 1 time, 'b' 3 times, 'c' 1 time and 'd' repeated 4 times, so answer for this test case is a1b3c1d4.

Input: s = g
Output: g1

Constraints:
1 ≤ s.size() ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700243
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        String s = "aaaabbbccc";
        System.out.println((String) clazz.getMethod("encode", String.class).invoke(problem, s));

        System.out.println("-------------------------------------------------------");

        s = "abbbcdddd";
        System.out.println((String) clazz.getMethod("encode", String.class).invoke(problem, s));

        System.out.println("-------------------------------------------------------");

        s = "g";
        System.out.println((String) clazz.getMethod("encode", String.class).invoke(problem, s));
	}

	public static String encode(String s) {
        int i = 0;
        int len = s.length();

        StringBuilder output = new StringBuilder();

        while (i < len) {
            char ch = s.charAt(i);

            int count = 0;
            while (i < len && s.charAt(i) == ch) {
                i++;
                count++;
            }

            output.append(ch);
            output.append(count);
        }

        return output.toString();
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
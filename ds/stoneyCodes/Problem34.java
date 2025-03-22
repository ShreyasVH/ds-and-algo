/*
Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([])"
Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem34
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        String s = "()";
        System.out.println((boolean) clazz.getMethod("isValid", String.class).invoke(problem, s));

        s = "()[]{}";
        System.out.println((boolean) clazz.getMethod("isValid", String.class).invoke(problem, s));
        
        s = "(]";
        System.out.println((boolean) clazz.getMethod("isValid", String.class).invoke(problem, s));

        s = "([])";
        System.out.println((boolean) clazz.getMethod("isValid", String.class).invoke(problem, s));

	}

	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
        );  

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                stack.push(ch);
            }
            else
            {
                if(stack.isEmpty() || map.get(stack.pop()) != ch)
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
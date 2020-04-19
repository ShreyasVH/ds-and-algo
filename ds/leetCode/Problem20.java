/*
	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	An input string is valid if:

	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Note that an empty string is also considered valid.

	Example 1:

	Input: "()"
	Output: true
	Example 2:

	Input: "()[]{}"
	Output: true
	Example 3:

	Input: "(]"
	Output: false
	Example 4:

	Input: "([)]"
	Output: false
	Example 5:

	Input: "{[]}"
	Output: true
*/
import java.util.Stack;
class Solution
{
    public boolean isValid(String s)
    {
    	boolean isValid = true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
        	char ch = s.charAt(i);
        	if(isOpeningBracket(ch))
        	{
        		stack.push(ch);
        	}
        	else if(isClosingBracket(ch))
        	{
        		if(stack.empty())
        		{
        			isValid = false;
        			break;
        		}
        		else
        		{
        			if(!isMatchingBracket(stack.peek(), ch))
        			{
        				isValid = false;
        				break;
        			}
        			else
        			{
        				stack.pop();
        			}
        		}
        	}
        }

        return (isValid && stack.empty());
    }

    public boolean isOpeningBracket(char a)
    {
    	return ((a == '(') || (a == '[') || (a == '{'));
    }

    public boolean isClosingBracket(char a)
    {
    	return ((a == ')') || (a == ']') || (a == '}'));
    }

    public boolean isMatchingBracket(char openingBracket, char closingBracket)
    {
    	return (
			(('(' == openingBracket) && (')' == closingBracket))
			|| 
			(('{' == openingBracket) && ('}' == closingBracket))
			|| 
			(('[' == openingBracket) && (']' == closingBracket))
		);
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.isValid("()"));
    	System.out.println(s.isValid("()[]{}"));
    	System.out.println(s.isValid("(]"));
    	System.out.println(s.isValid("([)]"));
    	System.out.println(s.isValid("{[]}"));
    }
}
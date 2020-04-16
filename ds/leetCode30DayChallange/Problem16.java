/*
	Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
	An empty string is also valid.
	Example 1:
	Input: "()"
	Output: True
	Example 2:
	Input: "(*)"
	Output: True
	Example 3:
	Input: "(*))"
	Output: True
	Note:
	The string size will be in the range [1, 100].
*/
class Solution
{
	public boolean checkValidString(String s)
	{
		boolean isValid = true;
		int low = 0;
		int high = 0;
		for(int i = 0; i < s.length(); i++)
		{
			Character c = s.charAt(i);

			if(c == '(')
			{
				low++;
				high++;
			}
			else if(c == ')')
			{
				if(low > 0)
				{
					low--;
				}
				high--;
			}
			else
			{
				if(low > 0)
				{
					low--;
				}
				high++;
			}

			if(high < 0)
			{
				isValid = false;
				break;
			}
		}

		isValid = isValid && (low == 0);
		return isValid;
    }

	public static void main(String[] args)
	{
		Solution s = new Solution();

		System.out.println(s.checkValidString("()"));
		System.out.println(s.checkValidString("(*)"));
		System.out.println(s.checkValidString("(*))"));
	}
}
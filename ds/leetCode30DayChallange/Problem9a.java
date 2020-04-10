/*
	Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

	Example 1:

	Input: S = "ab#c", T = "ad#c"
	Output: true
	Explanation: Both S and T become "ac".
	Example 2:

	Input: S = "ab##", T = "c#d#"
	Output: true
	Explanation: Both S and T become "".
	Example 3:

	Input: S = "a##c", T = "#a#c"
	Output: true
	Explanation: Both S and T become "c".
	Example 4:

	Input: S = "a#c", T = "b"
	Output: false
	Explanation: S becomes "c" while T becomes "b".
	Note:

	1 <= S.length <= 200
	1 <= T.length <= 200
	S and T only contain lowercase letters and '#' characters.
	Follow up:

	Can you solve it in O(N) time and O(1) space?
*/
class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		System.out.println(s.backspaceCompare("ab#c", "ad#c"));
		System.out.println(s.backspaceCompare("ab##", "c#d#"));
		System.out.println(s.backspaceCompare("a##c", "#a#c"));
		System.out.println(s.backspaceCompare("a#c", "b"));

		// System.out.println(s.formatString("abc"));
	}

	public boolean backspaceCompare(String S, String T)
	{
		boolean equal = true;
        String s = formatString(S);
        String t = formatString(T);

        if(s.length() == t.length())
        {
        	for(int i = 0; i < s.length(); i++)
        	{
        		if(s.charAt(i) != t.charAt(i))
        		{
        			equal = false;
        			break;
        		}
        	}
        }
        else
        {
        	equal = false;
        }

        return equal;
    }

    public String formatString(String s)
    {
    	StringBuilder builder = new StringBuilder("");

    	int length = s.length();

    	for(int i = 0; i < length; i++)
    	{
    		char c = s.charAt(i);
    		if(c != '#')
    		{
    			builder.append(c);
    		}
    		else if(builder.length() > 0)
    		{
    			builder.deleteCharAt(builder.length() - 1);
    		}
    	}

    	return builder.toString();
    }
}


/*
	Time Complexity: 
	Space Complexity: 
*/
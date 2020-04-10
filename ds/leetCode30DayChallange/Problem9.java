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
	}

	public boolean backspaceCompare(String S, String T)
	{
        boolean equal = true;

        int i = (S.length() - 1);
        int j = (T.length() - 1);

        while((i >= 0) || (j >= 0))
        {
        	char s = ((i >= 0) ? S.charAt(i) : ' ');
        	char t = ((j >= 0) ? T.charAt(j) : ' ');
        	if((s != '#') && (t != '#'))
        	{
        		if(s == t)
        		{        			
        			i--;
        			j--;
        		}
        		else
        		{
        			equal = false;
        			break;
        		}
        	}
        	else
        	{
				if(s == '#')
				{
					int count = 0;
					while((i >= 0) && (S.charAt(i) == '#'))
					{
						i--;
						count++;
					}
					
					while(count > 0)
					{
						if((i >= 0))
						{
							if(S.charAt(i) != '#')
							{
								count--;
							}
							else
							{
								count++;
							}
						}
						else
						{
							break;
						}
						i--;
					}
				}

				if(t == '#')
				{
					int count = 0;
					while((j >= 0) && (T.charAt(j) == '#'))
					{
						j--;
						count++;
					}

					while(count > 0)
					{
						if((j >= 0))
						{
							if(T.charAt(j) != '#')
							{
								count--;
							}
							else
							{
								count++;
							}
						}
						else
						{
							break;
						}

						j--;
					}
				}
        	}
        }

        return equal;
    }
}


/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
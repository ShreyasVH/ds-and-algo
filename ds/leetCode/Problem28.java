/*
	mplement strStr().

	Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

	Example 1:

	Input: haystack = "hello", needle = "ll"
	Output: 2
	Example 2:

	Input: haystack = "aaaaa", needle = "bba"
	Output: -1
	Clarification:

	What should we return when needle is an empty string? This is a great question to ask during an interview.

	For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

class Solution
{
	public int strStr(String haystack, String needle)
	{
        if(needle.length() == 0)
        {
        	return 0;
        }
        else if(haystack.length() < needle.length())
        {
        	return -1;
        }
        else
        {
        	int pos = -1;

        	for(int i = 0; i <= (haystack.length() - needle.length()); i++)
        	{
        		char ch = haystack.charAt(i);

        		if(ch == needle.charAt(0))
        		{
        			int j;
        			for(j = 0; j < needle.length(); j++)
        			{
        				if(needle.charAt(j) != haystack.charAt(i + j))
        				{
        					break;
        				}
        			}

        			if(j == needle.length())
        			{
        				pos = i;
        				break;
        			}
        		}
        	}

        	return pos;
        }
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.strStr("hello", "ll"));
    	System.out.println(s.strStr("aaaaa", "bba"));
    }
}
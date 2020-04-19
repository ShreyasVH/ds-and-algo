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
        else if(haystack.length() == 0)
        {
        	return -1;
        }
        else
        {
        	int pos = -1;

        	for(int i = 0; i < haystack.length(); i++)
        	{
        		char ch = haystack.charAt(i);

        		if(ch == needle.charAt(0) && i <= (haystack.length() - needle.length()))
        		{
        			if(haystack.substring(i, i + needle.length()).equals(needle))
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
/*
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/
public class Problem5a
{
	public static void main(String[] args)
	{
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aaaa"));
	}

	public static String longestPalindrome(String s)
	{
    	String longestPalindrome = "";

        if(!s.isEmpty() && s.length() > 0)
        {
            int low;
            int high;

            int start = 0;
            int maxLength = 1;

            for(int i = 1; i < s.length(); i++)
            {
                low = i - 1;
                high = i + 1;

                while((low >= 0) && (high < s.length()) && (s.charAt(low) == s.charAt(high)))
                {
                    if(maxLength < (high - low + 1))
                    {
                        start = low;
                        maxLength = (high - low + 1);
                    }
                    low--;
                    high++;
                }

                low = i - 1;
                high = i;

                while((low >= 0) && (high < s.length()) && (s.charAt(low) == s.charAt(high)))
                {
                    if(maxLength < (high - low + 1))
                    {
                        start = low;
                        maxLength = (high - low + 1);
                    }
                    low--;
                    high++;
                }
            }
            longestPalindrome = s.substring(start, start + maxLength);
        }

        return longestPalindrome;
    }
}
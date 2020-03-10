/*
	Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/
public class Problem5
{
	public static void main(String[] args)
	{
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
	}

	public static String longestPalindrome(String s)
	{
    	int n = s.length();
    	boolean[][] data = new boolean[n + 1][n + 1];

    	String longestSubstring = String.valueOf(s.charAt(0));

    	for(int i = 1; i <= n; i++)
    	{
    		data[i][i] = true;
    	}

    	for(int i = 0; i < (n - 1); i++)
    	{
    		if(s.charAt(i) == s.charAt(i+1))
    		{
    			data[i][i+1] = true;
    			if(longestSubstring.length() < 2)
    			{
    				longestSubstring = s.substring(i, i + 2);
    			}
    		}
    	}

    	for(int i = 3; i <= n; i++)
    	{
    		for(int j = 0; j <= (n - i); j++)
    		{
    			boolean isPalindrome = ((data[j + 1][j + i - 2]) && (s.charAt(j) == s.charAt(j + i - 1)));
    			
    			if(isPalindrome)
    			{
    				data[j][j + i - 1] = true;
    				if(longestSubstring.length() < i)
    				{
    					longestSubstring = s.substring(j, j + i);
    				}
    			}
    		}
    	}

    	return longestSubstring;
    }
}
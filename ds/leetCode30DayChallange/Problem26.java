/*
	Given two strings text1 and text2, return the length of their longest common subsequence.

	A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

	 

	If there is no common subsequence, return 0.

	Example 1:
	Input: text1 = "abcde", text2 = "ace" 
	Output: 3  
	Explanation: The longest common subsequence is "ace" and its length is 3.
	
	Example 2:
	Input: text1 = "abc", text2 = "abc"
	Output: 3
	Explanation: The longest common subsequence is "abc" and its length is 3.
	
	Example 3:
	Input: text1 = "abc", text2 = "def"
	Output: 0
	Explanation: There is no such common subsequence, so the result is 0.
*/
class Solution
{
	public int longestCommonSubsequence(String text1, String text2)
	{
		return longestCommonSubsequence(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
    }

	public int longestCommonSubsequence(char[] text1, char[] text2, int m, int n)
    {
    	if((m == 0) || (n == 0))
        {
        	return 0;
        }

        if(text1[m - 1] == text2[n - 1])
        {
        	return (1 + longestCommonSubsequence(text1, text2, m - 1, n - 1));
        }

        return Integer.max(longestCommonSubsequence(text1, text2, m - 1, n), longestCommonSubsequence(text1, text2, m, n - 1));
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.longestCommonSubsequence("abcde", "ace"));
    	System.out.println(s.longestCommonSubsequence("abc", "abc"));
    	System.out.println(s.longestCommonSubsequence("abc", "def"));
    }
}
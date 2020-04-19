/*
	Write a function to find the longest common prefix string amongst an array of strings.

	If there is no common prefix, return an empty string "".

	Example 1:

	Input: ["flower","flow","flight"]
	Output: "fl"
	Example 2:

	Input: ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
	Note:

	All given inputs are in lowercase letters a-z.
*/
import java.util.Arrays;
class Solution
{
    public String longestCommonPrefix(String[] strings)
    {
    	String prefix = "";

        if(strings.length > 0)
        {
            prefix = strings[0];

            for(int i = 1; i < strings.length; i++)
            {
                while(strings[i].indexOf(prefix) != 0)
                {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    	System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    	System.out.println(s.longestCommonPrefix(new String[]{"baac", "acb", "bacc", "cb"}));
    }
}
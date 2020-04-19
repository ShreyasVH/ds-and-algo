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
    	StringBuilder builder = new StringBuilder("");
    	if(strings.length > 0)
    	{
    		for(int i = 0; i < strings[0].length(); i++)
    		{
    			char ch = strings[0].charAt(i);
    			
    			boolean equal = true;

    			for(int j = 0; j < strings.length; j++)
    			{
    				String string = strings[j];

    				if((i >= string.length()) || (ch != string.charAt(i)))
    				{
    					equal = false;
    					break;
    				}
    			}

    			if(equal)
    			{
    				builder.append(ch);
    			}
    			else
    			{
    				break;
    			}
    		}
    	}

        return builder.toString();
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    	System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    	System.out.println(s.longestCommonPrefix(new String[]{"baac", "acb", "bacc", "cb"}));
    }
}
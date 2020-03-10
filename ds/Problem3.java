public class Problem3
{
	public static void main(String[] args)
	{
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

 	public static int lengthOfLongestSubstring(String s)
 	{
    	int n = s.length();

    	if(n == 0)
    	{
    		return 0;
    	}

    	int start = 0;
    	int end = 0;
    	int max = 1;
    	String temp = String.valueOf(s.charAt(start));
    	int len = 1;
    	String maxSubString = temp;

    	while(start < n)
    	{
    		if(!hasRepeated(temp))
    		{
    			if(len > max)
    			{
    				max = len;
    				maxSubString = temp;
    			}
    			
    			if(end < (n - 1))
    			{
    				end++;
    				char ch = s.charAt(end);
    				len++;
    				temp = temp + String.valueOf(ch);
    			}
    			else
    			{
    				break;
    			}
    		}
    		else
    		{
    			start++;
    			len--;
    			temp = temp.substring(1);
    		}
    	}
    	// System.out.println(maxSubString);

    	return max;	    
    }

    public static boolean hasRepeated(String s)
    {
    	boolean hasRepeated = false;

    	for(int i = 0; i < s.length(); i++)
    	{
    		char ch = s.charAt(i);
    		int index = s.indexOf(ch);
    		if(index != i)
    		{
    			hasRepeated = true;
    			break;
    		}
    	}

    	return hasRepeated;
    }
}
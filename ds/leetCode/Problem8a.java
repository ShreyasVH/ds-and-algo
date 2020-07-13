class Solution
{
	public int myAtoi(String str)
	{
        int i = 0;
        int result = 0;
        boolean isNegative = false;
        while(i < str.length() && (str.charAt(i) == ' '))
        {
        	i++;
        }

        if(i < str.length())
        {
        	if((str.charAt(i) == '+') || (str.charAt(i) == '-'))
        	{
        		if((str.charAt(i)) == '-')
        		{
        			isNegative = true;
        		}
        		i++;
        	}

        	while(i < str.length())
        	{
        		if((str.charAt(i) >= '0') && (str.charAt(i) <= '9'))
        		{
        			if((result) > ((Integer.MAX_VALUE - (str.charAt(i) - '0'))) / 10)
        			{
        				if(isNegative)
        				{
        					return Integer.MIN_VALUE;
        				}
        				else
        				{
        					return Integer.MAX_VALUE;
        				}
        			}
        			else
        			{
        				result = ((result * 10) + str.charAt(i) - '0');	
        			}
        		}
        		else
        		{
        			break;
        		}
        		i++;
        	}
        }

        return result * ((isNegative) ? -1 : 1);
    }

	public static void main(String[] args)
	{
		Solution s = new Solution();
		System.out.println(s.myAtoi("42"));
		System.out.println(s.myAtoi("    -42"));
		System.out.println(s.myAtoi("4193 with words"));
		System.out.println(s.myAtoi("words and 987"));
		System.out.println(s.myAtoi("-91283472332"));
		System.out.println(s.myAtoi("9223372036854775808"));
	}
}
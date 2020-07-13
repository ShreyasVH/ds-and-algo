class Solution
{
	public int myAtoi(String str)
	{
        int i = 0;
        Long result = 0l;
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
        			if(((result * 10) + str.charAt(i) - '0') > (Integer.MAX_VALUE))
        			{
        				if(isNegative)
        				{
        					result = Integer.MIN_VALUE * -1l;
        				}
        				else
        				{
        					result = Integer.MAX_VALUE * 1l;
        				}
    					break;
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

        if(isNegative)
        {
        	result *= -1;
        }

        if(result > Integer.MAX_VALUE)
        {
        	result = Integer.MAX_VALUE * 1l;
        }
        else if(result < Integer.MIN_VALUE)
        {
        	result = Integer.MIN_VALUE * 1l;
        }

        return result.intValue();
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
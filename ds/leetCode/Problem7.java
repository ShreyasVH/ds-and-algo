/*
	Given a 32-bit signed integer, reverse digits of an integer.

	Example 1:

	Input: 123
	Output: 321
	Example 2:

	Input: -123
	Output: -321
	Example 3:

	Input: 120
	Output: 21
	Note:
	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution
{
	public int reverse(int x)
	{
        int result = 0;

        int sign = ((x < 0) ? -1 : 1);
        x = Math.abs(x);

        while(x > 0)
        {
        	int digit = (x % 10);
        	x /= 10;

        	if(result > ((Integer.MAX_VALUE - digit) / 10))
        	{
        		result = 0;
        		break;
        	}

        	result = (result * 10 + digit);
        }

        return result * sign;
    }

	public static void main(String[] args)
	{
		// System.out.println(1534236469 > Integer.MAX_VALUE);


		Solution s = new Solution();
		System.out.println(s.reverse(123));
		System.out.println(s.reverse(210));
		System.out.println(s.reverse(-123));
		System.out.println(s.reverse(1534236469));
	}
}
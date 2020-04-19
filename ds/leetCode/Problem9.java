/*
	Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

	Example 1:

	Input: 121
	Output: true
	Example 2:

	Input: -121
	Output: false
	Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
	Example 3:

	Input: 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
	Follow up:

	Coud you solve it without converting the integer to a string?
*/

class Solution
{
    public boolean isPalindrome(int x)
    {
        if(x < 0)
        {
            return false;
        }
        int reversed = reverse(x);
        return (x == reversed);
    }
    
    public int reverse(int x) {
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
    	Solution s = new Solution();
    	System.out.println(s.isPalindrome(121));
    	System.out.println(s.isPalindrome(1234));
    }
}
/*
	Time Complexity: O(logn) base 10
	Space Complexity: O(1)
*/
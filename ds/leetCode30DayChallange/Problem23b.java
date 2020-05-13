/*
	Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

	Example 1:
	Input: [5,7]
	Output: 4
	
	Example 2:
	Input: [0,1]
	Output: 0
*/
class Solution
{
	public int rangeBitwiseAnd(int m, int n)
	{
        int shift = 0;

        while(m < n)
        {
            m >>= 1;
            n >>= 1;
            shift++;
        }

        return m << shift;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.rangeBitwiseAnd(5, 7));
    	System.out.println(s.rangeBitwiseAnd(0, 1));
    	System.out.println(s.rangeBitwiseAnd(10, 11));
    	System.out.println(s.rangeBitwiseAnd(10, 20));
    	System.out.println(s.rangeBitwiseAnd(17, 19));
    	System.out.println(s.rangeBitwiseAnd(11, 12));
    	// for(int i = 0; i <= 10; i++)
    	// {
    	// 	System.out.println(i + ": " + s.getTwosPower(i));
    	// }
    }
}

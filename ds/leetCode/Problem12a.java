class Solution
{
	public String intToRoman(int num)
	{
        StringBuilder result = new StringBuilder();

        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i = 0; i < symbols.length; i++)
        {
            while(num >= values[i])
            {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

	public static void main(String[] args)
	{
		Solution s = new Solution();
		System.out.println(s.intToRoman(3549));
		System.out.println(s.intToRoman(3));
		System.out.println(s.intToRoman(4));
		System.out.println(s.intToRoman(9));
		System.out.println(s.intToRoman(58));
		System.out.println(s.intToRoman(1994));
	}
}
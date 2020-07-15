class Solution
{
	public String intToRoman(int num)
	{
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return m[num / 1000] + c[(num % 1000) / 100] + x[(num % 100) / 10] + i[(num % 10)];
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
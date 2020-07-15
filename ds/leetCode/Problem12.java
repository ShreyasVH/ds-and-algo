class Solution
{
	public String intToRoman(int num)
	{
        StringBuilder result = new StringBuilder();

        Denomination[] denominations = {
        	new Denomination(1000, "M"),
        	new Denomination(900, "CM"),
        	new Denomination(500, "D"),
        	new Denomination(400, "CD"),
        	new Denomination(100, "C"),
        	new Denomination(90, "XC"),
        	new Denomination(50, "L"),
        	new Denomination(40, "XL"),
        	new Denomination(10, "X"),
        	new Denomination(9, "IX"),
        	new Denomination(5, "V"),
        	new Denomination(4, "IV"),
        	new Denomination(1, "I")
        };

        while(num > 0)
        {
        	for(Denomination denomination: denominations)
        	{
        		if(num >= denomination.value)
        		{
        			while(num >= denomination.value)
        			{
        				result.append(denomination.symbol);
        				num -= denomination.value;
        			}
        		}
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

class Denomination
{
	int value;
	String symbol;

	Denomination(int value, String symbol)
	{
		this.value = value;
		this.symbol = symbol;
	}
}
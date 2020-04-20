/*
	You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.

	Examples:

	Input  : []][][
	Output : 2
	First swap: Position 3 and 4
	[][]][
	Second swap: Position 5 and 6
	[][][]

	Input  : [[][]]
	Output : 0
	String is already balanced.
*/
class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		System.out.println(s.swapCount("[]][]["));
		System.out.println(s.swapCount("[[][]]"));
	}

	public int swapCount(String string)
	{
		int swaps = 0;

		int sum = 0;
		StringBuilder builder = new StringBuilder(string);
		for(int i = 0; i < builder.length(); i++)
		{
			char ch = builder.charAt(i);
			if('[' == ch)
			{
				sum++;
			}
			else
			{
				sum--;
			}

			if(sum < 0)
			{
				int j = i + 1;

				while((j < builder.length()) && '[' != builder.charAt(j))
				{
					j++;
				}

				if(j < builder.length())
				{
					builder.setCharAt(j, ']');
					builder.setCharAt(i, '[');
					swaps++;
				}
			}
		}

		return swaps;
	}
}
/*
	Time Complexity: O(n^2)
	Space Complexity: O(1)
*/
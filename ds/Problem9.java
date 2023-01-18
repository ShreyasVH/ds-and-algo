/*
	Print the sequence similar to the column labels in sheets.
	Ex: A, B, ....  Z, AA, AB, ...... ZZ, AAA, AAB, ........ ZZZ ...........
*/

public class Problem9
{
	public static void main(String[] args)
	{
		// getSequenceString(675);
		getSequence(677);
		// getSequence(100);
	}

	public static void getSequence(int n)
	{
		for(int i = 1; i <= n; i++)
		{
			System.out.println(i + " => " + getSequenceString(i));
		}	
	}

	public static String getSequenceString(int n)
	{
	    String sequence = "";
		int digitCount = (int) Math.ceil(Math.log(n) / Math.log(26));
		System.out.println("DigitCount: " + digitCount);
		for(int j = digitCount; j > 1; j--)
		{
		    int placeValue = (int) Math.pow(26, j - 1);
			int multiplier = (int) (n / Math.pow(26, j - 1));
			
			n = Math.max(n % placeValue, 1);
			sequence = sequence + (char) ((int) 'A' + multiplier - 1);
		}
		sequence = sequence + (char) ((int) 'A' + n - 1);
		return sequence;
	}
}

/*
	Time Complexity: O(logn)
	Space Complexity: O(1)
*/
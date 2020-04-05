public class Problem7a
{
	public static void main(String[] args)
	{
		System.out.println(convertString("PAYPALISHIRING", 3));
		System.out.println(convertString("PAYPALISHIRING", 4));
		System.out.println(convertString("ABCDE", 6));
		System.out.println(convertString("AB", 1));
		System.out.println(convertString("PAYPAL", 2));
	}

	public static String convertString(String str, int rowCount)
	{
		if((rowCount == 1) || (rowCount >= str.length()))
		{
			return str;
		}

		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < rowCount; i++)
		{
			int j = i;
			while(j < str.length())
			{
				builder.append(String.valueOf(str.charAt(j)));

				if(((j % (rowCount - 1)) != 0))
				{
					int additionalIndex = j + (2 * (rowCount - 1 - i));
					if(additionalIndex < str.length())
					{
						builder.append(String.valueOf(str.charAt(additionalIndex)));
					}
				}

				j += ((rowCount - 1) * 2);
			}
		}

		return builder.toString();
	}
}
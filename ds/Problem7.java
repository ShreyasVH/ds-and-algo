public class Problem7
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
		int i = 0;
		String[] rows = new String[rowCount];

		if(rowCount == 1)
		{
			return str;
		}

		int rowIndex = 0;
		String type = "inc";
		while(i < str.length())
		{
			String currentString = rows[rowIndex];
			if(null == currentString)
			{
				currentString = "";
			}

			rows[rowIndex] = currentString + String.valueOf(str.charAt(i));

			
			if(type.equals("inc"))
			{
				if(rowIndex == (rowCount - 1))
				{
					rowIndex--;
					type = "dec";
				}
				else
				{
					rowIndex++;
				}
			}
			else
			{
				if(rowIndex == 0)
				{
					rowIndex++;
					type = "inc";
				}
				else
				{
					rowIndex--;
				}
			}
			i++;
		}

		StringBuilder builder = new StringBuilder();

		for(i = 0; i < rowCount; i++)
		{
			String rowString = rows[i];
			if(null != rowString)
			{
				builder.append(rowString);
			}
		}

		return builder.toString();
	}
}
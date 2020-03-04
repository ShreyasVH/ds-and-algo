/*
	Calculate the number of combinations where the letters are lexicographically sorted, given the length of string
	Ex:
	allowedChars = {'a', 'e', 'i', 'o', 'u'}
	For length 1, valid combinations = ["a", "e", "i", "o", "u"]
	count = 5
	For length 2, valid combinations = ["aa", "ae", "ai", "ao", "au", "ee", "ei", "eo", "eu", "ii", "io", "iu", "oo", "ou", "uu"]
	count = 15
*/

import java.util.List;
import java.util.ArrayList;

public class Problem1
{
	public static void main(String[] args)
	{
		int n = Integer.valueOf(args[0]);
		List<Character> allowedChars = new ArrayList<Character>(){
			{
				add('a');
				add('e');
				add('i');
				add('o');
				add('u');
			}
		};
		System.out.println(getBeautifulStringCount(n, allowedChars));
	}

	public static long getBeautifulStringCount(int n, List<Character> allowedChars)
	{
		long[][] a = new long[allowedChars.size() + 1][n + 1];
		long[] s = new long[n + 1];


		for(int i = 1; i <= allowedChars.size(); i++)
		{
			a[i][1] = 1;
		}
		s[1] = 5;

		for(int i = 2; i <= n; i++)
		{
			a[1][i] = s[i - 1];
			long sum = a[1][i];

			for(int j = 2; j <= allowedChars.size(); j++)
			{
				a[j][i] = (a[j - 1][i] - a[j - 1][i - 1]);
				sum += a[j][i];
			}
			s[i] = sum;
		}

		return s[n];
	}
}
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

public class Problem1a
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
		List<String> combinations = new ArrayList<String>(){
			{
				add("");
			}
		};
		return getBeautifulStringCountInternal(n, allowedChars, combinations, 0);
	}

	public static long getBeautifulStringCountInternal(int n, List<Character> allowedChars, List<String> combinations, int currentLength)
	{
		long count = 0;
		if(n == currentLength)
		{
			for(String string: combinations)
			{
				if(isBeautiful(string))
				{
					count++;
				}
			}
		}
		else
		{
			List<String> newCombinations = new ArrayList<>();
			for(String string: combinations)
			{
				for(Character ch: allowedChars)
				{
					newCombinations.add(string + String.valueOf(ch));
				}
			}
			count = getBeautifulStringCountInternal(n, allowedChars, newCombinations, (currentLength + 1));
		}
		return count;
	}

	public static boolean isBeautiful(String string)
	{
		boolean isBeautiful = true;

		for(int i = 1; i < string.length(); i++)
		{
			if(string.charAt(i) < string.charAt(i - 1))
			{
				isBeautiful = false;
				break;
			}
		}

		return isBeautiful;
	}
}
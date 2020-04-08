/*
	Write an algorithm to determine if a number is "happy".

	A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

	Example: 

	Input: 19
	Output: true
	Explanation: 
	1^2 + 9^2 = 82
	8^2 + 2^2 = 68
	6^2 + 8^2 = 100
	1^2 + 0^2 + 0^2 = 1
*/

import java.util.List;
import java.util.ArrayList;

class Solution
{
	public int MAX_TRIES = 10;

	public static void main(String[] args)
	{
		Solution problem = new Solution();
		System.out.println(problem.isHappy(19));
		System.out.println(problem.isHappy(18));
		System.out.println(problem.isHappy(7));
	}

	public boolean isHappy(int n)
	{
		return isHappyInternal(n, 1);
	}

	public boolean isHappyInternal(int n, int tryCount)
	{
		boolean isHappy = false;

		if(tryCount <= MAX_TRIES)
		{
			List<Integer> digits = getDigits(n);

			if(digits.size() == 1 && (digits.get(0) == 1))
			{
				isHappy = true;
			}
			else
			{
				isHappy = isHappyInternal(getNewNumber(digits), (tryCount + 1));
			}
		}


		return isHappy;
	}

	public int getNewNumber(List<Integer> digits)
	{
		int number = 0;

		for(Integer digit: digits)
		{
			number += (digit * digit);
		}

		return number;
	}

	public List<Integer> getDigits(int n)
	{
		List<Integer> digits = new ArrayList<>();

		if(n == 0)
		{
			digits.add(0);
		}
		else
		{
			while(n > 0)
			{
				Integer digit = (n % 10);
				digits.add(digit);
				n /= 10;
			}
		}

		return digits;
	}
}
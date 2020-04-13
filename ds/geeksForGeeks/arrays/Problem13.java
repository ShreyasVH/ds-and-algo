/*
	Find a rotation with maximum hamming distance

	Given an array of n elements, create a new array which is a rotation of given array and hamming distance between both the arrays is maximum.
	Hamming distance between two arrays or strings of equal length is the number of positions at which the corresponding character(elements) are different.

	Note: There can be more than one output for the given input.

	Examples:



	Input :  1 4 1
	Output :  2
	Explanation:  
	Maximum hamming distance = 2.
	We get this hamming distance with 4 1 1 
	or 1 1 4 

	input :  N = 4
	         2 4 8 0
	output :  4
	Explanation: 
	Maximum hamming distance = 4
	We get this hamming distance with 4 8 0 2.
	All the places can be occupied by another digit.
	Other solutions can be 8 0 2 4, 4 0 2 8 etc.
*/
class Problem
{
	public static void main(String[] args)
	{
		int[] nums = {1, 4, 1};
		System.out.println(maxHammingDistance(nums));
		System.out.println(maxHammingDistance(new int[]{2, 4, 8, 0}));
	}

	public static int maxHammingDistance(int[] nums)
	{
		int[] dup = new int[2 * nums.length];
		for(int i = 0; i < 2 * nums.length; i++)
		{
			dup[i] = nums[i % nums.length];
		}

		int maxHammingDistance = 0;
		for(int i = 0; i < nums.length; i++)
		{
			int distance = hammingDistance(nums, dup, i);
			if(distance > maxHammingDistance)
			{
				maxHammingDistance = distance;
			}
		}
		return maxHammingDistance;
	}

	public static int hammingDistance(int[] nums, int[] dup, int start)
	{
		int distance = 0;

		for(int i = 0, j = start; i < nums.length; i++, j++)
		{
			if(nums[i] != dup[j])
			{
				distance++;
			}
		}

		return distance;
	}
}
/*
	Time Complexity: O(n^2)
	Space Complexity: O(2 * n)
*/
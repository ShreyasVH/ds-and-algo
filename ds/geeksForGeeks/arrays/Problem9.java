/*
	Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
*/

public class Problem9
{
	public static void main(String[] args)
	{
		int[] nums = {15, 18, 2, 3, 6, 12};
		// int[] nums = {7, 9, 11, 12, 5};
		System.out.println(getRotationCount(nums));
	}

	public static int getRotationCount(int[] nums)
	{
		int k = 0;

		for(int i = 0; i < (nums.length - 1); i++)
		{
			if(nums[i] > nums[i + 1])
			{
				k = (i + 1);
			}
		}

		return k;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/

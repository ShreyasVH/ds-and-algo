/*
	Given a sorted and rotated array, find if there is a pair with a given sum
*/

public class Problem6a
{
	public static void main(String[] args)
	{
		int[] nums = {11, 15, 6, 8, 9, 10};
		System.out.println(hasPair(nums, 15));
	}

	public static boolean hasPair(int[] nums, int sum)
	{
		boolean hasPair = false;
		int n = nums.length;

		int smallestIndex = smallestIndex(nums)	;
		int largestIndex = largestIndex(nums);

		int l = smallestIndex;
		int r = largestIndex;

		do
		{
			int tempSum = (nums[l] + nums[r]);
			if(tempSum == sum)
			{
				hasPair = true;
				break;
			}
			else if(tempSum < sum)
			{
				l = ((l + 1 + n) % n);
			}
			else
			{
				r = ((r - 1 + n) % n);
			}
		}
		while((l != smallestIndex) || (r != largestIndex));

		return hasPair;
	}

	public static int smallestIndex(int[] nums)
	{
		int smallestIndex = 0;

		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] < nums[smallestIndex])
			{
				smallestIndex = i;
			}
		}

		return smallestIndex;
	}

	public static int largestIndex(int[] nums)
	{
		int largestIndex = 0;

		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] > nums[largestIndex])
			{
				largestIndex = i;
			}
		}

		return largestIndex;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
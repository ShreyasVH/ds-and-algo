/*
	Given a sorted and rotated array, find if there is a pair with a given sum
*/

public class Problem6b
{
	public static void main(String[] args)
	{
		int[] nums = {11, 15, 6, 8, 9, 10};
		System.out.println(hasPair(nums, 15));
		System.out.println(hasPair(nums, 37));
	}

	public static boolean hasPair(int[] nums, int sum)
	{
		boolean hasPair = false;
		int n = nums.length;

		int largestIndex = (n - 1);
		for(int i = 0; i < (n - 1); i++)
		{
			if(nums[i] > nums[i + 1])
			{
				largestIndex = i;
				break;
			}
		}

		int smallestIndex = ((largestIndex + 1 + n) % n);

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
		while(l != r);

		return hasPair;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
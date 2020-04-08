/*
	Quickly find multiple left rotations of an array
*/

public class Problem10a
{
	public static void main(String[] args)
	{
		int[] nums = {1, 3, 5, 7, 9};
		print(leftRotate(nums, 1));
		print(leftRotate(nums, 3));
	}

	public static int[] leftRotate(int[] nums, int k)
	{
		int n = nums.length;
		int[] result = new int[n];

		for(int i = k; i < (k + n); i++)
		{
			result[i - k] = nums[i % n];
		}
		return result;
	}

	public static void print(int[] nums)
	{
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(n)
*/
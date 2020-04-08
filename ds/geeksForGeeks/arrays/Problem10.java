/*
	Quickly find multiple left rotations of an array
*/

public class Problem10
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
		int[] temp = new int[2 * n];

		for(int i = 0; i < n; i++)
		{
			temp[i] = nums[i];
			temp[i + n] = nums[i];
		}

		int start = (k % n);

		for(int i = start; i < (start + n); i++)
		{
			result[i - start] = temp[i];
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
	Space Complexity: O(3n) //2n for temp, n for result
*/
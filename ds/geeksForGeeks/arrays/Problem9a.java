/*
	Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
*/

public class Problem9a
{
	public static void main(String[] args)
	{
		// int[] nums = {15, 18, 2, 3, 6, 12};
		// int[] nums = {7, 9, 11, 12, 5};
		// int[] nums = {1, 2, 3, 4, 5, 6, 7};
		// int[] nums = {4, 5, 6, 7, 1, 2, 3};
		// int[] nums = {6, 7, 1, 2, 3, 4, 5};
		// int[] nums = {2, 3, 4, 5, 6, 7, 1};
		// int[] nums = {7, 1, 2, 3, 4, 5, 6};
		System.out.println(getRotationCount(nums, 0, nums.length - 1));
	}

	public static int getRotationCount(int[] nums, int start, int end)
	{
		int k = 0;
		int n = nums.length;

		while(start <= end)
		{
			int mid = ((start + end) / 2);

			if(((mid + 1) < n) && (nums[mid] > nums[mid + 1]))
			{
				k = (mid + 1);
				break;
			}
			else if((nums[start] > nums[mid]))
			{
				end = (mid - 1);
			}
			else
			{
				start = (mid + 1);
			}
		}

		return k;
	}
}

/*
	Time Complexity: O(logn)
	Space Complexity: O(1)
*/

/*
	Search an element in a sorted and rotated array
*/

public class Problem5
{
	public static void main(String[] args)
	{
		// int nums[] = {3, 4, 5, 1, 2};
		// int nums[] = {4, 5, 1, 2, 3};
		// System.out.println(search(nums, 0, nums.length - 1, 1));
		// System.out.println(search(nums, 0, nums.length - 1, 3));
		// System.out.println(search(nums, 0, nums.length - 1, 7));

		int[] nums = {2};
		System.out.println(search(nums, 0, nums.length - 1, 1));
		System.out.println(search(nums, 0, nums.length - 1, 2));
		System.out.println(search(nums, 0, nums.length - 1, 3));
	}

	public static int search(int[] nums, int start, int end, int key)
	{
		int pos = -1;

		if(start <= end)
		{
			int mid = ((start + end) / 2);

			if(nums[mid] == key)
			{
				pos = mid;
			}
			else if((key >= nums[start]) && ((mid - 1) >= 0) && (key <= nums[mid - 1]))
			{
				pos = search(nums, start, (mid - 1), key);
			}
			else if(((mid + 1) <= end) && (key >= nums[mid + 1]) && (key <= nums[end]))
			{
				pos = search(nums, (mid + 1), end, key);
			}
		}

		return pos;
	}
}

/*
	Time Complexity: O(logn)
	Space Complexity: O(1)
*/
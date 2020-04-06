/*
	Search an element in a sorted and rotated array. Assume that all elements can repeat.
*/

public class Problem8
{
	public static void main(String[] args)
	{
		// int nums[] = {3, 4, 5, 1, 2};
		// int nums[] = {4, 5, 5, 5, 1, 1, 2, 2, 3, 3};
		// int nums[] = {4, 5, 5, 2, 2, 2, 2, 2, 3, 3};
		int[] nums = {3, 3, 1, 2, 3};
		// System.out.println(search(nums, 0, nums.length - 1, 1));
		// System.out.println(search(nums, 0, nums.length - 1, 3));
		// System.out.println(search(nums, 0, nums.length - 1, 7));

		System.out.println(search(nums, 0, nums.length - 1, 11));
	}

	public static int search(int[] nums, int start, int end, int key)
	{
		int pos = -1;

		if(start <= end)
		{
			int mid = ((start + end) / 2);

			int midStart = mid;
			int midEnd = mid;

			while((midStart >= start) && (nums[midStart] == nums[mid]))
			{
				midStart--;
			}
			midStart++;

			while((midEnd <= end) && (nums[midEnd] == nums[mid]))
			{
				midEnd++;
			}
			midEnd--;

			if(nums[mid] == key)
			{
				pos = midStart;
			}
			else if((key >= nums[start]) && (key <= nums[midStart - 1]))
			{
				pos = search(nums, start, (midStart - 1), key);
			}
			else if((key >= nums[midEnd + 1]) && (key <= nums[end]))
			{
				pos = search(nums, (midEnd + 1), end, key);
			}
		}

		return pos;
	}
}

/*
	Time Complexity: O(logn)
	Space Complexity: O(1)
*/
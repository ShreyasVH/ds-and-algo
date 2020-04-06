/*
	Given a sorted and rotated array, find if there is a pair with a given sum
*/

public class Problem6
{
	public static void main(String[] args)
	{
		int[] nums = {11, 15, 6, 8, 9, 10};
		System.out.println(hasPair(nums, 16));
	}

	public static boolean hasPair(int[] nums, int sum)
	{
		boolean hasPair = false;

		for(int i = 0; i < (nums.length - 1); i++)
		{
			int num = nums[i];
			int pos = search(nums, (i + 1), (nums.length - 1), (sum - num));

			if(-1 != pos)
			{
				hasPair = true;
				break;
			}
		}

		return hasPair;
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
	Time Complexity: O(nlogn)
	Space Complexity: O(1)
*/
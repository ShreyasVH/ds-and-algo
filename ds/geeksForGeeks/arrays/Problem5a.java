/*
	Search an element in a sorted and rotated array
*/

public class Problem5a
{
	public static void main(String[] args)
	{
		int nums[] = {3, 4, 5, 1, 2};
		// System.out.println(search(nums, 0, nums.length - 1, 1));
		// System.out.println(search(nums, 0, nums.length - 1, 3));
		// System.out.println(search(nums, 0, nums.length - 1, 7));

		for(int i = 1; i <= 10; i++)
		{
			System.out.println(search(nums, i));
		}
	}

	public static int search(int[] nums, int key)
	{
		int pos = -1;
		int start = 0;
		int end = nums.length - 1;

		while(start <= end)
		{
			int mid = ((start + end) / 2);

			if(nums[mid] == key)
			{
				pos = mid;
				break;
			}
			else if((key < nums[mid]) && (key >= nums[start]))
			{
				end = (mid - 1);
			}
			else
			{
				start = (mid + 1);
			}
		}

		return pos;
	}
}

/*
	Time Complexity: O(logn)
	Space Complexity: O(1)
*/
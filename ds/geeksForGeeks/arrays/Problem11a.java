/*
	Find the minimum element in a sorted and rotated array
*/
public class Problem11a
{
	public static void main(String[] args)
	{
		// int[] nums = {5, 6, 1, 2, 3, 4};
		// System.out.println(smallest(nums));

		System.out.println(smallest(new int[]{1, 2, 3, 4, 5, 6, 7}));
		System.out.println(smallest(new int[]{2, 3, 4, 5, 6, 7, 1}));
		System.out.println(smallest(new int[]{5, 6, 7, 1, 2, 3, 4}));
		System.out.println(smallest(new int[]{7, 1, 2, 3, 4, 5, 6}));
		System.out.println(smallest(new int[]{3, 4, 5, 6, 7, 1, 2}));
	}

	public static int smallest(int[] nums)
	{
		int result = -1;

		int n = nums.length;

		if(n > 0)
		{
			result = nums[0];

			int start = 0;
			int end = n - 1;

			while(start <= end)
			{
				int mid = ((start + end) / 2);

				if((mid - 1 >= 0) && (nums[mid] < nums[mid - 1]))
				{
					result = nums[mid];
					break;
				}
				else if((mid + 1 < n) && (nums[mid] > nums[mid + 1]))
				{
					result = nums[mid + 1];
					break;
				}
				else if(nums[start] > nums[mid])
				{
					end = mid - 1;
				}
				else
				{
					start = mid + 1;
				}
			}
		}

		return result;
	}
}

/*
	Time Complexity: O(logn)
	Space Complexity: O(1)
*/
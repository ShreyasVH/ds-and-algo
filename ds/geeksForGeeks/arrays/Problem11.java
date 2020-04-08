/*
	Find the minimum element in a sorted and rotated array
*/
public class Problem11
{
	public static void main(String[] args)
	{
		int[] nums = {5, 6, 1, 2, 3, 4};
		System.out.println(smallest(nums));
	}

	public static int smallest(int[] nums)
	{
		int result = -1;

		int n = nums.length;
		if(n > 0)
		{
			result = nums[0];
			for(int i = 1; i < nums.length; i++)
			{
				if(nums[i] < nums[i - 1])
				{
					result = nums[i];
					break;
				}
			}
		}

		return result;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
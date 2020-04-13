/*
	Reversal algorithm for right rotation of an array
*/

class Problem
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6};

		rotate(arr, 4);
		print(arr);
	}

	public static void rotate(int[] nums, int d)
	{
		int n = nums.length;

		reverse(nums, 0, n - 1);
		print(nums);
		reverse(nums, 0, d - 1);
		print(nums);
		reverse(nums, d, n - 1);
	}

	public static void reverse(int[] arr, int low, int high)
	{
		for(int i = low; i <= ((low + high) / 2); i++)
		{
			int temp = arr[i];
			arr[i] = arr[high - i + low];
			arr[high - i + low] = temp;
		}
	}

	public static void print(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
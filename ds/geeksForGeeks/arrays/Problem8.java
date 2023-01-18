/*
	Maximum sum of i*arr[i] among all rotations of a given array
*/

class Solution
{
	public static void main(String[] args)
	{
		int[] arr = {8, 3, 1, 2};
		// int[] arr = {3, 2, 1};
		System.out.println(maxSum(arr));
	}

	public static int maxSum(int[] arr)
	{
		int n = arr.length;
		int maxSum = 0;

		for(int i = 0; i < n; i++)
		{
			int sum = 0;
			for(int j = 0; j < n; j++)
			{
				sum += (j * arr[((j + i) % n)]);
			}

			if(sum > maxSum)
			{
				maxSum = sum;
			}
		}
		

		return maxSum;
	}
}

/*
	Time Complexity: O(n ^ 2)
	Space Complexity: O(1)
*/
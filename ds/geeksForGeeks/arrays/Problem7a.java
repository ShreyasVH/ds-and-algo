/*
	Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
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

		int sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum += arr[i];
		}

		int[] sumArray = new int[n];
		
		for(int i = 1; i < n; i++)
		{
			sumArray[0] += (i * arr[i]);
		}
		int maxSum = sumArray[0];

		for(int i = 1; i < n; i++)
		{
			sumArray[i] = (sumArray[i - 1] + n * arr[i - 1] - sum);
			if(sumArray[i] > maxSum)
			{
				maxSum = sumArray[i];
			}
		}

		return maxSum;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
/*
	Given an integer array arr, count element x such that x + 1 is also in arr.

	If there're duplicates in arr, count them seperately.

	 

	Example 1:

	Input: arr = [1,2,3]
	Output: 2
	Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
	Example 2:

	Input: arr = [1,1,3,3,5,5,7,7]
	Output: 0
	Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
	Example 3:

	Input: arr = [1,3,2,3,5,0]
	Output: 3
	Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
	Example 4:

	Input: arr = [1,1,2,2]
	Output: 2
	Explanation: Two 1s are counted cause 2 is in arr.
	 

	Constraints:

	1 <= arr.length <= 1000
	0 <= arr[i] <= 1000
*/

public class Problem7
{
	public static void main(String[] args)
	{
		Problem7 problem = new Problem7();
		// int[] arr = {1, 2, 3};
		// int[] arr = {1, 1, 3, 3, 5, 5, 7, 7};
		int[] arr = {1, 3, 2, 3, 5, 0, 7};
		System.out.println(problem.countElements(arr));
	}

	public int countElements(int[] arr)
	{
		int result = 0;
		int n = arr.length;

		if(n > 0)
		{
			int maxValue = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++)
			{
				if(arr[i] > maxValue)
				{
					maxValue = arr[i];
				}
			}

	        int[] frequency = new int[maxValue + 1];

	        for(int i = 0; i < n; i++)
			{
				frequency[arr[i]] = (frequency[arr[i]] + 1);
			}

			if(maxValue < n)
			{
				for(int i = 0; i < maxValue; i++)
				{
					if(frequency[i + 1] > 0)
					{
						result += frequency[i];
					}
				}
			}
			else
			{
				for(int i = 0; i < n; i++)
				{
					if((arr[i] < maxValue) && frequency[arr[i] + 1] > 0)
					{
						result++;
					}
				}
			}
		}

        return result;
    }
}
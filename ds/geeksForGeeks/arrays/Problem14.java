/*
	Given an array A of N integers. There are three type of type of commands:

	1 x : Right Circular Shift the array x times. If an array is a[0], a[1], …., a[n – 1], then after one right circular shift the array will become a[n – 1], a[0], a[1], …., a[n – 2].
	2 y : Left Circular Shift the array y times. If an array is a[0], a[1], …., a[n – 1], then after one right circular shift the array will become a[1], …., a[n – 2], a[n – 1], a[0].
	3 l r : Print the sum of all integers in the subarray a[l…r] (l and r inclusive).
	Given Q queries, the task is execute each query.

	Examples:



	Input : n = 5, arr[] = { 1, 2, 3, 4, 5 }
	        query 1 = { 1, 3 }
	        query 2 = { 3, 0, 2 }
	        query 3 = { 2, 1 }
	        query 4 = { 3, 1, 4 }
	Output : 12
	         11
	Initial array arr[] = { 1, 2, 3, 4, 5 }
	After query 1, arr[] = { 3, 4, 5, 1, 2 }.
	After query 2, sum from index 0 to index 
	               2 is 12, so output 12.
	After query 3, arr[] = { 4, 5, 1, 2, 3 }.
	After query 4, sum from index 1 to index 
	               4 is 11, so output 11.
*/
class Solution
{
	public static void main(String[] args)
	{
		queries(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {3, 0, 2}, {2, 1}, {3, 1, 4}});
	}

	public static void queries(int[] nums, int[][] queries)
	{
		for(int[] query: queries)
		{
			int type = query[0];
			int value1 = query[1];

			switch(type)
			{
				case 1:
					query1(nums, value1);
					break;
				case 2:
					query2(nums, value1);
					break;
				case 3:
					int value2 = query[2];
					System.out.println(query3(nums, value1, value2));
					break;
			}
		}
	}

	public static void query1(int[] nums, int x)
	{
		leftShift(nums, nums.length - x);
	}

	public static void query2(int[] nums, int x)
	{
		leftShift(nums, x);
	}

	public static int query3(int[] nums, int start, int end)
	{
		int result = 0;
		for(int i = start; i <= end; i++)
		{
			result += nums[i];
		}
		return result;
	}

	public static void leftShift(int[] nums, int k)
	{
		int n = nums.length;
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
		reverse(nums, 0, n - 1);
	}

	public static void reverse(int[] nums, int start, int end)
	{
		for(int i = start; i < ((start + end) / 2); i++)
		{
			int temp = nums[i];
			nums[i] = nums[end - (i - start)];
			nums[end - (i - start)] = temp;
		}
	}
}
/*
	Time Complexity: O(kn) k is no of queries
	Space Complexity: O(1)
*/
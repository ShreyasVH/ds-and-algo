/*
	Print left rotation of array in O(n) time and O(1) space
	Given an array of size n and multiple values around which we need to left rotate the array. How to quickly print multiple left rotations?

	Examples :

	Input : arr[] = {1, 3, 5, 7, 9}
	        k1 = 1
	        k2 = 3
	        k3 = 4
	        k4 = 6
	Output : 3 5 7 9 1
	         7 9 1 3 5
	         9 1 3 5 7
	         3 5 7 9 1

	Input : arr[] = {1, 3, 5, 7, 9}
	        k1 = 14 
	Output : 9 1 3 5 7
*/
class Solution
{
	public static void main(String[] args)
	{
		printLeftRotation(new int[]{1, 3, 5, 7, 9}, 1);
		printLeftRotation(new int[]{1, 3, 5, 7, 9}, 3);
		printLeftRotation(new int[]{1, 3, 5, 7, 9}, 4);
		printLeftRotation(new int[]{1, 3, 5, 7, 9}, 6);

		printLeftRotation(new int[]{1, 3, 5, 7, 9}, 14);
	}

	public static void printLeftRotation(int[] nums, int k)
	{
		int n = nums.length;
		k = k % n;

		for(int i = k; i < (k + n); i++)
		{
			System.out.print(nums[i % n] + " ");
		}
		System.out.println();
	}
}
/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/
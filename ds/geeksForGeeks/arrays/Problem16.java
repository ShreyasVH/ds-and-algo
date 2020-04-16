/*
	Find element at given index after a number of rotations
	An array consisting of N integers is given. There are several Right Circular Rotations of range[L..R] that we perform. After performing these rotations, we need to find element at a given index.

	Examples :

	Input : arr[] : {1, 2, 3, 4, 5}
	        ranges[] = { {0, 2}, {0, 3} }
	        index : 1
	Output : 3
	Explanation : After first given rotation {0, 2}
	                arr[] = {3, 1, 2, 4, 5}
	              After second rotation {0, 3} 
	                arr[] = {4, 3, 1, 2, 5}
	After all rotations we have element 3 at given
	index 1.
*/

class Solution
{
	public static void main(String[] args)
	{
		System.out.println(getElementAtIndex(new int[]{1, 2, 3, 4, 5}, new int[][]{{0, 2}, {0, 3}}, 1));
	}

	public static int getElementAtIndex(int[] nums, int[][] ranges, int index)
	{
		int rotations = ranges.length;
		for(int i = rotations - 1; i >= 0; i--)
		{
			int left = ranges[i][0];
			int right = ranges[i][1];

			if((index >= left) && (index <= right))
			{
				if(index == left)
				{
					index = right;
				}
				else
				{
					index--;
				}
			}
		}
		return nums[index];
	}
}

/*
	Time Complexity: O(k) number of rotations
	Space Complexity: O(1)
*/
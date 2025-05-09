/*
Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]
Output: 2
Explanation:
n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation:
n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.


Constraints:

n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
All the numbers of nums are unique.

*/

package ds.stoneyCodes;

import java.util.*;

public class Problem2
{
	public static void main(String args[])
	{

		Problem2 problem = new Problem2();

		int[] nums = {3, 0, 1};
		System.out.println(problem.missingNumber(nums));

		nums = new int[]{0, 1};
		System.out.println(problem.missingNumber(nums));

		nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
		System.out.println(problem.missingNumber(nums));

		nums = new int[]{0};
		System.out.println(problem.missingNumber(nums));

		nums = new int[]{1};
		System.out.println(problem.missingNumber(nums));

		nums = new int[]{1, 2};
		System.out.println(problem.missingNumber(nums));
	}

	// public int missingNumber(int[] nums) {
    //     if(nums.length == 1)
    //     {
    //     	return 1 - nums[0];
    //     }

    //     Arrays.sort(nums);

    //     if(nums[0] != 0)
    //     {
    //     	return 0;
    //     }

    //     if(nums[nums.length - 1] == nums.length - 1)
    //     {
    //     	return nums.length;
    //     }

    //     int prev = nums[0];
    //     for (int i = 1; i < nums.length; i++)
    //     {
    //     	int num = nums[i];
        	
    //     	if(num - prev > 1)
    //     	{
    //     		return num - 1;
    //     	}
    //     	prev = num;
    //     }

    //     return -1;
    // }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
        	if(nums[i] != i)
        	{
        		return i;
        	}
        }

        return nums.length;
    }
}


/*
Time complexity: O(nlogn)
Space complexity: O(1)
*/
/*
	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

	(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

	You are given a target value to search. If found in the array return its index, otherwise return -1.

	You may assume no duplicate exists in the array.

	Your algorithm's runtime complexity must be in the order of O(log n).

	Example 1:

	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
	Example 2:

	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1
*/

class Solution
{
	public int search(int[] nums, int target)
	{
        int n = nums.length;

        if(n == 0)
        {
        	return -1;
        }

        int low = 0;
        int high = n - 1;
        int pos = -1;

        while(low <= high)
        {
        	int mid = ((low + high) >>> 1);
        	if(target == nums[mid])
        	{
        		pos = mid;
        		break;
        	}
        	else if(nums[low] <= nums[mid])
        	{
        		if((target <= nums[mid]) && (target >= nums[low]))
        		{
        			high = mid - 1;
        		}
        		else
        		{
        			low = mid + 1;
        		}
        	}
        	else
        	{
        		if((target >= nums[mid]) && (target <= nums[high]))
        		{
        			low = mid + 1;
        		}
        		else
        		{
        			high = mid - 1;
        		}
        	}
        }
        return pos;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 1));
    	System.out.println(s.search(new int[]{5, 6, 7, 1, 2, 3, 4}, 1));
    	System.out.println(s.search(new int[]{2, 3, 4, 5, 6, 7, 1}, 1));
    	System.out.println(s.search(new int[]{7, 1, 2, 3, 4, 5, 6}, 1));
    	System.out.println(s.search(new int[]{3, 4, 5, 6, 7, 1, 2}, 1));
    }
}
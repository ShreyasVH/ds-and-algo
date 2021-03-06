/*
	Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

	Example:

	Input:  [1,2,3,4]
	Output: [24,12,8,6]
	Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

	Note: Please solve it without division and in O(n).

	Follow up:
	Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/
class Solution
{
	public int[] productExceptSelf(int[] nums)
	{
		int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] result = new int[n];

        leftProduct[0] = 1;
        for(int i = 1; i < n; i++)
        {
        	leftProduct[i] = (leftProduct[i - 1] * nums[i - 1]);
        }

        rightProduct[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--)
        {
        	rightProduct[i] = (rightProduct[i + 1] * nums[i + 1]);
        }

        for(int i = 0; i < n; i++)
        {
        	result[i] = (leftProduct[i] * rightProduct[i]);
        }

        return result;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	print(s.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public static void print(int[] nums)
    {
    	for(int i = 0; i < nums.length; i++)
    	{
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    }
}

/*
	Time Complexity: O(n)
	Space Complexity: O(n)
*/
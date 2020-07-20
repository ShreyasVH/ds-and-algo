import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        List<String> reference = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < (n - 2); i++)
        {
        	if(nums[i] > 0)
        	{
        		break;
        	}

        	if((i > 0) && (nums[i] == nums[i - 1]))
        	{
        		continue;
        	}

        	for(int j = (i + 1); j < (n - 1); j++)
        	{
        		for(int k = (j + 1); k < n; k++)
        		{
        			if((nums[i] + nums[j] + nums[k]) == 0)
        			{
        				String pattern = ("" + nums[i] + nums[j] + nums[k]);
        				if(!reference.contains(pattern))
        				{
        					List<Integer> row = new ArrayList<>();
        					row.add(nums[i]);
        					row.add(nums[j]);
        					row.add(nums[k]);
        					result.add(row);

        					reference.add(pattern);
        				}
        			}
        		}
        	}
        }

        return result;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(s.threeSum(new int[]{3, 0, -2, -1, 1, 2}));
        System.out.println(s.threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
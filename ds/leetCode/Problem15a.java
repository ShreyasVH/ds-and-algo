import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < (n - 2); i++)
        {
            if((i > 0) && (nums[i] == nums[i - 1]))
            {
                continue;
            }

        	int left = (i + 1);
            int right = (n - 1);

            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                // System.out.println("Sum: " + sum + " - " + nums[i] + ", " + nums[left] + ", " + nums[right]);
                if(sum < 0)
                {
                    left++;
                }
                else if (sum > 0)
                {
                    right--;
                }
                else
                {
                    List<Integer> row = new ArrayList<>();
                    row.add(nums[i]);
                    row.add(nums[left]);
                    row.add(nums[right]);

                    result.add(row);

                    while((left < right) && (nums[left] == nums[left + 1]))
                    {
                        left++;
                    }

                    while((right > left) && (nums[right] == nums[right - 1]))
                    {
                        right--;
                    }

                    left++;
                    right--;
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
class Solution {
    public int maxArea(int[] height) {
    	int result = 0;
        int n = height.length;
        
        int left = 0;
        int right = n - 1;

        while(left < right)
        {
            int area = ((right - left) * (Integer.min(height[left], height[right])));
            if(area > result)
            {
                result = area;
            }

            if(height[left] > height[right])
            {
                right--;
            }
            else
            {
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
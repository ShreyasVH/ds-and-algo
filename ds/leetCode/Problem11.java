class Solution {
    public int maxArea(int[] height) {
    	int result = 0;
        int n = height.length;
        for(int i1 = 0; i1 < n - 1; i1++)
        {
        	for(int i2 = i1 + 1; i2 < n; i2++)
        	{
        		int area = ((i2 - i1) * (Integer.min(height[i1], height[i2])));
        		if(area > result)
        		{
        			result = area;
        		}
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
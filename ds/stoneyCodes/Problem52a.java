/*
Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in a strictly increasing order.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem52a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {-10, -3, 0, 5, 9};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("sortedArrayToBST", int[].class).invoke(problem, nums));
        System.out.println("---------------------------");

        nums = new int[]{1, 3};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("sortedArrayToBST", int[].class).invoke(problem, nums));
	}

	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return null;
        }

        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0, nums.length - 1});

        while(!q.isEmpty())
        {
            Object[] data = q.poll();
            TreeNode current = (TreeNode) data[0];
            int left = (Integer) data[1];
            int right = (Integer) data[2];
            int center = left + (right - left) / 2;

            if(left < center)
            {
                int leftMid = left + (center - 1 - left) / 2;
                current.left = new TreeNode(nums[leftMid]);
                q.add(new Object[]{current.left, left, center - 1});
            }

            if(right > center)
            {
                int rightMid = center + 1 + (right - (center + 1)) / 2;
                current.right = new TreeNode(nums[rightMid]);
                q.add(new Object[]{current.right, center + 1, right});
            }
        }


        return root;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
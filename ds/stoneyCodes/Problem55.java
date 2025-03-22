/*
Minimum Absolute Difference in BST

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.


Example 1:

Input: root = [4,2,6,1,3]
Output: 1

Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 10^4].
0 <= Node.val <= 10^5
 

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem55
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(4, 2, 6, 1, 3);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("getMinimumDifference", TreeNode.class).invoke(problem, root));
        System.out.println("----------------");

        root = BinaryTreeUtils.getTree(1, 0, 48, null, null, 12, 49);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("getMinimumDifference", TreeNode.class).invoke(problem, root));
	}

	public int getMinimumDifference(TreeNode root) {
        TreeNode current = root;

        int prev = -1000000;
        int minDifference = Integer.MAX_VALUE;
        while(current != null)
        {
            if(current.left == null)
            {
                minDifference = Math.min(minDifference, current.data - prev);
                
                prev = current.data;
                current = current.right;
            }
            else
            {
                TreeNode predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current)
                {
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null)
                {
                    predecessor.right = current;
                    current = current.left;
                }
                else
                {
                    predecessor.right = null;

                    minDifference = Math.min(minDifference, current.data - prev);

                    prev = current.data;
                    current = current.right;
                }
            }
        }

        return minDifference;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
/*
Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem41
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 9, 20, null, null, 15, 7);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("minDepth", TreeNode.class).invoke(problem, root));

        System.out.println("---------------------------------");


        root = BinaryTreeUtils.getTree(2, null, 3, null, 4, null, 5, null, 6);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("minDepth", TreeNode.class).invoke(problem, root));
	}

	public int minDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        if(root.left == null && root.right == null)
        {
            return 1;
        }

        if(root.left == null)
        {
            return minDepth(root.right) + 1;
        }

        if(root.right == null)
        {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(log n) [balanced tree]
                O(n) [skewed tree]
*/
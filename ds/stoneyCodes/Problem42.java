/*
Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem42
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 9, 20, null, null, 15, 7);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxDepth", TreeNode.class).invoke(problem, root));
        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(1, null, 2);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxDepth", TreeNode.class).invoke(problem, root));
	}

	public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for recursion stack]
*/
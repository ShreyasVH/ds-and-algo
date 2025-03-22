/*
Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 10^4].
-100 <= Node.val <= 100

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem47a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("diameterOfBinaryTree", TreeNode.class).invoke(problem, root));
        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(1, 2);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("diameterOfBinaryTree", TreeNode.class).invoke(problem, root));
	}

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = {-1};
        diameterOfBinaryTree(root, max);
        return max[0];
    }

    public int diameterOfBinaryTree(TreeNode root, int[] max) {
        if(root == null)
        {
            return 0;
        }

        int lHeight = diameterOfBinaryTree(root.left, max);
        int rHeight = diameterOfBinaryTree(root.right, max);

        max[0] = Math.max(max[0], lHeight + rHeight);

        return 1 + Math.max(lHeight, rHeight);
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
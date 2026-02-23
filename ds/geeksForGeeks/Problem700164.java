/*
Height of Binary Tree

Given the root of a binary tree, your task is to find the maximum depth of the tree.

Note: The maximum depth or height of the tree is the number of edges in the tree from the root to the deepest node.

Examples:

Input: root = [12, 8, 18, 5, 11]

Output: 2
Explanation: One of the longest path from the root(node 12) goes through node 8 to node 5, which has 2 edges.

Input: root = [1, 2, 3, 4, N, 10, 5, N, N, N, N, 6, 7]

Output: 3
Explanation: The longest path from the root(node 1) to a leaf node 6 with 3 edges.
Constraints:
1 ≤ number of nodes ≤ 3*10^4
0 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700164
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(12, 8, 18, 5, 11);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("height", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, 4, null, 10, 5, null, null, null, null, 6, 7);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("height", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("height", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("height", TreeNode.class).invoke(problem, root));
	}

	public int height(TreeNode root) {
        if(root == null)
        {
            return -1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(log n) [balanced tree]
                    O(n) [skewed tree]
*/
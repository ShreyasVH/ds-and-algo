/*
Diameter of a Binary Tree

Given the root of a binary tree, your task is to find the diameter of the binary tree.

The diameter (also called the width) of a binary tree is defined as the number of edges on the longest path between any two leaf nodes. Note that this path may or may not pass through the root of the tree.

Examples:

Input: root = [1, 2, 3]

Output: 2
Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

Input: root[] = [5, 8, 6, 3, 7, 9]

Output: 4
Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).

Constraints:
1 ≤ number of nodes ≤ 10^3
0 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700165
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("diameter", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(5, 8, 6, 3, 7, 9);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("diameter", TreeNode.class).invoke(problem, root));
	}

    public int height(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

	public int diameter(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        
        return Math.max(Math.max(ldiameter, rdiameter), lheight + rheight);
    }
}


/*
Time complexity: O(n ^ 2)
Space complexity: O(n)
*/
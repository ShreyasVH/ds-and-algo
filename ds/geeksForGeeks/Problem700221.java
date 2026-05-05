/*
LCA in Binary Tree

Given the root of a binary tree with all unique values and two nodes value, n1 and n2. Find the lowest common ancestor of the given two nodes. Both node values are always present in the Binary Tree.

Note: LCA is the first common ancestor of both the nodes n1 and n2 from bottom of tree.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7], n1 = 4, n2 = 5    

Output: 2
Explanation: LCA of 4 and 5 is 2.

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, N, N, 8], n1 = 7, n2 = 8

Output: 3
Explanation: LCA of 7 and 8 is 3.
 
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700221
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5, 6, 7);
        BinaryTreeUtils.print(root);
        int n1 = 4;
        int n2 = 5;
        System.out.println(((TreeNode) clazz.getMethod("lca", TreeNode.class, int.class, int.class).invoke(problem, root, n1, n2)).data);

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5, 6, 7, null, null, null, null, 8);
        BinaryTreeUtils.print(root);
        n1 = 7;
        n2 = 8;
        System.out.println(((TreeNode) clazz.getMethod("lca", TreeNode.class, int.class, int.class).invoke(problem, root, n1, n2)).data);
	}

	public TreeNode lca(TreeNode root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2)
        {
            return root;
        }

        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);

        if(left != null && right != null)
        {
            return root;
        }

        return left == null ? right : left;
    }
}


/*
Time complexity: O(n)
Space complexity: O(h) [for recursion stack]
*/
/*
Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem49
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 5, 1, 6, 3, 0, 8, null, null, 7, 4);
        // BinaryTreeUtils.print(root);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(((TreeNode) clazz.getMethod("lowestCommonAncestor", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, p, q)).data);
        System.out.println("--------------------");

        root = BinaryTreeUtils.getTree(3, 5, 1, 6, 3, 0, 8, null, null, 7, 4);
        // BinaryTreeUtils.print(root);
        p = root.left;
        q = root.left.right.right;
        System.out.println(((TreeNode) clazz.getMethod("lowestCommonAncestor", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, p, q)).data);
        System.out.println("--------------------");

        root = BinaryTreeUtils.getTree(1, 2);
        // BinaryTreeUtils.print(root);
        p = root;
        q = root.right;
        System.out.println(((TreeNode) clazz.getMethod("lowestCommonAncestor", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, p, q)).data);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

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
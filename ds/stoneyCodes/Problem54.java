/*
Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem54
{
    public static void main(String args[]) throws Exception
    {

        Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        BinaryTreeUtils.print(root);
        TreeNode p = root.left;
        TreeNode q = root.right;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("lowestCommonAncestor", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, p, q));
        System.out.println("--------------------------");

        root = BinaryTreeUtils.getTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        BinaryTreeUtils.print(root);
        p = root.left;
        q = root.left.right;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("lowestCommonAncestor", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, p, q));
        System.out.println("--------------------------");

        root = BinaryTreeUtils.getTree(2, 1);
        BinaryTreeUtils.print(root);
        p = root;
        q = root.left;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("lowestCommonAncestor", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, p, q));
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        {
            return null;
        }

        if(p.data < root.data && q.data < root.data)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.data > root.data && q.data > root.data)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else
        {
            return root;
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
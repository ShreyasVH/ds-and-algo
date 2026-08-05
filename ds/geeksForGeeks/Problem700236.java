/*
Lowest Common Ancestor in a BST

Given the root of a Binary Search Tree (BST) with unique node values and two nodes n1 and n2 (n1 != n2), find their Lowest Common Ancestor (LCA).

The Lowest Common Ancestor (LCA) of two nodes is defined as the deepest node in the tree that has both n1 and n2 as descendants, where a node can be a descendant of itself.

Examples:

Input: root = [5, 4, 6, 3, N, N, 7, N, N, N, 8], n1->data = 7, n2->data = 8       
Output: 7
Explanation: 7 is the lowest node that has both 7 and 8 as descendants.

Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], n1->data = 8, n2->data = 14
Output: 8
Explanation: 8 is the lowest node that has both 8 and 14 as descendants.

Input: root = [1, 2, 3], n1->data = 2, n2->data = 3
Output: 1
Explanation: 1 is the lowest node that has both 2 and 3 as descendants.

Constraints:

1 ≤ no. of nodes in root ≤ 10^5
1 ≤ root.node->data ≤ 10^6
1 ≤ n1->data ≤ 10^6
1 ≤ n2->data ≤ 10^6
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700236
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getBst(new int[]{5, 4, 6, 3, 7, 8});
        BinaryTreeUtils.print(root);
        TreeNode n1 = root.right.right;
        TreeNode n2 = root.right.right.right;
        TreeNode lca = (TreeNode) clazz.getMethod("findLCA", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, n1, n2);
        System.out.println(lca.data);

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getBst(new int[]{20, 8, 22, 4, 12, 10, 14});
        BinaryTreeUtils.print(root);
        n1 = root.left;
        n2 = root.left.right.right;
        lca = (TreeNode) clazz.getMethod("findLCA", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, n1, n2);
        System.out.println(lca.data);

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getBst(new int[]{2, 1, 3});
        BinaryTreeUtils.print(root);
        n1 = root.left;
        n2 = root.right;
        lca = (TreeNode) clazz.getMethod("findLCA", TreeNode.class, TreeNode.class, TreeNode.class).invoke(problem, root, n1, n2);
        System.out.println(lca.data);
	}

	public TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if(n1.data < root.data && n2.data < root.data) {
            return findLCA(root.left, n1, n2);
        }
        else if(n1.data > root.data && n2.data > root.data) {
            return findLCA(root.right, n1, n2);
        }
        else {
            return root;
        }
    }
}


/*
Time complexity: O(log n) [balanced tree]
                O(n) [skewed tree]
Space complexity: O(log n) [balanced tree]
                O(n) [skewed tree]
*/
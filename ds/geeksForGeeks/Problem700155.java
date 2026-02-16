/*
Mirror Tree

Given the root of a binary tree, convert the binary tree to its Mirror tree.

Note: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.

Examples:

Input: root = [1, 2, 3, N, N, 4]
Output: [1, 3, 2, N, 4]
Explanation: 

In the inverted tree, every non-leaf node has its left and right child interchanged.
Input: root = [1, 2, 3, 4, 5]
Output: [1, 3, 2, N, N, 5, 4]
Explanation:

In the inverted tree, every non-leaf node has its left and right child interchanged.
Constraints:
1 ≤ number of nodes ≤ 10^4
1 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700155
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3, null, null, 4);
        BinaryTreeUtils.print(root);
        clazz.getMethod("mirror", TreeNode.class).invoke(problem, root);
        BinaryTreeUtils.print(root);

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5);
        BinaryTreeUtils.print(root);
        clazz.getMethod("mirror", TreeNode.class).invoke(problem, root);
        BinaryTreeUtils.print(root);
	}

	public void mirror(TreeNode root) {
        if(root != null)
        {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = right;
            root.right = left;

            mirror(root.left);
            mirror(root.right);
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(h)
*/
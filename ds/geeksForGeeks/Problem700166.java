/*
Balanced Tree Check

Given a binary tree, determine if it is height-balanced. A binary tree is considered height-balanced if the absolute difference in heights of the left and right subtrees is at most 1 for every node in the tree.

Examples:

Input: root[] = [10, 20, 30, 40, 60]

   
Output: true
Explanation: The height difference between the left and right subtrees at all nodes is at most 1. Hence, the tree is balanced.

Input: root[] = [1, 2, 3, 4, N, N, N, 5]
   
Output: false
Explanation: The height difference between the left and right subtrees at node 2 is 2, which exceeds 1. Hence, the tree is not balanced.

Input: root[] = [1, 2, N, N, 3]
   
Output: false
Explanation: The height difference between the left and right subtrees at node 1 is 2, which exceeds 1. Hence, the tree is not balanced.

Constraints:
0 <= number of nodes <= 5000
- 10^4 <= node->data <= 10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700166
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("isBalanced", TreeNode.class).invoke(problem, root));
        System.out.println("--------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, 4, null, null, null, 5);
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("isBalanced", TreeNode.class).invoke(problem, root));
        System.out.println("--------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, null, null, 3);
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("isBalanced", TreeNode.class).invoke(problem, root));
	}

	public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public int checkHeight(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1)
        {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1)
        {
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1)
        {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(h)
*/
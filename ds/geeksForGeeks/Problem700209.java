/*
Delete a node from BST

Given the root of a binary search tree and a node value x. Delete the node with the given value x from the tree. If no node with value x exists, then do not make any change. Return the root of the tree after deleting the node with value x.

Note: You may return any valid BST after deleting the specified node. The driver code will print true if the resulting tree is a valid BST after deletion, and false otherwise.

Examples :

Input: root = [2, 1, 3], x = 12

Output: true
Explanation: In the given input there is no node with value 12, so the tree will remain same.
Input: root = [1, N, 2, N, 8, 5, 11, 4, 7, 9, 12], x = 11

Output: true
Explanation: In the given input, one of the possible tree after deleting 11 will be

Input: root = [2, 1, 3], x = 3

Output: [2, 1]
Explanation: In the given input, only possible tree after deleting 3 will be

Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data, x ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700209
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getBst(new int[]{2, 1, 3});
        int x = 12;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("delNode", TreeNode.class, int.class).invoke(problem, root, x));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getBst(new int[]{1, 2, 8, 4, 5, 7, 11, 9, 12});
        x = 11;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("delNode", TreeNode.class, int.class).invoke(problem, root, x));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getBst(new int[]{2, 1, 3});
        x = 3;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("delNode", TreeNode.class, int.class).invoke(problem, root, x));
	}

    public int minValue(TreeNode root)
    {
        int min = root.data;
        while(root.left != null)
        {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

	public TreeNode delNode(TreeNode root, int x) {
        if(root == null)
        {
            return null;
        }

        if(x < root.data)
        {
            root.left = delNode(root.left, x);
        }
        else if (x > root.data)
        {
            root.right = delNode(root.right, x);
        }
        else
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            else
            {
                root.data = minValue(root.right);

                root.right = delNode(root.right, root.data);
            }
        }

        return root;
    }
}


/*
Time complexity: O(h) - O(log n) [balanced tree]
                        - O(n) [skewed tree]
Space complexity: O(h) - O(log n) [balanced tree]
                        - O(n) [skewed tree]
*/
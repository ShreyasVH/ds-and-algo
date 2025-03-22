/*
Invert Binary Tree


Given the root of a binary tree, invert the tree, and return its root.

 
Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:


Input: root = [2,1,3]
Output: [2,3,1]

Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem48a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(4, 2, 7, 1, 3, 6, 9);
        BinaryTreeUtils.print(root);
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("invertTree", TreeNode.class).invoke(problem, root));
        System.out.println("-------------------------");

        root = BinaryTreeUtils.getTree(2, 1, 3);
        BinaryTreeUtils.print(root);
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("invertTree", TreeNode.class).invoke(problem, root));
        System.out.println("-------------------------");

        root = null;
        BinaryTreeUtils.print(root);
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("invertTree", TreeNode.class).invoke(problem, root));
	}

	public TreeNode invertTree(TreeNode root) {
        if(root != null)
        {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty())
            {
                TreeNode current = q.poll();

                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;

                if(current.left != null)
                {
                    q.offer(current.left);
                }

                if(current.right != null)
                {
                    q.offer(current.right);
                }
            }
        }

        return root;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
/*
Size of Binary Tree

Given a binary tree, you have to return the size of it. Size of binary tree is defined as number of nodes in it.

Examples:

Input:      
       1
     /  \
    2    3
Output: 3
Explanation: There are three nodes in given binary tree.

Input:
      10
     /  \
   5     9
   \    / \
    1 3   6
Output: 6
Explanation: There are six nodes in given binary tree.

Input:
      1
Output: 1
Explanation: There is one nodes in given binary tree.

Constraints:
1 <= number of nodes <= 10^5
1 <= node->data <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700134
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("getSize", TreeNode.class).invoke(problem, root));

        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(10, 5, 9, null, 1, 3, 6);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("getSize", TreeNode.class).invoke(problem, root));

        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(1);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("getSize", TreeNode.class).invoke(problem, root));
	}

	public static int getSize(TreeNode node) {
        if(node == null)
        {
            return 0;
        }

        return getSize(node.left) + getSize(node.right) + 1;
    }
}


/*
Time complexity: O(N)
Space complexity: O(log N) [average case]
                  O(N) [worst case skewed tree]
*/
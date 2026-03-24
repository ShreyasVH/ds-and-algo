/*
Postorder Traversal

Given the root of a Binary Tree, your task is to return its Postorder Traversal.

Note: A postorder traversal first visits the left child (including its entire subtree), then visits the right child (including its entire subtree), and finally visits the node itself.

Examples:

Input: root = [19, 10, 8, 11, 13]

Output: [11, 13, 10, 8, 19]
Explanation: The postorder traversal of the given binary tree is [11, 13, 10, 8, 19].
Input: root = [11, 15, N, 7]
 
Output: [7, 15, 11]
Explanation: The postorder traversal of the given binary tree is [7, 15, 11].
Constraints:
1 ≤ number of nodes ≤ 3*10^4
0 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700199a
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(19, 10, 8, 11, 13);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("postOrder", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(11, 15, null, 7);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("postOrder", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;

        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }

            TreeNode curr = stack.peek();

            if(curr.right == null || curr.right == prev)
            {
                result.add(curr.data);
                stack.pop();
                prev = curr;
            }
            else
            {
                root = curr.right;
            }
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(h) [O(log n) - balanced tree]
                        [O(n) - skewed tree]
*/
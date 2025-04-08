/*
Maximum Width of Tree

Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes at any level.

Examples:

Input: root = [1, 2, 3]
       1
     /    \
    2      3
Output: 2
Explanation: On the first level there is only one node 1. On the second level there are two nodes 2, 3 clearly it is the maximum number of nodes at any level

Input: root = [10, 20, 30, 40, 60]
        10
      /     \
    20      30
   /    \
  40    60
Output: 2
Explanation: There is one node on level 1(10) There is two node on level 2(20, 30) There is two node on level 3(40, 60) Hence the answer is 2
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(width of the tree).

Constraints:
1 <= number of nodes<= 10^5
0 <= node->data <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700159
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("getMaxWidth", TreeNode.class).invoke(problem, root));
        System.out.println("------------------------------");

        root = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("getMaxWidth", TreeNode.class).invoke(problem, root));
	}

	public int getMaxWidth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxWidth = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();

                if(curr.left != null)
                {
                    q.offer(curr.left);
                }

                if(curr.right != null)
                {
                    q.offer(curr.right);
                }
            }

            maxWidth = Math.max(maxWidth, size);
        }
        return maxWidth;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
/*
Level Order in Spiral

Given a root binary tree and the task is to find the spiral order traversal of the tree and return the list containing the elements.
Spiral Order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right.

Examples:

Input: root = [1, 3, 2]
 
Output: [1, 3, 2]
Explanation: Start with root (1), print level 0 (right to left), then level 1 (left to right).
Input: root = [10, 20, 30, 40, 60]

Output: [10, 20, 30, 60, 40]
Explanation: Start with root (10), print level 0 (right to left), level 1 (left to right), and continue alternating.
Constraints:
1  ≤ number of nodes  ≤10^5
0  ≤ node->data  ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700201
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 3, 2);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("findSpiral", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("findSpiral", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> findSpiral(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Stack<Integer> stack = new Stack<>();
        boolean reversed = true;
        ArrayList<Integer> result = new ArrayList<>();

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();

                if(reversed)
                {
                    stack.push(curr.data);
                }
                else
                {
                    result.add(curr.data);
                }

                if(curr.left != null)
                {
                    q.offer(curr.left);
                }

                if(curr.right != null)
                {
                    q.offer(curr.right);
                }
            }

            while(!stack.isEmpty())
            {
                result.add(stack.pop());
            }

            reversed = !reversed;
        }
        
        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(w) [O(n) for balanced tree]
                    [O(1) for skewed tree]
*/
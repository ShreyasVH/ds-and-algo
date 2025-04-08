/*
K distance from root

Given a binary tree having n nodes and an integer k. Print all nodes that are at distance k from the root (root is considered at distance 0 from itself). Nodes should be printed from left to right.

Example 1:

Input:
k = 0
      1
    /   \
   3     2
Output: 1
Explanation: 1 is the only node which is 0 distance from the root 1.

Example 2:

Input:
k = 3
        1
       /
      2
       \
        1
      /  \
     5    3
Output: 5 3
Explanation:  5 and 3 are the nodes which are at distance 3 from the root 3.
Here, returning 3 5 will be incorrect.
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root node and k as parameters and returns the value of the nodes that are at a distance k from the root.

Constraints:
1 <= n <= 10^4
0 <= k <= 30

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700154a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 3, 2);
        // BinaryTreeUtils.print(root);
        int k = 0;
        System.out.println((ArrayList<Integer>) clazz.getMethod("Kdistance", TreeNode.class, int.class).invoke(problem, root, k));
        System.out.println("------------------------");

        root = BinaryTreeUtils.getTree(1, 2, null, null, 1, 5, 3);
        // BinaryTreeUtils.print(root);
        k = 3;
        System.out.println((ArrayList<Integer>) clazz.getMethod("Kdistance", TreeNode.class, int.class).invoke(problem, root, k));
	}

	public ArrayList<Integer> Kdistance(TreeNode root, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(root != null)
        {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int depth = 0;
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

                    if(depth == k)
                    {
                        result.add(curr.data);
                    }
                }
                depth++;
            }
        }
        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
/*
Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem42a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 9, 20, null, null, 15, 7);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxDepth", TreeNode.class).invoke(problem, root));
        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(1, null, 2);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxDepth", TreeNode.class).invoke(problem, root));
	}

	public int maxDepth(TreeNode root) {
        int depth = 0;

        if(root != null)
        {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty())
            {
                int size = q.size();
                depth++;

                for(int i = 0; i < size; i++)
                {
                    TreeNode current = q.poll();

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
        }

        return depth;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for queue]
*/
/*
Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem41a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 9, 20, null, null, 15, 7);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("minDepth", TreeNode.class).invoke(problem, root));

        System.out.println("---------------------------------");


        root = BinaryTreeUtils.getTree(2, null, 3, null, 4, null, 5, null, 6);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("minDepth", TreeNode.class).invoke(problem, root));
	}

	public int minDepth(TreeNode root) {
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

                    if(current.left == null && current.right == null)
                    {
                        return depth;
                    }

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
Space complexity: O(n)
*/
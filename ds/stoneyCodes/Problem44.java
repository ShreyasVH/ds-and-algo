/*
Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem44
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 9, 20, null, null, 15, 7);
        BinaryTreeUtils.print(root);
        System.out.println((List<List<Integer>>) clazz.getMethod("levelOrder", TreeNode.class).invoke(problem, root));
        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(1);
        BinaryTreeUtils.print(root);
        System.out.println((List<List<Integer>>) clazz.getMethod("levelOrder", TreeNode.class).invoke(problem, root));
        System.out.println("---------------------------");

        root = null;
        BinaryTreeUtils.print(root);
        System.out.println((List<List<Integer>>) clazz.getMethod("levelOrder", TreeNode.class).invoke(problem, root));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root != null)
        {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty())
            {
                int size = q.size();

                List<Integer> level = new ArrayList<>();
                for(int i = 0; i < size; i++)
                {
                    TreeNode current = q.poll();

                    level.add(current.data);

                    if(current.left != null)
                    {
                        q.offer(current.left);
                    }

                    if(current.right != null)
                    {
                        q.offer(current.right);
                    }
                }

                result.add(level);
            }
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for queue]
*/
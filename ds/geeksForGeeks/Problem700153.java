/*
Right View of Binary Tree

Given a Binary Tree, Your task is to return the values visible from Right view of it.

Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Examples :

Input: root = [1, 2, 3, 4, 5]
        1
       / \
     2    3
    / \
   4   5
Output: [1, 3, 5]

Input: root = [1, 2, 3, 4, N, N, 5]
           1
         /   \
        2     3
      /         
     4
       \
        5           
Output: [1, 3, 4, 5]

Input: root = [10, 20, 90, 40, 60]
     10
    /   \
  20     90
 /   \
40  60 
Output: [10, 90, 60]
Constraints:
1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700153
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("rightView", TreeNode.class).invoke(problem, root));
        System.out.println("----------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, 4, null, null, null, null, 5);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("rightView", TreeNode.class).invoke(problem, root));
        System.out.println("----------------------------------");

        root = BinaryTreeUtils.getTree(10, 20, 90, 40, 60);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("rightView", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(i == size - 1)
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
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [worst case]
*/
/*
Reverse Level Order Traversal

Given a binary tree, find its reverse level order traversal. ie- the traversal must begin from the last level.

Examples :

Input: root = [1, 3, 2]
        1
      /   \
     3     2
Output: 3 2 1
Explanation: Traversing level 1 : 3 2, Traversing level 0 : 1
Input: root = [10, 20, 30, 40, 60]
       10
      /  \
     20   30
    / \ 
   40  60
Output: 40 60 20 30 10
Explanation: Traversing level 2 : 40 60, Traversing level 1 : 20 30, Traversing level 0 : 10
Input: root = [1, 2, 3]
        1
      /   \
     2     3
Output: 2 3 1
Constraints:
1 ≤ n ≤ 10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700202
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 3, 2);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("reverseLevelOrder", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("reverseLevelOrder", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("reverseLevelOrder", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> reverseLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Stack<ArrayList<Integer>> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while(!q.isEmpty())
        {
            int size = q.size();

            ArrayList<Integer> levelValues = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                levelValues.add(curr.data);

                if(curr.left != null)
                {
                    q.offer(curr.left);
                }

                if(curr.right != null)
                {
                    q.offer(curr.right);
                }
            }

            stack.push(levelValues);
        }

        while(!stack.isEmpty())
        {
            ArrayList<Integer> levelValues = stack.pop();
            for(int val : levelValues)
            {
                result.add(val);
            }
        }
        
        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(w) [O(n) for balanced tree]
                    [O(1) for skewed tree]
*/
/*
Left View of Binary Tree

Given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.

Note: If the tree is empty, return an empty list.

Examples :

Input: root = [1, 2, 3, 4, 5, N, N]

Output:[1, 2, 4]
Explanation: From the left side of the tree, only the nodes 1, 2, and 4 are visible.


Input: root = [1, 2, 3, N, N, 4, N, N, 5, N, N]

Output: [1, 2, 4, 5]
Explanation: From the left side of the tree, only the nodes 1, 2, 4, and 5 are visible.

Constraints:
0 ≤ number of nodes ≤ 10^5
0 ≤ node -> data ≤ 10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700174
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("leftView", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, null, null, 4, null, null, 5);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("leftView", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(i == 0)
                {
                    result.add(Integer.parseInt(String.valueOf(curr.data)));
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
Space complexity: O(w)
*/
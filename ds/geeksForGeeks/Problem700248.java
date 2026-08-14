/*
Level Order Line by Line

Given root of a binary Tree,  return its level order traversal.
Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, N, N, N, 8]
               
Output: [[1], [2, 3], [4, 5, 6, 7], [8]]
Explanation:  At first level 1 present then at second level 2 3 present at third level 4 5 6 7 present and at fourth level 8 present.


Input: root = [10, 20, 30, 40, 60]
                    
Output: [[10], [20, 30] , [40, 60]] 
Explanation: At first level 10 present then at second level 20 30 present then at third level 40 60 present.

Constraints:
1 ≤ number of nodes ≤ 1000
0 ≤ node->data ≤ 100

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700248
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5, 6, 7, null, null, null, null, null, 8);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<ArrayList<Integer>>) clazz.getMethod("levelOrder", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<ArrayList<Integer>>) clazz.getMethod("levelOrder", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            ArrayList<Integer> levelItems = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                levelItems.add(curr.data);

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            result.add(levelItems);
        }
        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for queue]
*/
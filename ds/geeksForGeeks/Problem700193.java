/*
Diagonal Tree Traversal

Given a Binary Tree, return the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, return a single list containing all diagonal elements in a binary tree belonging to same line.
If the diagonal element are present in two different subtrees then left subtree diagonal element should be taken first and then right subtree. 

Examples :

Input : root = [8, 3, 10, 1, 6, N, 14, N, N, 4, 7, 13]

Output : [8, 10, 14, 3, 6, 7, 13, 1, 4]
Explanation:

Diagonal Traversal of binary tree : 8 10 14 3 6 7 13 1 4
Input: root = [1, 2, N, 3, N]

Output: [1, 2, 3]
Constraints:
1 <= number of nodes<= 10^5
1 <= node->data <= 10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700193
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13);
        System.out.println((ArrayList<Integer>) clazz.getMethod("diagonal", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, null, 3);
        System.out.println((ArrayList<Integer>) clazz.getMethod("diagonal", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> diagonal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> result = new ArrayList<>();

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            while(curr != null)
            {
                result.add(curr.data);

                if(curr.left != null)
                {
                    q.offer(curr.left);
                }

                curr = curr.right;
            }
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(w) [O(n) worst case]
*/
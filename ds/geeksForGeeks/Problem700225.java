/*
Root to leaf path sum

Given a binary tree and an integer target, check whether there is a root-to-leaf path with its sum as target.

Examples :

Input: target = 2
   1 
 /   \
2     3
Output: false
Explanation: There is no root to leaf path with sum 2.
Input: target = 4
   1
 /   \
2     3
Output: true
Explanation: The sum of path from leaf node 3 to root 1 is 4.
Constraints:
1 ≤ number of nodes ≤ 10^4
1 ≤ target ≤ 10^6



*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700225
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3);
        int target = 2;
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("hasPathSum", TreeNode.class, int.class).invoke(problem, root, target));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3);
        target = 4;
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("hasPathSum", TreeNode.class, int.class).invoke(problem, root, target));
	}

	public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        int newTarget = target - root.data;
        return (newTarget == 0 && root.left == null && root.right == null) || hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}


/*
Time complexity: O(n)
Space complexity: O(h) 
    O(log N) [balanced tree]
    O(N) [skewed tree]

*/
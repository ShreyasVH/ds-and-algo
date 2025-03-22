/*
Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-10^4 <= Node.val <= 10^4

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem45
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root1 = BinaryTreeUtils.getTree(1, 2, 3);
        TreeNode root2 = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(root1);
        BinaryTreeUtils.print(root2);
        System.out.println((boolean) clazz.getMethod("isSameTree", TreeNode.class, TreeNode.class).invoke(problem, root1, root2));
        System.out.println("---------------------------");

        root1 = BinaryTreeUtils.getTree(1, 2);
        root2 = BinaryTreeUtils.getTree(1, null, 2);
        BinaryTreeUtils.print(root1);
        BinaryTreeUtils.print(root2);
        System.out.println((boolean) clazz.getMethod("isSameTree", TreeNode.class, TreeNode.class).invoke(problem, root1, root2));
        System.out.println("---------------------------");

        root1 = BinaryTreeUtils.getTree(1, 2, 3);
        root2 = BinaryTreeUtils.getTree(1, 3, 2);
        BinaryTreeUtils.print(root1);
        BinaryTreeUtils.print(root2);
        System.out.println((boolean) clazz.getMethod("isSameTree", TreeNode.class, TreeNode.class).invoke(problem, root1, root2));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }

        if(p == null || q == null)
        {
            return false;
        }

        return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for reecursion stack]
*/
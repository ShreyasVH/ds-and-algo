/*
Identical Trees

Given two binary trees with their root nodes r1 and r2, return true if both of them are identical, otherwise, false.

Examples:

Input:
    1           1
   /  \       /   \
  2    3     2     3
Output: true
Explanation: 
There are two trees both having 3 nodes and 2 edges, both trees are identical having the root as 1, left child of 1 is 2 and right child of 1 is 3.
Input:
    1        1
   /  \     /  \
  2    3   3    2
Output: false
Explanation: There are two trees both having 3 nodes and 2 edges, but both trees are not identical.
Input:
    1   1
   /      \
  2        2
Output: false
Explanation: Although both trees have the same node values (1 and 2), they are arranged differently, making the trees non-identical.
Constraints:
1 <= number of nodes <= 10^5
1 <= node->data <= 10^9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700222a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode r1 = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(r1);
        TreeNode r2 = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(r2);
        System.out.println((boolean) clazz.getMethod("isIdentical", TreeNode.class, TreeNode.class).invoke(problem, r1, r2));

        System.out.println("----------------------");

        r1 = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(r1);
        r2 = BinaryTreeUtils.getTree(1, 3, 2);
        BinaryTreeUtils.print(r2);
        System.out.println((boolean) clazz.getMethod("isIdentical", TreeNode.class, TreeNode.class).invoke(problem, r1, r2));

        System.out.println("----------------------");

        r1 = BinaryTreeUtils.getTree(1, 2);
        BinaryTreeUtils.print(r1);
        r2 = BinaryTreeUtils.getTree(1, null, 2);
        BinaryTreeUtils.print(r2);
        System.out.println((boolean) clazz.getMethod("isIdentical", TreeNode.class, TreeNode.class).invoke(problem, r1, r2));
	}

	public boolean isIdentical(TreeNode r1, TreeNode r2) {
        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[]{r1, r2});

        while(!q.isEmpty())
        {
            TreeNode[] items = q.poll();

            TreeNode curr1 = items[0];
            TreeNode curr2 = items[1];

            if(curr1 == null && curr2 == null)
            {
                //
            }
            else if(curr1 == null || curr2 == null)
            {
                return false;
            }
            else
            {
                if(curr1.data != curr2.data)
                {
                    return false;
                }

                q.offer(new TreeNode[]{curr1.left, curr2.left});
                q.offer(new TreeNode[]{curr1.right, curr2.right});
            }


        }

        return true;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
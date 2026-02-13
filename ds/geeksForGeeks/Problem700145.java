/*
Count Leaves in Binary Tree

Given a Binary Tree of size n, You have to count leaves in it. For example, there are two leaves in the following tree


 

Examples:

Input:
Given Tree is  

Output: 3
Explanation: Three leaves are 3, 5 and 1.
Input:
Given Tree is

Output: 4
Explanation: Four leaves are 20, 40, 65 and 80.
Input:
Given Tree is  

Output: 3
Explanation: Three leaves are 20, 27 and 40.
 Constraints:
1<= number of nodes <= 10^5
1<= node->data <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700145
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 10, 39, 5, null, null, null);
        System.out.println((int) clazz.getMethod("countLeaves", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(4, 8, 10, 7, null, 5, 1, 3, null);
        System.out.println((int) clazz.getMethod("countLeaves", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(50, 30, 70, 20, 40, 60, 80, null, null, null, null, null, 65, null, null, null, null);
        System.out.println((int) clazz.getMethod("countLeaves", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(30, 25, 35, 20, 28, null, 40, null, null, 27, null, null, null, null, null);
        System.out.println((int) clazz.getMethod("countLeaves", TreeNode.class).invoke(problem, root));
	}

	public int countLeaves(TreeNode node) {
        int[] count = {0};
        countLeaves(node, count);
        return count[0];
    }

    public void countLeaves(TreeNode node, int[] count) {
        if(node != null)
        {
            countLeaves(node.left, count);
            if(node.left == null && node.right == null)
            {
                count[0]++;
            }
            countLeaves(node.right, count);
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(log n) [balanced]
                    O(n) [skewed]
*/
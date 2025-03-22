/*
Find maximum value of binary tree

Given a binary tree, find the maximum value present.


Example 1:
Input: root = [1, 7, 8, null, null, 9, 6]
Output: 9

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem43
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 7, 8, null, null, 9, 6);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxValue", TreeNode.class).invoke(problem, root));
	}

	public int maxValue(TreeNode root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maxValue(root.left), maxValue(root.right)));
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for stack]
*/
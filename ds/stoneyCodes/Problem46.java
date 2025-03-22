/*
Path Sum

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem46
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        int target = 22;
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("hasPathSum", TreeNode.class, int.class).invoke(problem, root, target));
        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3);
        target = 5;
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("hasPathSum", TreeNode.class, int.class).invoke(problem, root, target));
        System.out.println("---------------------------");

        root = null;
        target = 0;
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("hasPathSum", TreeNode.class, int.class).invoke(problem, root, target));

	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
        {
            return false;
        }

        return (0 == targetSum - root.data && root.left == null && root.right == null) || hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
    }
}


/*
Time complexity: O(n)
Space complexity: O(h)
*/
/*
Sum Tree

Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.

A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

Examples:

Input:
    3
  /   \    
 1     2
Output: true
Explanation: The sum of left subtree and right subtree is 1 + 2 = 3, which is the value of the root node. Therefore,the given binary tree is a sum tree.

Input:
          10
        /    \
      20      30
    /   \ 
   10    10
Output: false
Explanation: The given tree is not a sum tree. For the root node, sum of elements in left subtree is 40 and sum of elements in right subtree is 30. Root element = 10 which is not equal to 30+40.

Input:
   25
  /   \    
 9     15
Output: false

Constraints:
2 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700179
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 1, 2);
        System.out.println((boolean) clazz.getMethod("isSumTree", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(10, 20, 30, 10, 10);
        System.out.println((boolean) clazz.getMethod("isSumTree", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(25, 9, 15);
        System.out.println((boolean) clazz.getMethod("isSumTree", TreeNode.class).invoke(problem, root));
	}

    public int sum(TreeNode root)
    {
        if(root != null)
        {
            return sum(root.left) + sum(root.right) + Integer.parseInt(String.valueOf(root.data));
        }
        return 0;
    }

	public boolean isSumTree(TreeNode root) {
        if(root != null)
        {
            if(root.left == null && root.right == null)
            {
                return true;
            }

            return isSumTree(root.left) && isSumTree(root.right) && Integer.parseInt(String.valueOf(root.data)) == (sum(root.left) + sum(root.right));
        }
        
        return true;
    }
}


/*
Time complexity: O(n ^ 2)
Space complexity: O(h)
*/
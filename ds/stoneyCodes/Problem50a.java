/*
Search in a Binary Search Tree

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:

Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:

Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 10^7
root is a binary search tree.
1 <= val <= 10^7

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem50a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(4, 2, 7, 1, 3);
        BinaryTreeUtils.print(root);
        int val = 2;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("searchBST", TreeNode.class, int.class).invoke(problem, root, val));
        System.out.println("-----------------------");

        root = BinaryTreeUtils.getTree(4, 2, 7, 1, 3);
        BinaryTreeUtils.print(root);
        val = 5;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("searchBST", TreeNode.class, int.class).invoke(problem, root, val));
	}

	public TreeNode searchBST(TreeNode root, int val) {
        while(root != null)
        {
            if(val < root.data)
            {
                root = root.left;
            }
            else if(val > root.data)
            {
                root = root.right;
            }
            else
            {
                break;
            }
        }
        return root;
    }
}


/*
Time complexity: O(log n)
Space complexity: O(1)
*/
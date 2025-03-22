/*
Insert into a Binary Search Tree

You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 

Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:

Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]

Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 

Constraints:

The number of nodes in the tree will be in the range [0, 10^4].
-10^8 <= Node.val <= 10^8
All the values Node.val are unique.
-10^8 <= val <= 10^8
It's guaranteed that val does not exist in the original BST.
*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem51a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(4, 2, 7, 1, 3);
        BinaryTreeUtils.print(root);
        int val = 5;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("insertIntoBST", TreeNode.class, int.class).invoke(problem, root, val));
        System.out.println("-----------------------");

        root = BinaryTreeUtils.getTree(40, 20, 60, 10, 30, 50, 70);
        BinaryTreeUtils.print(root);
        val = 25;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("insertIntoBST", TreeNode.class, int.class).invoke(problem, root, val));
        System.out.println("-----------------------");

        root = BinaryTreeUtils.getTree(4, 2, 7, 1, 3, null, null, null, null, null, null, null);
        BinaryTreeUtils.print(root);
        val = 5;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("insertIntoBST", TreeNode.class, int.class).invoke(problem, root, val));
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null)
        {
            root = node;
        }
        else
        {
            TreeNode parent = null;
            TreeNode current = root;

            while(current != null)
            {
                parent = current;
                if(val <= current.data)
                {
                    current = current.left;
                }
                else
                {
                    current = current.right;
                }
            }

            if(val <= parent.data)
            {
                parent.left = node;
            }
            else
            {
                parent.right = node;
            }
        }

        return root;
    }
}


/*
Time complexity: O(log n) [average case]
Space complexity: O(1)
*/
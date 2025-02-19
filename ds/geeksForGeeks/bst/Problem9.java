/*
	Search a node in BST

	Given a Binary Search Tree and a node value X, find if the node with value X is present in the BST or not.

			2
			  \
			    81
			   /  \
			  42   87
			    \    \
			    66    90
			   /
			  45

			  x: 87
			  Output: true



			   6
			    \
				 8
				/ \
			   7   9

		   x: 11
		   Output: false
*/

package ds.geeksForGeeks.bst;

import utils.TreeNode;
import utils.BinaryTreeUtils;

public class Problem9
{
	public static void main(String[] args)
	{
		System.out.println(search(BinaryTreeUtils.getBst(new int[]{2, 81, 42, 87, 66, 90, 45}), 87));
		System.out.println(search(BinaryTreeUtils.getBst(new int[]{6, 8, 7, 9}), 11));
	}

	public static boolean search(TreeNode root, int x) {
        if(root == null)
        {
        	return false;
        }

        if(x == root.data)
        {
        	return true;
        } else if (x < root.data)
        {
        	return search(root.left, x);
        }
        else
        {
        	return search(root.right, x);
        }
    }
}



/*
	Time complexity: O(1) best case [root itself is the key]
					 O(log n) average case
					 O(n) [skewed tree]
	Space complexity: O(1) best case [root itself is the key]
				 	  O(log n) average case
					  O(n) [skewed tree]
*/
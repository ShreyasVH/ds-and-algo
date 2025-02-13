/*
	Add all greater values to every node in a BST

	Given a BST, modify it so that all greater values in the given BST are added to every node.

			50
		   /   \
		 30		70
	    /  \   /  \
	  20   40 60   80

	  Output:
		
			  260
		   /      \
		 330	   150
	    /  \     /     \
	  350   300 210     80
*/

package ds.geeksForGeeks.bst;

import utils.BinaryTreeUtils;
import utils.TreeNode;

public class Problem3a
{
	public static void main(String[] args)
	{

		TreeNode root = BinaryTreeUtils.getBst(new int[]{50, 30, 70, 20, 40, 60, 80});
		modify(root);
		BinaryTreeUtils.print(root);

		root = BinaryTreeUtils.getBst(new int[]{4, 2, 6, 1, 3, 5, 7});
		modify(root);
		BinaryTreeUtils.print(root);

	}

	public static void modify(TreeNode root)
	{
		int[] sum = {0};
		modify(root, sum);
	}

	public static void modify(TreeNode root, int[] sum)
	{
		if(root != null)
		{
			modify(root.right, sum);
			sum[0] += root.data;
			root.data = sum[0];
			modify(root.left, sum);
		}
	}
}


/*
	Time Complexity: O(n)
	Space Complexity: O(h) [used for recursion]
*/
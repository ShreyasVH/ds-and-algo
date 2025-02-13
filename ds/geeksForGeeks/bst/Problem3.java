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

import utils.BinaryTreeUtils;
import utils.TreeNode;

public class Problem3
{
	public static void main(String[] args)
	{

		TreeNode root = BinaryTreeUtils.getBst(new int[]{50, 30, 70, 20, 40, 60, 80});
		modify(root);
		BinaryTreeUtils.print(root);

	}

	public static modify(TreeNode root)
	{
		modify(root, 0);
	}

	public static modify(TreeNode root, int parentSum)
	{
		if(root != null)
		{
			modify(root.right, 0);
			if(root.right != null)
			{
				root.data = root.data + root.right.data;
			}
			root.data = root.data + parentSum;
			modify(root.left, root.data);
		}
	}
}
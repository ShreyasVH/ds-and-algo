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

public class Problem3b
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
		TreeNode curr = root;
		while(curr != null)
		{
			if(curr.right == null)
			{
				sum[0] += curr.data;
				curr.data = sum[0];
				curr = curr.left;
			}
			else
			{
				TreeNode next = curr.right;
				while(next.left != null && next.left != curr)
				{
					next = next.left;
				}

				if(next.left == null)
				{
					next.left = curr;
					curr = curr.right;
				}
				else
				{
					next.left = null;
					sum[0] += curr.data;
					curr.data = sum[0];

					curr = curr.left;
				}
			}
		}
	}
}


/*
	Time Complexity: O(3n)
	Space Complexity: O(1) 
*/
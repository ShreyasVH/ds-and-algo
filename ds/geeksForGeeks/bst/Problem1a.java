package ds.geeksForGeeks.bst;

/*

	Count BST nodes that lie in a given range

	Given a Binary Search Tree (BST) and a range l-h (inclusive), your task is to return the number of nodes in the BST whose value lie in the given range.

				  10
				/ 	\
   			   5  	 50
			  /    / 	\
 			1  	 40   	100
	
	l = 5 h = 45

	Output: 3



*/

import utils.BinaryTreeUtils;
import utils.TreeNode;



public class Problem1a
{
	public static void main(String[] args)
	{
		System.out.println(getCount(BinaryTreeUtils.getBst(new int[]{10, 5, 50, 1, 40, 100}), 5, 45));
		System.out.println();
		System.out.println(getCount(BinaryTreeUtils.getBst(new int[]{10, 5, 50, 1, 40, 100}), 10, 100));
		System.out.println();
		System.out.println(getCount(BinaryTreeUtils.getBst(new int[]{1, 2, 3}), 23, 95));
		System.out.println();
		System.out.println(getCount(BinaryTreeUtils.getBst(new int[]{10, 5, 15, 8, 12}), 7, 12));
		System.out.println();
	}

	public static int getCount(TreeNode root, int l, int h)
	{
		int count = 0;

		TreeNode curr = root;
		while(curr != null)
		{
			if(curr.left == null)
			{
				if(curr.data >= l && curr.data <= h)
				{
					count++;
				}
				curr = curr.right;
			}
			else
			{

				TreeNode prev = curr.left;
				while(prev.right != null && prev.right != curr)
				{
					prev = prev.right;
				}

				if(prev.right == null)
				{
					prev.right = curr;
					curr = curr.left;
				}
				else
				{
					prev.right = null;
					if(curr.data >= l && curr.data <= h)
					{
						count++;
					}

					curr = curr.right;
				}
			}
		}

		return count;
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
	Time taken for 1111 GFG tests: 0.29s

*/
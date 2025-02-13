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



public class Problem1
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
		if(root == null)
		{
			return 0;
		}
		return getCount(root.left, l, h) + getCount(root.right, l, h) + ((root.data >= l && root.data <= h) ? 1 : 0);
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(n) worst case
					O(log n) for balanced tree

*/
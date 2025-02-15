/*
	Fixing Two nodes of a BST

	Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
	Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original linked list.


					10
				   /  \
				  5    8
				 / \
				2   20

				Output:
					10
				   /  \
				  5    20
				 / \
				2   8



					5
				   /  \
				  10  20
				 / \
				2   8

				Output:
					10
				   /  \
				  5    20
				 / \
				2   8
*/

package ds.geeksForGeeks.problemOfTheDay.d20250214;

import utils.BinaryTreeUtils;
import utils.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Problem1c
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(20);
		BinaryTreeUtils.print(root);
		correctBST(root);
		BinaryTreeUtils.print(root);
		System.out.println();

		root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(8);
		BinaryTreeUtils.print(root);
		correctBST(root);
		BinaryTreeUtils.print(root);
		System.out.println();
	}

	public static void swap(TreeNode n1, TreeNode n2)
	{
		int temp = n1.data;
		n1.data = n2.data;
		n2.data = temp;
	}

	public static void correctBST(TreeNode root)
	{

		TreeNode first = null;
		TreeNode middle = null;
		TreeNode last = null;
		TreeNode previous = null;
		TreeNode curr = root;

		while(curr != null)
		{
			if(curr.left == null)
			{
				if(previous != null && curr.data < previous.data)
				{
					if(first == null)
					{
						first = previous;
						middle = curr;
					}
					else
					{
						last = curr;
					}
				}
				previous = curr;
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

					
					if(previous != null && curr.data < previous.data)
					{
						if(first == null)
						{
							first = previous;
							middle = curr;
						}
						else
						{
							last = curr;
						}
					}
					previous = curr;
					curr = curr.right;
				}
			}

		}

		if(first != null && last != null)
		{
			swap(first, last);
		} else if(first != null && middle != null)
		{
			swap(first, middle);
		}
	}
}

/*
	Time complexity: O(n)
	Space Complexity: O(1)

*/
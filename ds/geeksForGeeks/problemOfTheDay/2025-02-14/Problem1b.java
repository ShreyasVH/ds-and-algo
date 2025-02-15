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

public class Problem1b
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
		TreeNode[] first = {null};
		TreeNode[] middle = {null};
		TreeNode[] last = {null};
		TreeNode[] previous = {null};
		
		correctBST(root, first, middle, last, previous);

		if(first[0] != null && last[0] != null)
		{
			swap(first[0], last[0]);
		} else if(first[0] != null && middle[0] != null)
		{
			swap(first[0], middle[0]);
		}
	}

	public static void correctBST(TreeNode root, TreeNode[] first, TreeNode[] middle, TreeNode[] last, TreeNode[] previous)
	{
		if(root != null)
		{
			correctBST(root.left, first, middle, last, previous);
			if(previous[0] != null && root.data < previous[0].data)
			{
				if(first[0] == null)
				{
					first[0] = previous[0];
					middle[0] = root;
				}
				else
				{
					last[0] = root;
				}
			}

			previous[0] = root;
			correctBST(root.right, first, middle, last, previous);
		}
	}
}

/*
	Time complexity: O(n)
	Space Complexity: O(n) [worst case, skewed tree]
					  O(log n) [best case, balanced tree]

*/
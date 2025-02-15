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

public class Problem1a
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

	public static void correctBST(TreeNode root)
	{
		List<Integer> inOrder = BinaryTreeUtils.morrisTraversal(root);
		Collections.sort(inOrder);
		// System.out.println(inOrder);

		correctBST(root, inOrder);
	}

	public static void correctBST(TreeNode root, List<Integer> inOrder)
	{

		int index = 0;
		TreeNode curr = root;

		while(curr != null)
		{
			if(curr.left == null)
			{
				curr.data = inOrder.get(index);
				index++;
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

					curr.data = inOrder.get(index);
					index++;
					curr = curr.right;
				}
			}
		}
	}
}

/*
	Time complexity: O(nlogn) [sorting the list]
	Space Complexity: O(n) [worst case, skewed tree]
					  O(log n) [best case, balanced tree]

*/
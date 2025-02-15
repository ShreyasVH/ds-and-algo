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

public class Problem1
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

		correctBST(root, inOrder, new int[]{0});
	}

	public static void correctBST(TreeNode root, List<Integer> inOrder, int[] index)
	{
		if(root != null)
		{
			correctBST(root.left, inOrder, index);
			root.data = inOrder.get(index[0]);
			index[0]++;
			correctBST(root.right, inOrder, index);
		}
	}
}

/*
	Time complexity: O(nlogn) [sorting the list]
	Space Complexity: O(n)

*/
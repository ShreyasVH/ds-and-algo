/*
	Is Binary Tree Heap

	You are given a binary tree, and the task is to determine whether it satisfies the properties of a max-heap.

	A binary tree is considered a max-heap if it satisfies the following conditions:

	Completeness: Every level of the tree, except possibly the last, is completely filled, and all nodes are as far left as possible.
	Max-Heap Property: The value of each node is greater than or equal to the values of its children.


						97
					   /  \
					  46    37
					 / \   /  \
					12  3 7    31
				   /  \
				  6    9

				  Output: true


						  97
					    /    \
					  46      37
					 / \     /  \
					12  3   7    31
				   	   / \
				      2   4

				  Output: false


				  	5
				   / \
				  2   3

				  Output: true
*/

package ds.geeksForGeeks.bst;

import utils.BinaryTreeUtils;
import utils.TreeNode;

public class Problem8
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(97);
		root.left = new TreeNode(46);
		root.right = new TreeNode(37);
		root.left.left = new TreeNode(12);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(31);
		root.left.left.left = new TreeNode(6);
		root.left.left.right = new TreeNode(9);
		BinaryTreeUtils.print(root);
		System.out.println(isHeap(root));

		System.out.println("----------------------------------------------");

		root = new TreeNode(97);
		root.left = new TreeNode(46);
		root.right = new TreeNode(37);
		root.left.left = new TreeNode(12);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(31);
		root.left.right.left = new TreeNode(2);
		root.left.right.right = new TreeNode(4);
		BinaryTreeUtils.print(root);
		System.out.println(isHeap(root));

		System.out.println("----------------------------------------------");

		root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		BinaryTreeUtils.print(root);
		System.out.println(isHeap(root));
	}

	public static boolean isComplete(TreeNode root, int index, int nodeCount)
	{
		if(root == null)
		{
			return true;
		}

		if(index >= nodeCount)
		{
			return false;
		}

		return isComplete(root.left, 2 * index + 1, nodeCount) && isComplete(root.right, 2 * index + 2, nodeCount);
	}

	public static boolean hasMaxHeapProperty(TreeNode root)
	{
		if(root == null)
		{
			return true;
		}

		if(root.left != null && root.data <= root.left.data)
		{
			return false;
		}

		if(root.right != null && root.data <= root.right.data)
		{
			return false;
		}

		return hasMaxHeapProperty(root.left) && hasMaxHeapProperty(root.right);
	}

	public static int getNodeCount(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}

		return 1 + getNodeCount(root.left) + getNodeCount(root.right);
	}

	public static boolean isHeap(TreeNode tree)
	{
        int nodeCount = getNodeCount(tree);
        return isComplete(tree, 0, nodeCount) && hasMaxHeapProperty(tree);
    }
}




/*
	Time complexity: O(n) [Since each node is visited constant number of times]
	Space complexity: O(log n) best case [balanced tree]
					  O(n) worst case [skewed tree]
*/
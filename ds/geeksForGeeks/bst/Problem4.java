/*
	Insert a node in a BST

	Given a BST(Binary Search Tree) and a key key. If the key is not present in the BST, Insert a new node with a value equal to the key into the BST. If the key is already present in the BST, don't modify the BST. Return the root of the modified BST after inserting the key. 

		2
	   /  \
	  1    3
	  Key: 4

	  Output:
	  2
	 / \
	1   3
	      \
	        4



      2
	 / \
	1   3
	      \
	        6

    Key: 4
	Output:
      2
	 / \
	1   3
	      \
	        6
	       / 
	      4




      2
	 / \
	1   3

	Key: 2

	Output:

      2
	 / \
	1   3
*/

package ds.geeksForGeeks.bst;

import utils.BinaryTreeUtils;
import utils.TreeNode;

public class Problem4
{
	public static void main(String[] args)
	{
		BinaryTreeUtils.print(insert(BinaryTreeUtils.getBst(new int[]{2, 1, 3}), 4));
		BinaryTreeUtils.print(insert(BinaryTreeUtils.getBst(new int[]{2, 1, 3, 6}), 4));
		BinaryTreeUtils.print(insert(BinaryTreeUtils.getBst(new int[]{2, 1, 3}), 2));
	}

	public static TreeNode insert(TreeNode root, int key)
	{
		if (null == root)
		{
			return new TreeNode(key);
		}

		if(root.data == key)
		{
			return root;
		}

		if(key < root.data)
		{
			root.left = insert(root.left, key);
		}
		else
		{
			root.right = insert(root.right, key);
		}

		return root;
	}
}
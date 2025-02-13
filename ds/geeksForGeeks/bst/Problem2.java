/*
	Check for BST

	Given the root of a binary tree. Check whether it is a BST or not.
	Note: We are considering that BSTs can not contain duplicate Nodes.
	A BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.



			2
		   / \
		  1   3
		       \
				5

		Output: true


		2
		 \
		  7
           \
            6
             \
              9

        Output: false

        10
        / \
       5   20
   		  /  \
   		 9    25

	   Output: false

*/

package ds.geeksForGeeks.bst;
import utils.TreeNode;
import utils.BinaryTreeUtils;

public class Problem2
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);

		BinaryTreeUtils.print(root);
		System.out.println(isBst(root));
		System.out.println();

		root = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(9);

		BinaryTreeUtils.print(root);
		System.out.println(isBst(root));
		System.out.println();

		root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(25);

		BinaryTreeUtils.print(root);
		System.out.println(isBst(root));
		System.out.println();
	}

	public static boolean isBst(TreeNode root)
	{
		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBst(TreeNode root, int min, int max)
	{
		if(root == null)
		{
			return true;
		}

		if(root.data < min || root.data > max)
		{
			return false;
		}

		return isBst(root.left, min, root.data - 1) && isBst(root.right, root.data + 1, max);
	}
}

/*
	Time complexity: O(n) [all nodes are traversed in worst case]
	Space complexity: O(h) [stack used for recursion]
*/


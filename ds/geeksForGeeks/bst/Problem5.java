/*
	Lowest Common Ancestor in a BST

	Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2). You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.

	LCA between two nodes n1 and n2 is defined as the lowest node that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).



				5
			   /  \
			  4    6
			 /      \
			3        7
			          \
			           8

           n1: 7 n2:8
           Output: 7


               20
              /   \
             8    22
            /  \ 
           4   12
              /  \
             10   14

         	n1: 8 n2: 14
         	Output: 8




         	2
           /  \
          1    3

          n1: 1 n2: 3
          Output: 2

*/

package ds.geeksForGeeks.bst;

import utils.BinaryTreeUtils;
import utils.TreeNode;

public class Problem5
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);

		System.out.println(lca(root, root.right.right, root.right.right.right).data);

		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		System.out.println(lca(root, root.left, root.left.right.right).data);

		root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		System.out.println(lca(root, root.left, root.right).data);
	}

	public static TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2)
	{
		if(root == null)
		{
			return null;
		}

		if (root.data < n1.data && root.data < n2.data)
		{
			return lca(root.right, n1, n2);
		}
		
		if (root.data > n1.data && root.data > n2.data)
		{
			return lca(root.left, n1, n2);
		}

		return root;
	}
}

/*
	Time Complexity: O(h) best/average case
					 O(n) worst case
	Space Complexity: O(h) best/average case
					  O(n) worst case
*/
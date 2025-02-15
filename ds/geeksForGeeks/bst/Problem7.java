/*
	Binary Tree to BST

	Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.


			1
		  /   \
		 2     3

		 Output:
			2
		  /   \
		 1     3



		     1
		   /   \
		  2     3
		 /
		4

		Output:
			 3
		   /   \
		  2     4
		 /
		1
*/

package ds.geeksForGeeks.bst;

import utils.BinaryTreeUtils;
import utils.TreeNode;
import java.util.*;

public class Problem7
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		BinaryTreeUtils.print(root);
		binaryTreeToBST(root);
		BinaryTreeUtils.print(root);

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		BinaryTreeUtils.print(root);
		binaryTreeToBST(root);
		BinaryTreeUtils.print(root);
	}



	public static TreeNode binaryTreeToBST(TreeNode root)
    {
       List<Integer> inOrderList = BinaryTreeUtils.morrisTraversal(root);
       Collections.sort(inOrderList);
       inOrder(root, inOrderList);

       return root;
    }

    public static void inOrder(TreeNode root, List<Integer> inOrderList)
    {
    	TreeNode curr = root;
    	int index = 0;

    	while(curr != null)
    	{
    		if(curr.left == null)
    		{
    			curr.data = inOrderList.get(index++);
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
    				curr.data = inOrderList.get(index++);
    				curr = curr.right;
    			}
    		}
    	}
    }
}

/*
	Time complexity: O(nlog n)
	Space complexity: O(n)
*/
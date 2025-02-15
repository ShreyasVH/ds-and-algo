/*
	BST Keys in a Range

	Given a Binary Search Tree and a range [low, high]. Find all the numbers in the BST that lie in the given range.
	Note: Element greater than or equal to root go to the right side.

			17
		   /  \
		  4    18
		 / \
		2   9
		l: 4 h: 24

		Output: 4 9 17 18

			16
		   /  \
		  7    20
		 / \
		1   10
		l: 13 h: 23

		Output: 16 20
*/

package ds.geeksForGeeks.bst;

import java.util.ArrayList;
import utils.TreeNode;
import utils.BinaryTreeUtils;

public class Problem6a
{
	public static void main(String[] args)
	{
		TreeNode root = BinaryTreeUtils.getBst(new int[]{17, 4, 18, 2, 9});
		BinaryTreeUtils.print(root);
		System.out.println(printNearNodes(root, 4, 24));
		System.out.println("------------------------------");

		root = BinaryTreeUtils.getBst(new int[]{16, 7, 20, 1, 10});
		BinaryTreeUtils.print(root);
		System.out.println(printNearNodes(root, 13, 23));
		System.out.println();
	}

	public static ArrayList<Integer> printNearNodes(TreeNode root, int low, int high)
	{
		TreeNode curr = root;
		ArrayList<Integer> result = new ArrayList<>();

		while(curr != null)
		{
			if(curr.left == null)
			{
				if(curr.data >= low && curr.data <= high)
				{
					result.add(curr.data);
				}
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
					if(curr.data >= low && curr.data <= high)
					{
						result.add(curr.data);
					}
					curr = curr.right;
				}
			}
		}

		return result;
	}
}

/*
	Time Complexity: O(n) [worst case]
					 O(log n + k) [balanced tree]
	Space Complexity: O(n) [worst case]
					 O(log n + k) [balanced tree]
*/

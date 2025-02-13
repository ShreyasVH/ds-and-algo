/*
	Pair Sum in BST

	Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

	
			7	
		   / \
		  3   8
		 / \   \
		2   4   9

		target: 12
		Output: true


			9	
		   / \
		  5   10
		 / \   \
		2   6   12

		target: 23
		Output: false

*/

package ds.geeksForGeeks.problemOfTheDay.d20250213;

import utils.BinaryTreeUtils;
import utils.TreeNode;
import java.util.List;
import java.util.ArrayList;


public class Problem1a{
	public static void main(String[] args)
	{
		System.out.println(findTarget(BinaryTreeUtils.getBst(new int[]{7, 3, 8, 2, 4, 9}), 12));
		System.out.println("-----------------------");
		System.out.println(findTarget(BinaryTreeUtils.getBst(new int[]{9, 5, 10, 2, 6, 12}), 23));
	}

	public static boolean findTarget(TreeNode root, int target)
	{
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);

		int left = 0;
		int right = list.size() - 1;

		while(left < right)
		{
			int currentSum = list.get(left) + list.get(right);

			if(currentSum == target)
			{
				return true;
			}
			else if(currentSum < target)
			{
				left++;
			}
			else
			{
				right++;
			}
		}

		return false;
	}

	public static void inOrder(TreeNode root, List<Integer> list)
	{
		if(root != null)
		{
			inOrder(root.left, list);
			list.add(root.data);
			inOrder(root.right, list);
		}
	}
}
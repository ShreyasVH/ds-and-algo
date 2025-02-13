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
import java.util.Set;
import java.util.HashSet;


public class Problem1{
	public static void main(String[] args)
	{
		System.out.println(findTarget(BinaryTreeUtils.getBst(new int[]{7, 3, 8, 2, 4, 9}), 12));
		System.out.println("-----------------------");
		System.out.println(findTarget(BinaryTreeUtils.getBst(new int[]{9, 5, 10, 2, 6, 12}), 23));
	}

	public static boolean findTarget(TreeNode root, int target)
	{
		Set<Integer> set = new HashSet<>();

		return findTarget(root, target, set);
	}

	public static boolean findTarget(TreeNode root, int target, Set<Integer> set)
	{
		if(root == null)
		{
			return false;
		}
		int requiredNum = target - root.data;
		if(set.contains(requiredNum))
		{
			return true;
		}
		set.add(root.data);

		return findTarget(root.left, target, set) || findTarget(root.right, target, set);
	}
}
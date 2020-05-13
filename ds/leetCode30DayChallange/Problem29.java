/*
	Given a non-empty binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

	Example 1:

	Input: [1,2,3]

	       1
	      / \
	     2   3

	Output: 6
	Example 2:

	Input: [-10,9,20,null,null,15,7]

	   -10
	   / \
	  9  20
	    /  \
	   15   7

	Output: 42
*/
class Solution {
	public static class TreeNode
	{
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}

	int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        maxPathSumInternal(root);
        return this.maxSum;
    }

    public int maxPathSumInternal(TreeNode root)
    {
    	if(null == root)
        {
        	return 0;
        }
        // System.out.println("root: " + root.val);

        int leftSum = maxPathSumInternal(root.left);
        int rightSum = maxPathSumInternal(root.right);

        // System.out.println("leftSum: " + leftSum);
        // System.out.println("rightSum: " + rightSum);

        int current = Integer.max(root.val, root.val + Integer.max(leftSum, rightSum));
        maxSum = Integer.max(maxSum, Integer.max(current, root.val + leftSum + rightSum));

        return current;
    }

    public static void main(String[] args)
    {
    	// Solution s = new Solution();
    	// TreeNode first = new TreeNode(1);
    	// TreeNode second = new TreeNode(2);
    	// TreeNode third = new TreeNode(3);
    	// first.left = second;
    	// first.right = third;

    	// System.out.println(s.maxPathSum(first));

    	Solution s = new Solution();
    	TreeNode first = new TreeNode(-10);
    	TreeNode second = new TreeNode(9);
    	TreeNode third = new TreeNode(20);
    	first.left = second;
    	first.right = third;

    	TreeNode fourth = new TreeNode(15);
    	TreeNode fifth = new TreeNode(7);
    	third.left = fourth;
    	third.right = fifth;

    	System.out.println(s.maxPathSum(first));



    }
}
/*
	Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

	Example:
	Given a binary tree
	          1
	         / \
	        2   3
	       / \     
	      4   5    
	Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

	Note: The length of path between two nodes is represented by the number of edges between them.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution
{
	static class TreeNode
	{
	    int val;
 	    TreeNode left;
 	    TreeNode right;
 	    TreeNode(int x) { val = x; }
 	}

    static class Height
    {
        int val;
    }

    public int diameterOfBinaryTree(TreeNode root)
    {
        return diameterOfBinaryTreeInternal(root, new Height());
    }

    public int diameterOfBinaryTreeInternal(TreeNode root, Height h)
    {
        Height lh = new Height();
        Height rh = new Height();
        if(null == root)
        {
            h.val = 0;
        	return 0;
        }

        int leftDiameter = diameterOfBinaryTreeInternal(root.left, lh);
        int rightDiameter = diameterOfBinaryTreeInternal(root.right, rh);

        h.val = (Integer.max(lh.val, rh.val) + 1);

        return (Integer.max(Integer.max(leftDiameter, rightDiameter), (lh.val + rh.val)));
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();

    	Solution.TreeNode first = new Solution.TreeNode(1);
    	Solution.TreeNode second = new Solution.TreeNode(2);
    	Solution.TreeNode third = new Solution.TreeNode(3);

    	first.left = second;
    	first.right = third;

    	Solution.TreeNode fourth = new Solution.TreeNode(4);
    	Solution.TreeNode fifth = new Solution.TreeNode(5);

    	second.left = fourth;
    	second.right = fifth;

    	System.out.println(s.diameterOfBinaryTree(first));
    }
}

/*
    Time Complexity: O(n)
    Space Complexity: O(1)
*/

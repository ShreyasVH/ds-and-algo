/*
	Return the root node of a binary search tree that matches the given preorder traversal.

	(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

	 

	Example 1:

	Input: [8,5,1,7,10,12]
	Output: [8,5,10,1,7,null,12]

	Note: 

	1 <= preorder.length <= 100
	The values of preorder are distinct.
*/

class Solution
{
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val)
		{
			this.val = val;
		}
	}


    public TreeNode bstFromPreorder(int[] preorder)
    {
        TreeNode root = null;

        if(preorder.length > 0)
        {
        	root = new TreeNode(preorder[0]);

        	for(int i = 1; i < preorder.length; i++)
        	{
        		insert(root, preorder[i]);
        	}
        }

        return root;
    }

    public void insert(TreeNode root, int val)
    {
    	if(val < root.val)
    	{
    		if(null == root.left)
    		{
    			root.left = new TreeNode(val);
    		}
    		else
    		{
    			insert(root.left, val);
    		}
    	}
    	else
    	{
    		if(null == root.right)
    		{
    			root.right = new TreeNode(val);
    		}
    		else
    		{
    			insert(root.right, val);
    		}
    	}
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	TreeNode root = s.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    	preOrder(root);
    	System.out.println();
    }

    public static void preOrder(TreeNode root)
    {
    	if(null != root)
    	{
    		System.out.print(root.val + " ");
    		preOrder(root.left);
    		preOrder(root.right);
    	}
    }
}

/*
	Time Complexity: O(nlogn)
	Space Complexity: O(logn) - recursive stack
*/
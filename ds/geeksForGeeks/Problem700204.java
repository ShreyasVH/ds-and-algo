/*
Tree Boundary Traversal

Given a root of a Binary Tree, return its boundary traversal in the following order:

Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.

Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.

Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

Note: The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

Input: root = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700204
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 2, 3, 4, 5, 6, 7, null, null, 8, 9);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("boundaryTraversal", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, null, 2, null, 3, null, 4);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("boundaryTraversal", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> boundaryTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.data);

        addLeftBoundary(root.left, result);

        addLeaves(root.left, result);
        addLeaves(root.right, result);

        addRightBoundary(root.right, result);

        return result;
    }

    public boolean isLeaf(TreeNode root)
    {
        return root != null && root.left == null && root.right == null;
    }

    public void addLeftBoundary(TreeNode root, ArrayList<Integer> result)
    {
        if (root == null || isLeaf(root)) {
            return;
        }

        result.add(root.data);
        if(root.left != null) {
            addLeftBoundary(root.left, result);
        } else if (root.right != null) {
            addLeftBoundary(root.right, result);
        }
    }

    public void addLeaves(TreeNode root, ArrayList<Integer> result)
    {
        if(root == null)
        {
            return;
        }

        if(isLeaf(root))
        {
            result.add(root.data);
            return;
        }

        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }

    public void addRightBoundary(TreeNode root, ArrayList<Integer> result)
    {
        if (root == null || isLeaf(root)) {
            return;
        }

        if(root.right != null) {
            addRightBoundary(root.right, result);
        } else if (root.left != null) {
            addRightBoundary(root.left, result);
        }
        result.add(root.data);
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [skewed]
                O(log n) [balanced]
*/
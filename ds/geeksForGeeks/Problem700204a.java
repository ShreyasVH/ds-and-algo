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

public class Problem700204a
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

        addLeaves(root, result);

        addRightBoundary(root.right, result);

        return result;
    }

    public boolean isLeaf(TreeNode root)
    {
        return root != null && root.left == null && root.right == null;
    }

    public void addLeftBoundary(TreeNode root, ArrayList<Integer> result)
    {
        while(root != null)
        {
            if(!isLeaf(root))
            {
                result.add(root.data);
            }

            if(root.left != null)
            {
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
    }

    public void addLeaves(TreeNode root, ArrayList<Integer> result)
    {
        
        if(root == null)
        {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty())
        {
            TreeNode curr = stack.pop();

            if (isLeaf(curr)) {
                if (curr != root) {
                    result.add(curr.data);
                }
            } else {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
    }

    public void addRightBoundary(TreeNode root, ArrayList<Integer> result)
    {
        Stack<Integer> stack = new Stack<>();

        while(root != null)
        {
            if(!isLeaf(root))
            {
                stack.push(root.data);
            }

            if(root.right != null)
            {
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }

        while(!stack.isEmpty())
        {
            result.add(stack.pop());
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [skewed]
                O(log n) [balanced]
*/
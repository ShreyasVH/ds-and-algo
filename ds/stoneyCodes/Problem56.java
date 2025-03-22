/*
Balance a Binary Search Tree

Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:

Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

Example 2:

Input: root = [2,1,3]
Output: [2,1,3]
 

Constraints:

The number of nodes in the tree is in the range [1, 10^4].
1 <= Node.val <= 10^5

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem56
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, null, 2, null, 3, null, 4, null, null);
        BinaryTreeUtils.print(root);
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("balanceBST", TreeNode.class).invoke(problem, root));
        System.out.println("--------------------");

        root = BinaryTreeUtils.getTree(2, 1, 3);
        BinaryTreeUtils.print(root);
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("balanceBST", TreeNode.class).invoke(problem, root));
	}

	public void inOrderTraversal(TreeNode root, List<Integer> inOrder)
    {
        if(root != null)
        {
            inOrderTraversal(root.left, inOrder);
            inOrder.add(root.data);
            inOrderTraversal(root.right, inOrder);
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        Collections.sort(inOrder);
        
        return build(inOrder, 0, inOrder.size() - 1);
    }

    public TreeNode build(List<Integer> inOrder, int left, int right)
    {
        if(left > right)
        {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inOrder.get(mid));

        root.left = build(inOrder, left, mid - 1);
        root.right = build(inOrder, mid + 1, right);

        return root;
    }
}


/*
Time complexity: 
Space complexity: 
*/
/*
Inorder Traversal

Given a root of a Binary Tree, your task is to return its Inorder Traversal.

Note: An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

Examples:

Input: root = [1, 2, 3, 4, 5]
            
Output: [4, 2, 5, 1, 3]
Explanation: The inorder traversal of the given binary tree is [4, 2, 5, 1, 3].
Input: root = [8, 1, 5, N, 7, 10, 6, N, 10, 6]
              
Output: [1, 7, 10, 8, 6, 10, 5, 6]
Explanation: The inorder traversal of the given binary tree is [1, 7, 10, 8, 6, 10, 5, 6].
Constraints:
1 ≤ number of nodes ≤ 3*10^4
0 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700135
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println((ArrayList<Integer>) clazz.getMethod("inOrder", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(10);
        root.right.left.left = new TreeNode(6);
        System.out.println((ArrayList<Integer>) clazz.getMethod("inOrder", TreeNode.class).invoke(problem, root));
	}

	public ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(root, result);

        return result;
    }

    public void inOrder(TreeNode root, ArrayList<Integer> result) {
        if(null != root)
        {
            inOrder(root.left, result);
            result.add(root.data);
            inOrder(root.right, result);
        }
    }
}


/*
Time complexity: 
Space complexity: 
*/
/*
Check for BST

Given the root of a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.
A BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Examples:

Input: root = [2, 1, 3, N, N, N, 5]
        2
       / \
      1   3
            \
             5

Output: true 
Explanation: The left subtree of every node contains smaller keys and right subtree of every node contains greater keys. Hence, the tree is a BST.

Input: root = [2, N, 7, N, 6, N, 9] 
            2
              \
               7
                \
                 6
                  \
                   9


Output: false 
Explanation: Since the node to the right of node with key 7 has lesser key value, hence it is not a valid BST.

Input: root = [10, 5, 20, N, N, 9, 25]
                10
               /  \
              5    20
                   / \
                  9   25

Output: false
Explanation: The node with key 9 present in the right subtree has lesser key value than root node.
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700149
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(2, 1, 3, null, null, null, 5);
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("isBST", TreeNode.class).invoke(problem, root));
        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(2, null, 7, null, 6, null, 9);
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("isBST", TreeNode.class).invoke(problem, root));
        System.out.println("---------------------------");

        root = BinaryTreeUtils.getTree(10, 5, 20, null, null, 9, 25);
        BinaryTreeUtils.print(root);
        System.out.println((boolean) clazz.getMethod("isBST", TreeNode.class).invoke(problem, root));
	}

	public boolean isBST(TreeNode root) {
        if(root == null)
        {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int prev = list.get(0);
        for(int i = 1; i < list.size(); i++)
        {
            int curr = list.get(i);
            if(curr < prev)
            {
                return false;
            }
            prev = curr;
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> list)
    {
        if(root != null)
        {
            inOrder(root.left, list);
            list.add(root.data);
            inOrder(root.right, list);
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
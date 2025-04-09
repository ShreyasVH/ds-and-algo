/*
Insert a node in a BST

Given a BST(Binary Search Tree) and a key key. If the key is not present in the BST, Insert a new node with a value equal to the key into the BST. If the key is already present in the BST, don't modify the BST. Return the root of the modified BST after inserting the key. 

Note: The generated output contains the in-order traversal of the modified tree.

Examples :

Input: key = 4
     2
   /   \   
  1     3
Output: 1 2 3 4
Explanation: After inserting the node 4 Inorder traversal will be 1 2 3 4.

Input: key = 4
        2
      /   \
     1     3
             \
              6
Output: 1 2 3 4 6
Explanation: After inserting the node 4 Inorder traversal of the above tree will be 1 2 3 4 6.
Input: key = 2
     2
   /   \   
  1     3
Output: 1 2 3 

Explanation: Node with key=2 already present in BST, Inorder traversal will be 1 2 3.
Constraints:
1 <= number of nodes <= 10^5
1 <= node->data <= 10^9
1 <= key <= 10^9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700216
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(2, 1, 3);
        BinaryTreeUtils.print(root);
        int key = 4;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("insert", TreeNode.class, int.class).invoke(problem, root, key));
        System.out.println("---------------------");

        root = BinaryTreeUtils.getTree(2, 1, 3, null, null, null, 6);
        BinaryTreeUtils.print(root);
        key = 4;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("insert", TreeNode.class, int.class).invoke(problem, root, key));
        System.out.println("---------------------");

        root = BinaryTreeUtils.getTree(2, 1, 3);
        BinaryTreeUtils.print(root);
        key = 2;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("insert", TreeNode.class, int.class).invoke(problem, root, key));
	}

	public TreeNode insert(TreeNode root, int Key) {
        if(root == null)
        {
            return new TreeNode(Key);
        }

        if(Key == root.data)
        {
            return root;
        }
        else if(Key < root.data)
        {
            root.left = insert(root.left, Key);
        }
        else
        {
            root.right = insert(root.right, Key);
        }

        return root;
    }
}


/*
Time complexity: 
Space complexity: 
*/
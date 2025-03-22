/*
Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 10^4].
-10^5 <= Node.val <= 10^5
Each node has a unique value.
root is a valid binary search tree.
-10^5 <= key <= 10^5


*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem57
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(5, 3, 6, 2, 4, null, 7);
        BinaryTreeUtils.print(root);
        int key = 3;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("deleteNode", TreeNode.class, int.class).invoke(problem, root, key));
        System.out.println("-----------------");

        root = BinaryTreeUtils.getTree(5, 3, 6, 2, 4, null, 7);
        BinaryTreeUtils.print(root);
        key = 0;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("deleteNode", TreeNode.class, int.class).invoke(problem, root, key));
        System.out.println("-----------------");

        root = null;
        BinaryTreeUtils.print(root);
        key = 0;
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("deleteNode", TreeNode.class, int.class).invoke(problem, root, key));
	}

    public int minValue(TreeNode root)
    {
        int minVal = root.data;
        while(root.left != null)
        {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
        {
            return null;
        }

        if(key < root.data)
        {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.data)
        {
            root.right = deleteNode(root.right, key);
        }
        else 
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if (root.right == null)
            {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
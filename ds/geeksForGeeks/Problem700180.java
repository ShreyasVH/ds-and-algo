/*
Construct Binary Tree from Parent Array

Given an array parent that is used to represent a tree. The array indices (0-based indexing) are the values of the tree nodes and parent[i] denotes the parent node of a particular node. The parent of the root node would always be -1, as there is no parent for the root. Construct the standard linked representation of Binary Tree from this array representation and return the root node of the constructed tree.

Note: If two elements have the same parent, the one that appears first in the array will be the left child and the other is the right child. You don't need to print anything, the driver code will print the level order traversal of the returned root node to verify the output.

Examples:

Input: parent[] = [-1, 0, 0, 1, 1, 3,5]
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like 
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6

Input: parent[] = [2, 0, -1]
Output: 2 0 1
Explanation: the tree generated will
have a structure like
             2
            /   
           0      
          /   
         1     
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ parent.size() ≤ 10^3



*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700180
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] parent = {-1, 0, 0, 1, 1, 3, 5};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("createTree", int[].class).invoke(problem, parent));

        System.out.println("-------------------------");

        parent = new int[]{2, 0, -1};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("createTree", int[].class).invoke(problem, parent));
	}

	public TreeNode createTree(int parent[]) {
        TreeNode root = null;

        TreeNode[] nodes = new TreeNode[parent.length];
        for(int i = 0; i < parent.length; i++)
        {
            nodes[i] = new TreeNode(i);
        }

        for(int i = 0; i < parent.length; i++)
        {
            TreeNode node = nodes[i];
            if(parent[i] == -1)
            {
                root = node;
            }
            else
            {
                TreeNode parentNode = nodes[parent[i]];
                if(parentNode.left == null)
                {
                    parentNode.left = node;
                }
                else if(parentNode.right == null)
                {
                    parentNode.right = node;
                }
            }
        }


        return root;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
/*
Binary Tree from Inorder and Postorder

Given inorder and postorder traversals of a binary tree(having n nodes) in the arrays inorder[] and postorder[] respectively. The task is to construct a unique binary tree from these traversals and return its root.
Driver code will print the preorder traversal of the constructed tree.

Note: The inorder and postorder traversals contain unique values, and every value present in the postorder traversal is also found in the inorder traversal.

Examples:

Input: inorder[] = [4, 8, 2, 5, 1, 6, 3, 7], postorder[] = [8, 4, 5, 2, 6, 7, 3, 1]
Output: [1, 2, 4, 8, 5, 3, 6, 7]
Explanation: For the given postorder and inorder traversal of tree the resultant binary tree will be
          1
       /      \
     2        3
   /  \      /  \
  4   5     6    7
   \
    8

Input: inorder[] = [9, 5, 2, 3, 4], postorder[] = [5, 9, 3, 4, 2]
Output: [2, 9, 5, 4, 3]
Explanation: The resultant binary tree will be
           2
        /     \
       9      4
        \     /
         5   3
Constraints:
1 <= number of nodes <= 10^3
1 <= in[i], post[i] <= 10^6


*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700157
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("buildTree", int[].class, int[].class).invoke(problem, inorder, postorder));
        System.out.println("---------------------------------------");

        inorder = new int[]{9, 5, 2, 3, 4};
        postorder = new int[]{5, 9, 3, 4, 2};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("buildTree", int[].class, int[].class).invoke(problem, inorder, postorder));
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, new int[]{postorder.length - 1}, 0, inorder.length - 1, inOrderMap);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int[] postOrderIndex, int inOrderLeft, int inOrderRight, Map<Integer, Integer> inOrderMap) {
        if(inOrderLeft > inOrderRight)
        {
            return null;
        }

        int rootVal = postorder[postOrderIndex[0]];
        TreeNode root = new TreeNode(rootVal);
        postOrderIndex[0]--;

        int inOrderIndex = inOrderMap.get(rootVal);

        root.right = buildTree(inorder, postorder, postOrderIndex, inOrderIndex + 1, inOrderRight, inOrderMap);
        root.left = buildTree(inorder, postorder, postOrderIndex, inOrderLeft, inOrderIndex - 1, inOrderMap);

        return root;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
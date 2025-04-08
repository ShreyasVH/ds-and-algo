/*
Construct Tree from Inorder & Preorder

Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

Note: The output is written in postorder traversal.

Examples:

Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
Output: [8, 7, 6, 1]
Explanation: The tree will look like
            1
             \
              6
               \
                7
               /
              8

Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [3, 4, 1, 5, 2, 0]
Explanation: The tree will look like

            0
          /   \
        1      2
       /  \     \
      3    4     5

Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
Output: [2, 5, 4, 3, 1]
Explanation: The tree will look like
            1
           / \
          4   3
         /
        5
      /
    2

Constraints:
1 ≤ number of nodes ≤ 10^3
0 ≤ nodes -> data ≤ 10^3
Both the inorder and preorder arrays contain unique values.

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700586
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] inorder = {1, 6, 8, 7};
        int[] preorder = {1, 6, 7, 8};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("buildTree", int[].class, int[].class).invoke(problem, inorder, preorder));

        System.out.println("-------------------------------");

        inorder = new int[]{3, 1, 4, 0, 2, 5};
        preorder = new int[]{0, 1, 3, 4, 2, 5};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("buildTree", int[].class, int[].class).invoke(problem, inorder, preorder));

        System.out.println("-------------------------------");

        inorder = new int[]{2, 5, 4, 1, 3};
        preorder = new int[]{1, 4, 5, 2, 3};
        BinaryTreeUtils.print((TreeNode) clazz.getMethod("buildTree", int[].class, int[].class).invoke(problem, inorder, preorder));
	}

	public TreeNode buildTree(int inorder[], int preorder[]) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(inorder, preorder, new int[]{0}, 0, inorder.length - 1, inOrderMap);
    }

    public TreeNode buildTree(int inorder[], int preorder[], int[] preOrderIndex, int inOrderLeft, int inOrderRight, Map<Integer, Integer> inOrderMap) {
        if(inOrderLeft > inOrderRight)
        {
            return null;
        }

        int rootVal = preorder[preOrderIndex[0]];
        TreeNode root = new TreeNode(rootVal);
        preOrderIndex[0]++;

        int inOrderIndex = inOrderMap.get(rootVal);

        root.left = buildTree(inorder, preorder, preOrderIndex, inOrderLeft, inOrderIndex - 1, inOrderMap);
        root.right = buildTree(inorder, preorder, preOrderIndex, inOrderIndex + 1, inOrderRight, inOrderMap);

        return root;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
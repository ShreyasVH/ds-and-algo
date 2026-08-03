/*
Postorder from Inorder and Preorder

Given the preorder and inorder traversals of a binary tree, return its postorder traversal.

You are required to complete the function getPostorder() that returns the nodes of the tree in postorder sequence.

Note: All node values are distinct.

Examples:

Input: inorder[] = [4, 2, 5, 1, 3, 6], preorder[] = [1, 2, 4, 5, 3, 6]         
Output: [4, 5, 2, 6, 3, 1]
Explanation: The given traversals correspond to the below binary tree

Postorder of the tree is [4, 5, 2, 6, 3, 1].

Input: inorder[] = [2, 1, 4, 3, 5], preorder[] = [1, 2, 3, 4, 5]        
Output: [2, 4, 5, 3, 1]
Explanation: The given traversals correspond to the below binary tree
 
Postorder of the tree is [2, 4, 5, 3, 1].
Constraints:
1 ≤ n ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700233a
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] inorder = {4, 2, 5, 1, 3, 6};
        int[] preorder = {1, 2, 4, 5, 3, 6};
        ArrayUtils.print((int[]) clazz.getMethod("getPostorder", int[].class, int[].class).invoke(problem, inorder, preorder));

        System.out.println("-------------------------------------------------------");

        inorder = new int[]{2, 1, 4, 3, 5};
        preorder = new int[]{1, 2, 3, 4, 5};
        ArrayUtils.print((int[]) clazz.getMethod("getPostorder", int[].class, int[].class).invoke(problem, inorder, preorder));
	}

	public int[] getPostorder(int[] inorder, int[] preorder) {
        int[] postorder = new int[inorder.length];

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            inOrderMap.put(inorder[i], i);
        }

        buildPostOrder(inorder, preorder, 0, inorder.length - 1, new int[]{0}, postorder, new int[]{0}, inOrderMap);

        return postorder;
    }

    public void buildPostOrder(int[] inorder, int[] preorder, int inStart, int inEnd, int[] preIndex, int[] postorder, int[] postIndex, Map<Integer, Integer> inOrderMap) {
        if (inStart > inEnd) {
            return;
        }

        int root = preorder[preIndex[0]];
        preIndex[0]++;

        int rootIndex = inOrderMap.get(root);

        buildPostOrder(inorder, preorder, inStart, rootIndex - 1, preIndex, postorder, postIndex, inOrderMap);
        buildPostOrder(inorder, preorder, rootIndex + 1, inEnd, preIndex, postorder, postIndex, inOrderMap);
        
        postorder[postIndex[0]] = root;
        postIndex[0]++;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
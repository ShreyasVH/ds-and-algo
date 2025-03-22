/*
Two Sum IV - Input is a BST

Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-10^4 <= Node.val <= 10^4
root is guaranteed to be a valid binary search tree.
-10^5 <= k <= 10^5

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem53a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(5, 3, 6, 2, 4, null, 7);
        BinaryTreeUtils.print(root);
        int k = 9;
        System.out.println((boolean) clazz.getMethod("findTarget", TreeNode.class, int.class).invoke(problem, root, k));
        System.out.println("----------------------");

        root = BinaryTreeUtils.getTree(5, 3, 6, 2, 4, null, 7);
        BinaryTreeUtils.print(root);
        k = 28;
        System.out.println((boolean) clazz.getMethod("findTarget", TreeNode.class, int.class).invoke(problem, root, k));
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

	public boolean findTarget(TreeNode root, int k) {
        if(root == null)
        {
            return false;
        }

        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);

        int left = 0;
        int right = inOrder.size() - 1;

        while(left < right)
        {
            int sum = inOrder.get(left) + inOrder.get(right);
            if(sum == k)
            {
                return true;
            }
            else if (sum > k)
            {
                right--;
            }
            else
            {
                left++;
            }
        }

        return false;
    }

    
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
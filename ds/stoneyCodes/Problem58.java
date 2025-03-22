/*
Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem58
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(3, 1, 4, null, 2);
        BinaryTreeUtils.print(root);
        int k = 1;
        System.out.println((int) clazz.getMethod("kthSmallest", TreeNode.class, int.class).invoke(problem, root, k));
        System.out.println("---------------------");

        root = BinaryTreeUtils.getTree(5, 3, 6, 2, 4, null, null, 1);
        BinaryTreeUtils.print(root);
        k = 3;
        System.out.println((int) clazz.getMethod("kthSmallest", TreeNode.class, int.class).invoke(problem, root, k));
	}

	public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int index = 0;
        while(current != null)
        {
            if(current.left == null)
            {
                index++;
                if(index == k)
                {
                    return current.data;
                }

                current = current.right;
            }
            else
            {
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current)
                {
                    prev = prev.right;
                }

                if(prev.right == null)
                {
                    prev.right = current;
                    current = current.left;
                }
                else
                {
                    prev.right = null;

                    index++;
                    if(index == k)
                    {
                        return current.data;
                    }

                    current = current.right;
                }
            }
        }

        return -1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
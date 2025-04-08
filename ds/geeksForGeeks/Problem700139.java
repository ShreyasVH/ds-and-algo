/*
Count BST nodes that lie in a given range

Given a Binary Search Tree (BST) and a range l-h (inclusive), your task is to return the number of nodes in the BST whose value lie in the given range.

Examples :

Input: root[] = [10, 5, 50, 1, N, 40, 100], l = 5, h = 45
         
Output: 3
Explanation: There are three nodes in range [5, 45] =  5, 10 and 40.
        10
       /   \
      5     50
     /     /   \
    1     40    100
    

Input: root[] = [10, 5, 50, 1, N, 40, 100], l = 10, h = 100
         10
       /   \
      5     50
     /     /   \
    1     40    100
         
Output: 4
Explanation: There are four nodes in range [10, 100] = 10, 40, 50 and 100.

Input: root[] = [1, 2, 3], l = 23, h = 95
     1
    / \
   2   3         
Output: 0
Explanation: There are no nodes in range [23, 95].

Constraints:
1 <= Number of nodes <= 10^5
1 <= l <= h < =10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700139
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(10, 5, 50, 1, null, 40, 100);
        BinaryTreeUtils.print(root);
        int l = 5;
        int r = 45;
        System.out.println((int) clazz.getMethod("getCount", TreeNode.class, int.class, int.class).invoke(problem, root, l, r));

        System.out.println("-------------------------------------");

        root = BinaryTreeUtils.getTree(10, 5, 50, 1, null, 40, 100);
        BinaryTreeUtils.print(root);
        l = 10;
        r = 100;
        System.out.println((int) clazz.getMethod("getCount", TreeNode.class, int.class, int.class).invoke(problem, root, l, r));

        System.out.println("-------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3);
        BinaryTreeUtils.print(root);
        l = 23;
        r = 95;
        System.out.println((int) clazz.getMethod("getCount", TreeNode.class, int.class, int.class).invoke(problem, root, l, r));

        System.out.println("-------------------------------------");
	}

	public int getCount(TreeNode root, int l, int h) {
        if(root == null)
        {
            return 0;
        }

        if(root.data < l)
        {
            return getCount(root.right, l, h);
        }
        else if(root.data > h)
        {
            return getCount(root.left, l, h);
        }

        return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
    }
}


/*
Time complexity: O(log N) [balanced tree]
                 O(N) [skewed tree]
Space complexity: O(log N) [balanced tree]
                  O(N) [skewed tree]
*/
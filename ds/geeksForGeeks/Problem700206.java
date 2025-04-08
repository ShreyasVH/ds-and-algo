/*
Reverse alternate levels of a perfect binary tree

Given a complete binary tree, reverse the nodes present at alternate levels.

Examples:

Input: root = [1, 3, 2]
             1
           /   \
          3     2
Output:
             1
           /   \
          2     3

Explanation: Nodes at level 2 are reversed.

Input: root = [1, 2, 3, 42, 51, 63, 72
              1
           /     \
         2        3
       /  \      /  \
     42   51   63   72
Output:
              1
           /     \
         3        2
       /  \      /  \
     42   51   63   72

Explanation: Nodes at level 2 are reversed. Level 1 and 3 remain as it is.

Input: root = [1, 3, 4]
             1
           /   \
          3     4
Output:
             1
           /   \
          4     3

Explanation: Nodes at level 2 are reversed.
Note: If you click on Compile and Test the output will be the in-order traversal of the modified tree.

Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ nodes->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700206
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(1, 3, 2);
        BinaryTreeUtils.print(root);
        clazz.getMethod("reverseAlternate", TreeNode.class).invoke(problem, root);
        BinaryTreeUtils.print(root);

        System.out.println("-----------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, 42, 51, 63, 72);
        BinaryTreeUtils.print(root);
        clazz.getMethod("reverseAlternate", TreeNode.class).invoke(problem, root);
        BinaryTreeUtils.print(root);

        System.out.println("-----------------------------");

        root = BinaryTreeUtils.getTree(1, 3, 4);
        BinaryTreeUtils.print(root);
        clazz.getMethod("reverseAlternate", TreeNode.class).invoke(problem, root);
        BinaryTreeUtils.print(root);
	}

	public void reverseAlternate(TreeNode root) {
        if(root != null)
        {
            reverseAlternate(root.left, root.right, 1);
        }
    }

    public void reverseAlternate(TreeNode left, TreeNode right, int level) {
        if(left != null && right != null)
        {
            if(level % 2 == 1)
            {
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
            }

            reverseAlternate(left.left, right.right, level + 1);
            reverseAlternate(left.right, right.left, level + 1);
        }
    }
}


/*
Time complexity: 
Space complexity: 
*/
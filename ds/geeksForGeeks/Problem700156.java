/*
Two Mirror Trees

Given a Two Binary Trees, write a function that returns true if one is mirror of other, else returns false.
MirrorTree1            

Examples:

Input:
a:      1     b:      1
      /   \         /   \
     2     3       3     2
Output: true
Explanation: Given pairs of binary tree are mirror of each other.

Input:
a:      10      b:    10
       /  \          /  \
      20  30        20  30
     /  \          /  \
    40   60       40  60
Output: false
Explanation: Given pairs of binary tree are not mirror of each other.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(h).

Constraints:
1 <= number of nodes<= 10^5
0 <= node -> data<= 10^5 

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700156
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode a = BinaryTreeUtils.getTree(1, 2, 3);
        TreeNode b = BinaryTreeUtils.getTree(1, 3, 2);
        BinaryTreeUtils.print(a);
        BinaryTreeUtils.print(b);
        System.out.println((boolean) clazz.getMethod("areMirror", TreeNode.class, TreeNode.class).invoke(problem, a, b));

        System.out.println("-------------------------------------------------------");

        a = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        b = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        BinaryTreeUtils.print(a);
        BinaryTreeUtils.print(b);
        System.out.println((boolean) clazz.getMethod("areMirror", TreeNode.class, TreeNode.class).invoke(problem, a, b));
	}

	public boolean areMirror(TreeNode a, TreeNode b) {
        mirror(b);
        return areEqual(a, b);
    }

    public void mirror(TreeNode root)
    {
        if(root != null)
        {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = right;
            root.right = left;

            mirror(left);
            mirror(right);
        }
    }

    public boolean areEqual(TreeNode a, TreeNode b)
    {
        if(a == null && b == null)
        {
            return true;
        }
        else if(a != null && b != null)
        {
            if(a.data != b.data)
            {
                return false;
            }

            boolean left = areEqual(a.left, b.left);
            if(!left)
            {
                return false;
            }

            return areEqual(a.right, b.right);
        }
        else
        {
            return false;
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(h)
*/
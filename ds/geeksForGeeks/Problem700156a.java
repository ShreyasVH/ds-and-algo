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

public class Problem700156a
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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();

            TreeNode left = curr.left;
            TreeNode right = curr.right;

            curr.left = right;
            curr.right = left;

            if(left != null)
            {
                q.offer(left);
            }
            if(right != null)
            {
                q.offer(right);
            }
        }
    }

    public boolean areEqual(TreeNode a, TreeNode b)
    {
        Queue<TreeNode> qa = new LinkedList<>();
        qa.offer(a);
        Queue<TreeNode> qb = new LinkedList<>();
        qb.offer(b);

        while(!qa.isEmpty() && !qb.isEmpty())
        {
            TreeNode currA = qa.poll();
            TreeNode currB = qb.poll();

            if(currA.data != currB.data)
            {
                return false;
            }

            if(currA.left != null)
            {
                qa.offer(currA.left);
            }

            if(currA.right != null)
            {
                qa.offer(currA.right);
            }

            if(currB.left != null)
            {
                qb.offer(currB.left);
            }

            if(currB.right != null)
            {
                qb.offer(currB.right);
            }
        }

        return qa.isEmpty() && qb.isEmpty();
    }
}


/*
Time complexity: O(n)
Space complexity: O(w)
*/
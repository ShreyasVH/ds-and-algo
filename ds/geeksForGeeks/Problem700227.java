/*
Maximum difference between node and its ancestor


Given a root  binary tree, you need to find the maximum value which you can get by subtracting the value of node B from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 

Examples :

Input: root = [5, 2, 1] 

Output: 4
Explanation:The maximum difference we can get is 4, which is bewteen 5 and 1.
Input: root = [1, 2, 3, N, N, N, 7] 

Output: -1
Explanation:The maximum difference we can get is -1, which is between 1 and 2.
Constraints:
2 <= Number of edges <= 10^4
0 <= Data of a node <= 10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700227
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(5, 2, 1);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxDiff", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, null, null, null, 7);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxDiff", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(19, 28, null, null);
        BinaryTreeUtils.print(root);
        System.out.println((int) clazz.getMethod("maxDiff", TreeNode.class).invoke(problem, root));
	}

	public int maxDiff(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxDiff(root, max);

        return max[0];
    }

    public void maxDiff(TreeNode root, int[] max) {
        if (root != null) {
            int[] small = new int[]{Integer.MAX_VALUE};
            smallest(root.left, small);
            smallest(root.right, small);
            System.out.println(root.data + " -> " + small[0]);

            if (small[0] != Integer.MAX_VALUE) {
                int diff = root.data - small[0];
                max[0] = Math.max(max[0], diff);
            }
            

            maxDiff(root.left, max);
            maxDiff(root.right, max);
        }
    }

    public void smallest(TreeNode root, int[] smallest) {
        if (root != null) {
            smallest[0] = Math.min(smallest[0], root.data);

            smallest(root.left, smallest);
            smallest(root.right, smallest);
        }
    }
}


/*
Time complexity: O(N log N) [balanced tree]
                O(N^2) [skewed tree]
Space complexity: O(log N) [balanced tree]
                O(N) [skewed tree]
*/
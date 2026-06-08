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

public class Problem700227a
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
        smallest(root, max);

        return max[0];
    }

    public int smallest(TreeNode root, int[] max) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftSmallest = smallest(root.left, max);
        int rightSmallest = smallest(root.right, max);

        int childSmallest = Math.min(leftSmallest, rightSmallest);

        if (childSmallest != Integer.MAX_VALUE) {
            max[0] = Math.max(max[0], root.data - childSmallest);
        }
        

        return Math.min(root.data, childSmallest);
    }
}


/*
Time complexity: O(N)
Space complexity: O(log N) [balanced tree]
                O(N) [skewed tree]
*/
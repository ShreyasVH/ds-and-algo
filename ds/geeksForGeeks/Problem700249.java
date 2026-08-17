/*
BST Keys in a Range

Given the root of a Binary Search Tree (BST) and two integers low and high, return all node values that lie in the inclusive range [low, high] in ascending order.

Examples :

Input: root = [17, 4, 18, 2, 9, N, N], l = 4, h = 17
 
Output: [4, 9, 17]
Explanation: The BST nodes whose values lie in the range [4, 17] are 4, 9, and 17. Hence the result is returned as [4, 9, 17].

Input: root = [16, 7, 20, 1, 10, N, N], l = 13, h = 23
 
Output: [16, 20]
Explanation: The nodes in the range [13, 23] are 16 and 20. Hence the result is returned as [16, 20].

Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ l ≤ h ≤ 10^6
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700249
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(17, 4, 18, 2, 9, null, null);
        BinaryTreeUtils.print(root);
        int l = 4;
        int h = 17;
        System.out.println((ArrayList<Integer>) clazz.getMethod("nodesInRange", TreeNode.class, int.class, int.class).invoke(problem, root, l, h));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(16, 7, 20, 1, 10, null, null);
        BinaryTreeUtils.print(root);
        l = 13;
        h = 23;
        System.out.println((ArrayList<Integer>) clazz.getMethod("nodesInRange", TreeNode.class, int.class, int.class).invoke(problem, root, l, h));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(49, 4, null, null, 23, null, 35);
        BinaryTreeUtils.print(root);
        l = 20;
        h = 23;
        System.out.println((ArrayList<Integer>) clazz.getMethod("nodesInRange", TreeNode.class, int.class, int.class).invoke(problem, root, l, h));
	}

	public ArrayList<Integer> nodesInRange(TreeNode root, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();

        nodesInRange(root, low, high, result);

        return result;
    }

    public void nodesInRange(TreeNode root, int low, int high, ArrayList<Integer> result) {
        if (root != null) {
            if (low < root.data && high < root.data) {
                nodesInRange(root.left, low, high, result);
            } else if (low > root.data && high > root.data) {
                nodesInRange(root.right, low, high, result);
            } else {
                nodesInRange(root.left, low, high, result);
                result.add(root.data);
                nodesInRange(root.right, low, high, result);
            }
        }
    }
}


/*
Time complexity: O(log n + k) [k - number of elements in range]
Space complexity: O(log n)
*/
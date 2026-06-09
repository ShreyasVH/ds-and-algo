/*
Nodes without a Sibling

Given the root of a Binary Tree, find all nodes that do not have a sibling. Return the nodes in increasing order.

Two nodes are considered siblings if they share the same parent.

Note:

The root node cannot have a parent, so it should not be included in the answer 
If every node has a sibling, return a list containing only -1.
Examples:

Input: root = [37, 20, N, N, 113]

Output: [20, 113]
Explanation: Nodes 20 and 113 dont have any siblings.
Input: root[] = [1, 2, 3, 4]

Output: [4]
Explanation: Node 4 does not have a sibling.
Input: root[] = [37, 40, 13]

 Output: [-1]
Explanation: Every node of the tree has a sibling.
Constraints:
1 ≤ number of nodes ≤ 10^4
1 ≤ node->data ≤ 10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700228
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(37, 20, null, null, 113);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("noSibling", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2, 3, 4);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("noSibling", TreeNode.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = BinaryTreeUtils.getTree(37, 40, 13);
        BinaryTreeUtils.print(root);
        System.out.println((List<Integer>) clazz.getMethod("noSibling", TreeNode.class).invoke(problem, root));
	}

	public List<Integer> noSibling(TreeNode root) {
        // code here
        List<Integer> result = new ArrayList<>();
        noSibling(root, result);

        if (result.isEmpty()) {
            result.add(-1);
        } else {
            Collections.sort(result);
        }

        return result;
    }

    public void noSibling(TreeNode root, List<Integer> result) {
        if (root != null && (root.left != null || root.right != null)) {
            if(root.left == null) {
                result.add(root.right.data);
            } else if(root.right == null) {
                result.add(root.left.data);
            }

            noSibling(root.left, result);
            noSibling(root.right, result);
        }
    }
}


/*
Time complexity: O(N log N) [sorting]
Space complexity: O(log N) [blanaced tree]
                    O(N) [skewed tree]
*/
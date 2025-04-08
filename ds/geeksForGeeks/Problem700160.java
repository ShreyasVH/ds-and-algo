/*
Bottom View of Binary Tree

Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree, the output should be 5 10 4 14 25.

Examples :

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.

Thus bottom view of the binary tree will be 3 1 2.

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30

Input:
        1
       /   
      2
Output: 2 1
Constraints:
1 <= number of nodes <= 105
1 <= node->data <= 105

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700160
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        TreeNode root = BinaryTreeUtils.getTree(20, 8, 22, 5, 3, 4, 25, null, null, 10, null, null, 14);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("bottomView", TreeNode.class).invoke(problem, root));
        System.out.println("-------------------------------------");

        root = BinaryTreeUtils.getTree(1, 3, 2);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("bottomView", TreeNode.class).invoke(problem, root));
        System.out.println("-------------------------------------");

        root = BinaryTreeUtils.getTree(10, 20, 30, 40, 60);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("bottomView", TreeNode.class).invoke(problem, root));
        System.out.println("-------------------------------------");

        root = BinaryTreeUtils.getTree(1, 2);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("bottomView", TreeNode.class).invoke(problem, root));
        System.out.println("-------------------------------------");

        root = BinaryTreeUtils.getTree(20, 8, 22, 5, 3, null, 25, null, null, 10, 14);
        BinaryTreeUtils.print(root);
        System.out.println((ArrayList<Integer>) clazz.getMethod("bottomView", TreeNode.class).invoke(problem, root));
	}

	public ArrayList <Integer> bottomView(TreeNode root)
    {
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0});

        Map<Integer, Integer> hdMap = new TreeMap<>();

        while(!q.isEmpty())
        {
            Object[] values = q.poll();
            TreeNode curr = (TreeNode) values[0];
            int horizontalDistance = (Integer) values[1];

            hdMap.put(horizontalDistance, curr.data);

            if(curr.left != null)
            {
                q.offer(new Object[]{curr.left, horizontalDistance - 1});
            }

            if(curr.right != null)
            {
                q.offer(new Object[]{curr.right, horizontalDistance + 1});
            }
        }

        return new ArrayList<>(hdMap.values());
    }
}


/*
Time complexity: O(n log n) [As tree map is used]
Space complexity: O(n)
*/
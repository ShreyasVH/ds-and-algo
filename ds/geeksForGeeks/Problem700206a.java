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

public class Problem700206a
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
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            int level = 0;
            while(!q.isEmpty())
            {
                int size = q.size();

                TreeNode[] levelNodes = new TreeNode[size];
                int index = 0;
                for(int i = 0; i < size; i++)
                {
                    TreeNode curr = q.poll();
                    levelNodes[index++] = curr;

                    if(curr.left != null)
                    {
                        q.offer(curr.left);
                    }

                    if(curr.right != null)
                    {
                        q.offer(curr.right);
                    }
                }

                if(level % 2 == 1)
                {
                    int mid = (levelNodes.length - 1) / 2;
                    for(int i = 0; i <= mid; i++)
                    {
                        int temp = levelNodes[i].data;
                        levelNodes[i].data = levelNodes[levelNodes.length - 1 - i].data;
                        levelNodes[levelNodes.length - 1 - i].data = temp;
                    }
                }
                level++;
            }
        }
    }
}


/*
Time complexity: 
Space complexity: 
*/
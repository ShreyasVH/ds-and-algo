/*
Connect Nodes of Levels

Given the root of a binary tree, connect all nodes at the same level using an additional nextRight pointer for each node. Initially, all nextRight pointers contain garbage values (or null). Your function should set each node’s nextRight pointer to point to its immediate neighbor on the same level. The driver code will print the level-order traversal .

Examples:

Input: root = [1, 2, 3, 4, 5, N, 6]

Output: [1, #, 2, 3, #, 4, 5, 6, #]
Explanation:The connected tree is:

Constraints:
1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

class Node{
       int data;
       Node left;
       Node right;
       Node nextRight;
       Node(int data){
           this.data = data;
           left=null;
           right=null;
           nextRight = null;
       }
   }

public class Problem700184
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        print((Node) clazz.getMethod("connect", Node.class).invoke(problem, root));
	}

	public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            Node prev = null;
            for(int i = 0; i < size; i++)
            {
                Node curr = q.poll();

                if(curr.left != null)
                {
                    q.offer(curr.left);
                }
                
                if(curr.right != null)
                {
                    q.offer(curr.right);
                }

                if(prev != null)
                {
                    prev.nextRight = curr;
                }

                prev = curr;
            }
        }

        return root;
    }

    public static void print(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                Node curr = q.poll();

                if(i == 0)
                {
                    Node head = curr;

                    Node levelCurr = head;
                    while(levelCurr != null)
                    {
                        System.out.print(levelCurr.data + " ");

                        levelCurr = levelCurr.nextRight;
                    }
                }

                if(curr.left != null)
                {
                    q.offer(curr.left);
                }
                
                if(curr.right != null)
                {
                    q.offer(curr.right);
                }
            }

            System.out.println();
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(h)
*/
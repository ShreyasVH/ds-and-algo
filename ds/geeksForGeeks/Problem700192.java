/*
Flattening a Linked List

Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom points to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data. Flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Note:
1. ↓ represents the bottom pointer and → represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.

Examples:

Input:

Output: 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 10 is pointing to 20 and so on.
So, after flattening the linked list the sorted list will be 
5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.

Input:

Output: 5 -> 7 -> 8 -> 10 -> 19 -> 22 -> 28 -> 30 -> 50
Explanation:
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 30 and so on.
So, after flattening the linked list the sorted list will be 
5 -> 7 -> 8 -> 10 -> 19 -> 22 -> 28 -> 30 -> 50.

Constraints:
0 ≤ n ≤ 100
1 ≤ number of nodes in sub-linked list(mi) ≤ 50
1 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700192
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        Node root = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.next = new Node(10);
        root.next.bottom = new Node(20);
        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.next = new Node(28);
        root.next.next.next.bottom = new Node(40);
        root.next.next.next.bottom.bottom = new Node(45);
        print((Node) clazz.getMethod("flatten", Node.class).invoke(problem, root));

        System.out.println("-------------------------------------------------------");

        root = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);
        root.next = new Node(10);
        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);
        root.next.next.next = new Node(28);
        print((Node) clazz.getMethod("flatten", Node.class).invoke(problem, root));
	}

	// public Node flatten(Node root) {
    //     Node curr = root;

    //     while(curr != null)
    //     {
    //         Node currDown = curr.bottom;
    //         // System.out.println("currDown: " + ((currDown == null) ? null : currDown.data));
    //         while(currDown != null)
    //         {
    //             Node currRight = curr.next;
    //             // System.out.println("currRight: " + ((currRight == null) ? null : currRight.data));
    //             Node prev = curr;
    //             while(currRight != null && currRight.data <= currDown.data)
    //             {
    //                 prev = currRight;
    //                 currRight = currRight.next;
    //             }
    //             Node next = prev.next;
    //             prev.next = currDown;
    //             currDown.next = next;

    //             Node nextBottom = currDown.bottom;
    //             currDown.bottom = null;
    //             currDown = nextBottom;
    //         }

    //         curr = curr.next;
    //     }

    //     return root;
    // }

    public Node flatten(Node root) {
        Node curr = root.next;

        while(curr != null)
        {
            Node currDown = curr;
            while(currDown != null)
            {
                Node fDown = root.bottom;
                Node prev = root;
                while(fDown != null && fDown.data <= currDown.data)
                {
                    prev = fDown;
                    fDown = fDown.bottom;
                }
                prev.bottom = currDown;
                Node nextDown = currDown.bottom;
                currDown.bottom = fDown;

                currDown = nextDown;
            }

            Node next = curr.next;
            curr.next = null;
            curr = next;
        }

        return root;
    }

    public static void print(Node root)
    {
        Node curr = root;
        while(curr != null)
        {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }


}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
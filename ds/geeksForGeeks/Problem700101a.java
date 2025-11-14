/*
Delete nodes having greater value on right

Given a singly linked list, remove all nodes that have a node with a greater value anywhere to their right in the list. Return the head of the modified linked list.

Examples:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15->11->6->3

Explanation: Since, 12, 10, 5 and 2 are the elements which have greater elements on the following nodes. So, after deleting them, the linked list would like be 15, 11, 6, 3.
Input:
LinkedList = 10->20->30->40->50->60
Output: 60

Explanation: All the nodes except the last node has a greater value node on its right, so all the nodes except the last node must be removed.
Constraints:
1 ≤ size of linked list ≤ 10^6
1 ≤ element of linked list ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700101a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(12, 15, 10, 11, 5, 6, 2, 3);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("compute", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(10, 20, 30, 40, 50, 60);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("compute", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 8, 4, 4, 9, 6, 6);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("compute", LinkedListNode.class).invoke(problem, head));
	}

    public LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode curr = head;
        LinkedListNode prev = null;

        while(curr != null)
        {
            LinkedListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public LinkedListNode compute(LinkedListNode head) {

        head = reverse(head);

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode curr = head;
        LinkedListNode prev = null;
        int currentHighest = -1;

        while(curr != null)
        {

            int val = Integer.parseInt(String.valueOf(curr.val));
            if(val >= currentHighest)
            {
                currentHighest = val;
                prev = curr;
            }
            else
            {
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return reverse(dummy.next);
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
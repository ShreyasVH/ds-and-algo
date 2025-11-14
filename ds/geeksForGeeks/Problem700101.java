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

public class Problem700101
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

    public boolean hasBigger(LinkedListNode head, int val)
    {
        boolean exists = false;

        LinkedListNode curr = head;
        while(curr != null)
        {
            if(Integer.parseInt(String.valueOf(curr.val)) > val)
            {
                return true;
            }

            curr = curr.next;
        }

        return exists;
    }

    public LinkedListNode compute(LinkedListNode head) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode curr = head;
        LinkedListNode prev = dummy;
        while(curr != null)
        {
            LinkedListNode next = curr.next;
            if (hasBigger(next, Integer.parseInt(String.valueOf(curr.val))))
            {
                prev.next = next;
            }
            else
            {
                prev = curr;
            }

            
            curr = next;
        }

        return dummy.next;
    }
}


/*
Time complexity: O(n^2)
Space complexity: O(1)
*/
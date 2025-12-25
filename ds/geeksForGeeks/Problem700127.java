/*
Insert in Sorted Circular Linked List

Given a sorted circular linked list, the task is to insert a new node in this circular linked list so that it remains a sorted circular linked list.

Examples:

Input: head = 1->2->4, data = 2
Output: 1->2->2->4
Explanation: We can add 2 after the second node.

Input: head = 1->4->7->9, data = 5
Output: 1->4->5->7->9
Explanation: We can add 5 after the second node.

Constraints:
2 <= number of nodes <= 10^6
0 <= node->data <= 10^6
0 <= data <= 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700127
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(4);
        head.next.next.next = head;
        int data = 2;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(4);
        head.next.next = new LinkedListNode(7);
        head.next.next.next = new LinkedListNode(9);
        head.next.next.next.next = head;
        data = 5;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(4);
        head.next = new LinkedListNode(7);
        head.next.next = new LinkedListNode(9);
        head.next.next.next = head;
        data = 1;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = head;
        data = 4;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));
	}

	public LinkedListNode sortedInsertOld(LinkedListNode head, int data) {
        LinkedListNode curr = head;

        LinkedListNode prev = null;
        boolean placeFound = false;
        LinkedListNode node = new LinkedListNode(data);
        do
        {
            int val = Integer.parseInt(String.valueOf(curr.val));

            if (val > data) {
                if(prev == null)
                {
                    head = node;

                    LinkedListNode tail = curr;
                    do
                    {
                        prev = tail;
                        tail = tail.next;
                    } while(tail != curr);
                }

                prev.next = node;
                node.next = curr;

                placeFound = true;

                break;
            }

            prev = curr;
            curr = curr.next;
        } while (curr != head);

        if (!placeFound) {
            prev.next = node;
            node.next = head;
        }

        return head;
    }

    public LinkedListNode sortedInsert(LinkedListNode head, int data) {
        LinkedListNode node = new LinkedListNode(data);

        if(data <= Integer.parseInt(String.valueOf(head.val)))
        {
            LinkedListNode tail = head;
            while(tail.next != head)
            {
                tail = tail.next;
            }

            tail.next = node;
            node.next = head;

            return node;
        }

        LinkedListNode curr = head;
        while (curr.next != head && Integer.parseInt(String.valueOf(curr.next.val)) < data)
        {
            curr = curr.next;
        } 

        node.next = curr.next;
        curr.next = node;

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
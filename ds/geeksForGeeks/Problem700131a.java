/*
Delete in a Doubly Linked List

You are given a Doubly Linked List and an integer x. Remove the node at position x (positions are 1-indexed) from the list, and return the head of the updated list.

Examples:

Input: x = 3,
   
Output: 1 <-> 3
Explanation: After deleting the node at position 3 (position starts from 1), the updated linked list is 1 <-> 3.
   
Input: x = 1,
   
Output: 5 <-> 2 <-> 9
Explanation: After deleting the node at position 1, the updated linked list is 5 <-> 2 <-> 9.
   
Constraints:
1 ≤ x ≤ size of the linked list ≤ 10^6
0 ≤ node->data ≤ 10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700131a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        DoublyLinkedListNode head = LinkedListUtils.getDoublyLinkedList(1, 3, 4);
        LinkedListUtils.print(head);
        // LinkedListUtils.printReverse(head);
        int x = 3;
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("delPos", DoublyLinkedListNode.class, int.class).invoke(problem, head, x));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getDoublyLinkedList(1, 5, 2, 9);
        LinkedListUtils.print(head);
        // LinkedListUtils.printReverse(head);
        x = 1;
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("delPos", DoublyLinkedListNode.class, int.class).invoke(problem, head, x));
	}

	public DoublyLinkedListNode delPos(DoublyLinkedListNode head, int x) {
        DoublyLinkedListNode dummy = new DoublyLinkedListNode(0);
        dummy.next = head;
        head.prev = dummy;
        DoublyLinkedListNode curr = dummy;
        for(int i = 1; i <= x; i++)
        {
            curr = curr.next;
        }

        DoublyLinkedListNode prev = curr.prev;
        DoublyLinkedListNode next = curr.next;

        prev.next = next;
        if(next != null)
        {
            next.prev = prev;
        }

        dummy.next.prev = null;
        return dummy.next;
        
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
/*
Reverse a Doubly Linked List

You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
   
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
   
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 10^6
0 ≤ node->data ≤ 10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700137
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        DoublyLinkedListNode head = LinkedListUtils.getDoublyLinkedList(3, 4, 5);
        LinkedListUtils.print(head);
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("reverse", DoublyLinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getDoublyLinkedList(75, 122, 59, 196);
        LinkedListUtils.print(head);
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("reverse", DoublyLinkedListNode.class).invoke(problem, head));
	}

	public DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode tail = null;
        while(curr != null)
        {
            tail = curr;
            DoublyLinkedListNode prev = curr.prev;
            DoublyLinkedListNode next = curr.next;

            curr.next = prev;
            curr.prev = next;

            curr = next;
        }

        return tail;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
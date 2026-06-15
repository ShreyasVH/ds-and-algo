/*
Insertion at doubly linked list

Given the head of a doubly-linked list, a position p, and an integer x. Add a new node with value x at the position just after pth node in the doubly linked list and return the head of the updated list.

Note: The position is 0-based indexed.

Examples:

Input: p = 2, x = 6

Output: 2 <-> 4 <-> 5 <-> 6
Explanation: Insert a node of value 6 after the 2nd node.

Input: p = 0, x = 44 

Output: 1 <-> 44 <-> 2 <-> 3 <-> 4
Explanation: Insert a node of value 44 after the 0th node.

Constraints:
0 ≤ p < list size ≤ 10^4
0 ≤ x, node->data ≤ 10^4
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700232
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        DoublyLinkedListNode head = LinkedListUtils.getDoublyLinkedList(2, 4, 5);
        LinkedListUtils.print(head);
        int pos = 2;
        int x = 6;
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("insertAtPos", DoublyLinkedListNode.class, int.class, int.class).invoke(problem, head, pos, x));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getDoublyLinkedList(1, 2, 3, 4);
        LinkedListUtils.print(head);
        pos = 0;
        x = 44;
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("insertAtPos", DoublyLinkedListNode.class, int.class, int.class).invoke(problem, head, pos, x));
	}

	public DoublyLinkedListNode insertAtPos(DoublyLinkedListNode head, int p, int x) {
        DoublyLinkedListNode curr = head;

        int currPos = 0;
        while(currPos < p) {
            curr = curr.next;
            currPos++;
        }

        DoublyLinkedListNode next = curr.next;

        DoublyLinkedListNode node = new DoublyLinkedListNode(x);

        curr.next = node;
        node.next = next;

        node.prev = curr;
        if (next != null) {
            next.prev = node;
        }

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
/*
QuickSort on Doubly Linked List

Sort the given doubly linked list using quicksort. Just complete the partition function using the quicksort technique.

Example:

Input: LinkedList: 4->2->9
Output: 2->4->9
Explaination: After sorting output will look like this.

Input:
LinkedList: 1->4->9->2
Output: 1->2->4->9
Explaination: After sorting output will look like this.
 
Expected Time Complexity: O(nlogn)
Expected Auxilliary Space: O(1)

Constraints:
1 <= no. of nodes <= 10^6
1 <= node->data <= 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700132
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        DoublyLinkedListNode head = LinkedListUtils.getDoublyLinkedList(4, 2, 9);
        LinkedListUtils.print(head);
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("quickSort", DoublyLinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getDoublyLinkedList(1, 4, 9, 2);
        LinkedListUtils.print(head);
        LinkedListUtils.print((DoublyLinkedListNode) clazz.getMethod("quickSort", DoublyLinkedListNode.class).invoke(problem, head));
	}

	public DoublyLinkedListNode quickSort(DoublyLinkedListNode head) {
        DoublyLinkedListNode tail = getTail(head);
        quickSort(head, tail);

        return head;
    }

    public void quickSort(DoublyLinkedListNode head, DoublyLinkedListNode tail) {
        if(head != null && tail != null && head != tail && head != tail.next)
        {
            DoublyLinkedListNode pivot = partition(head, tail);

            quickSort(head, pivot.prev);
            quickSort(pivot.next, tail);
        }
    }

    public DoublyLinkedListNode partition(DoublyLinkedListNode head, DoublyLinkedListNode tail)
    {
        DoublyLinkedListNode i = head;
        DoublyLinkedListNode pivot = tail;
        for(DoublyLinkedListNode j = head; j != tail; j = j.next)
        {
            if(Integer.parseInt(String.valueOf(j.val)) < Integer.parseInt(String.valueOf(pivot.val)))
            {
                int temp = Integer.parseInt(String.valueOf(i.val));
                i.val = Integer.parseInt(String.valueOf(j.val));
                j.val = temp;

                i = i.next;
            }
        }

        int temp = Integer.parseInt(String.valueOf(pivot.val));
        pivot.val = Integer.parseInt(String.valueOf(i.val));
        i.val = temp;
        return i;
    }

    public DoublyLinkedListNode getTail(DoublyLinkedListNode head)
    {
        DoublyLinkedListNode tail = head;

        while(tail != null && tail.next != null)
        {
            tail = tail.next;
        }

        return tail;
    }
}


/*
Time complexity: O(n log n)
                 O (n^2) [almost or fully sorrted]
Space complexity: O(log n)
                    O(n) [worst case]
*/
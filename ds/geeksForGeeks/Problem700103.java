/*
Rearrange linked list in-place

Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the newly formed list is: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2.

Examples :

Input: LinkedList : 1->2->3->4

Output: 1->4->2->3

Explanation: After rearranging the linked list as required, we have 1, 4, 2 and 3 as the elements of the linked list.
Input: LinkedList : 1->2->3->4->5

Output: 1->5->2->4->3

Constraints:
1 <= number of nodes <= 10^5
1 <= node->data <= 10^3

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700103
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("inPlace", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("inPlace", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("inPlace", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("inPlace", LinkedListNode.class).invoke(problem, head));
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

	public LinkedListNode inPlace(LinkedListNode root) {
        LinkedListNode middle = root;
        LinkedListNode fast = root;

        while(fast != null && fast.next != null)
        {
            middle = middle.next;
            fast = fast.next.next;
        }

        LinkedListNode second = reverse(middle);

        LinkedListNode first = root;

        while(second != middle)
        {
            LinkedListNode firstNext = first.next;
            LinkedListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }

        return root;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
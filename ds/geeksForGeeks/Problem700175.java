/*
Delete Middle of Linked List

Given a singly linked list, delete the middle of the linked list.

Note:

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
If the input linked list has a single node, then it should return NULL.
Examples:

Input: LinkedList: 1->2->3->4->5
Output: 1->2->4->5
Explanation:

Input: LinkedList: 2->4->6->7->5->1
Output: 2->4->6->5->1
Explaination:

Input: LinkedList: 7 
Output: <empty linked list>
Explanation: There was only one node and it was deleted.

Constraints:
1 <= number of nodes <= 10^5
1 <= node->data <= 10^9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700175
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("deleteMid", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 4, 6, 7, 5, 1);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("deleteMid", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(7);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("deleteMid", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("deleteMid", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode deleteMid(LinkedListNode head) {
        LinkedListNode middle = head;
        LinkedListNode fast = head;

        LinkedListNode prev = null;
        while(fast != null && fast.next != null)
        {
            prev = middle;
            fast = fast.next.next;
            middle = middle.next;
        }

        if(prev != null)
        {
            prev.next = middle.next;
        }
        else
        {
            return null;
        }

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
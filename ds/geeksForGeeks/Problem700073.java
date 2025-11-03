/*
Merge 2 sorted linked list in reverse order

Given two linked lists, which are sorted in non-decreasing order. The task is to merge them in such a way that the resulting list is in non-increasing order.

Examples:

Input: LinkedList1 = 1->3, LinkedList2 = 2->4
Output: 4->3->2->1
Explanation: After merging the two lists in non-increasing order, we have new lists as 4->3->2->1.

Input: LinkedList1 = 5->10->15->40, LinkedList2 = 2->3->20
Output: 40->20->15->10->5->3->2
Explanation: After merging the two lists in non-increasing order, we have new lists as 40->20->15->10->5->3->2.

Expected Time Complexity: O(n+m)
Expected Space Complexity: O(1)

Constraints:
1 <= size of the LinkedLists <= 10^5
0 <= node->data <= 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700073
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = LinkedListUtils.getList(1, 3);
        LinkedListUtils.print(head1);
        LinkedListNode head2 = LinkedListUtils.getList(2, 4);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("mergeResult", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        System.out.println("-------------------------------------------------------");

        head1 = LinkedListUtils.getList(5, 10, 15, 40);
        LinkedListUtils.print(head1);
        head2 = LinkedListUtils.getList(2, 3, 20);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("mergeResult", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));
	}

    public LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode prev = null;
        LinkedListNode curr = head;

        while(curr != null)
        {
            LinkedListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

	public LinkedListNode mergeResult(LinkedListNode node1, LinkedListNode node2) {
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode dummyTail = dummy;

        while(node1 != null && node2 != null)
        {
            int val1 = Integer.parseInt(String.valueOf(node1.val));
            int val2 = Integer.parseInt(String.valueOf(node2.val));

            if(val1 < val2)
            {
                dummyTail.next = node1;
                node1 = node1.next;
            }
            else
            {
                dummyTail.next = node2;
                node2 = node2.next;
            }
            dummyTail = dummyTail.next;

        }

        if(node1 != null)
        {
            dummyTail.next = node1;
        }

        if(node2 != null)
        {
            dummyTail.next = node2;
        }


        return reverse(dummy.next);
    }
}


/*
Time complexity: O(n + m)
Space complexity: O(1)
*/
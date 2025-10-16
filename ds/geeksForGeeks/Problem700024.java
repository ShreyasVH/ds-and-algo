/*
Pairwise swap elements of a linked list

Given a singly linked list. The task is to swap elements in the linked list pairwise. For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.

Note: You need to swap the nodes, not only the data. If only data is swapped then the driver code will print -1.

Examples:

Input: LinkedList: 1->2->2->4->5->6->7->8
Output: 2->1->4->2->6->5->8->7

Explanation: After swapping each pair considering (1,2), (2, 4), (5, 6).. so on as pairs, we get 2, 1, 4, 2, 6, 5, 8, 7 as a new linked list.
Input: LinkedList: 1->3->4->7->9->10->1
Output: 3->1->7->4->10->9->1

Explanation: After swapping each pair considering (1,3), (4, 7), (9, 10).. so on as pairs, we get 3, 1, 7, 4, 10, 9, 1 as a new linked list.
Constraints:
1 ≤ size of linked list ≤ 10^6
1 ≤ elements of linked list ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700024
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 2, 4, 5, 6, 7, 8);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("pairwiseSwap", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 3, 4, 7, 9, 10, 1);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("pairwiseSwap", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode pairwiseSwap(LinkedListNode head) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode curr = dummy;

        while(curr.next != null && curr.next.next != null)
        {
            LinkedListNode first = curr.next;
            LinkedListNode second = curr.next.next;

            curr.next = second;
            
            first.next = second.next;
            second.next = first;

            curr = second.next;
        }

        return dummy.next;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
/*
Absolute List Sorting

Given a linked list, sorted in ascending order based on the absolute values of its data,i.e. negative values are considered as positive ones. Sort the linked list in ascending order according to the actual values, and consider negative numbers as negative and positive numbers as positive.

Examples:

Input:  Linked List: 1 -> -2 -> -3 -> 4 -> -5
Output: -5 -> -3 -> -2 -> 1 -> 4

Explanation: Actual sorted order of {1, -2, -3, 4, -5} is {-5, -3, -2, 1, 4}
Input: Linked List: 5 -> -10
Output: -10 -> 5

Explanation: Actual sorted order of {5, -10} is {-10, 5}
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints
1 ≤  size of linked list  ≤ 10^5
-10^5 ≤  node.data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700234
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, -2, -3, 4, -5);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("sortList", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(5, -10);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("sortList", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(-2, -2, -6, -7, -9);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("sortList", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode sortList(LinkedListNode head) {
        LinkedListNode pos = new LinkedListNode(0);
        LinkedListNode posTail = pos;
        LinkedListNode neg = new LinkedListNode(0);

        LinkedListNode curr = head;

        while(curr != null) {
            LinkedListNode next = curr.next;
            int value = Integer.parseInt(String.valueOf(curr.val));

            if(value < 0)
            {
                curr.next = neg.next;
                neg.next = curr;
            }
            else
            {
                posTail.next = curr;
                curr.next = null;
                posTail = curr;
            }

            curr = next;
        }

        // LinkedListUtils.print(neg.next);
        // LinkedListUtils.print(pos.next);

        LinkedListNode negTail = neg;

        while(negTail.next != null)
        {
            negTail = negTail.next;
        }

        negTail.next = pos.next;

        return neg.next;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
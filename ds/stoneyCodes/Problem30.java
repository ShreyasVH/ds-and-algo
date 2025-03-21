/*
Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

Follow up: Could you do it in one pass?

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem30
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        int left = 2;
        int right = 4;
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseBetween", LinkedListNode.class, int.class, int.class).invoke(problem, head, left, right));

        head = new LinkedListNode(5);
        left = 1;
        right = 1;
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseBetween", LinkedListNode.class, int.class, int.class).invoke(problem, head, left, right));

	}

	public LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode current = head;
        LinkedListNode leftPrev = dummy;

        for(int i = 1; i < left; i++)
        {
            leftPrev = current;
            current = current.next;
        }

        LinkedListNode prev = null;
        for(int i = left; i <= right; i++)
        {
            LinkedListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        leftPrev.next.next = current;
        leftPrev.next = prev;

        return dummy.next;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
/*
Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:


Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem28a
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
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseList", LinkedListNode.class).invoke(problem, head));

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseList", LinkedListNode.class).invoke(problem, head));

        head = null;
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseList", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode current = head;

        while(current != null)
        {
            LinkedListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
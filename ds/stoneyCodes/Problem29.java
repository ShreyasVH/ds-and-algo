/*
Remove Linked List Elements

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem29
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(6);
        head.next.next.next = new LinkedListNode(3);
        head.next.next.next.next = new LinkedListNode(4);
        head.next.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next.next = new LinkedListNode(6);
        int val = 6;
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("removeElements", LinkedListNode.class, int.class).invoke(problem, head, val));

        head = null;
        val = 1;
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("removeElements", LinkedListNode.class, int.class).invoke(problem, head, val));

        head = new LinkedListNode(7);
        head.next = new LinkedListNode(7);
        head.next.next = new LinkedListNode(7);
        head.next.next.next = new LinkedListNode(7);
        val = 7;
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("removeElements", LinkedListNode.class, int.class).invoke(problem, head, val));
	}

	public LinkedListNode removeElements(LinkedListNode head, int val) {
        LinkedListNode dummy = new LinkedListNode(-1);
        dummy.next = head;

        LinkedListNode current = dummy;
        while(current.next != null)
        {
            if(current.next.val == val)
            {
                current.next = current.next.next;
            }
            else
            {
                current = current.next;
            }
        }


        return dummy.next;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
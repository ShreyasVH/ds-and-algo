/*
Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem27
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(0);
        head.next.next.next = new LinkedListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println((boolean) clazz.getMethod("hasCycle", LinkedListNode.class).invoke(problem, head));

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = head;
        System.out.println((boolean) clazz.getMethod("hasCycle", LinkedListNode.class).invoke(problem, head));

        head = new LinkedListNode(1);
        System.out.println((boolean) clazz.getMethod("hasCycle", LinkedListNode.class).invoke(problem, head));
	}

	public boolean hasCycle(LinkedListNode head) {
        Set<LinkedListNode> set = new HashSet<>();

        while(head != null)
        {
            if(set.contains(head))
            {
                return true;
            }

            set.add(head);

            head = head.next;
        }

        return false;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
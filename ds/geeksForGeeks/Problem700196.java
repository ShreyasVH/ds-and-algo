/*
Remove Duplicates from a Sorted Linked List

Given a singly linked list. The task is to remove duplicates (nodes with duplicate values) from the given list (if it exists).
Note: Try not to use extra space. The nodes are arranged in a sorted way.

Examples:

Input:
LinkedList: 2->2->4->5
Output: 2 -> 4 -> 5

Explanation: In the given linked list 2 -> 2 -> 4 -> 5, only 2 occurs more than 1 time. So we need to remove it once.
Input:
LinkedList: 2->2->2->2->2
Output: 2

Explanation: In the given linked list  2 -> 2 -> 2 -> 2, 2 is the only element and is repeated 5 times. So we need to remove any four 2.
Expected Time Complexity : O(n)
Expected Space Complexity: O(1)

Constraints:
1 <= Number of nodes, data of nodes <= 10^5 

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700196
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(2, 2, 4, 5);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("removeDuplicates", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 2, 2, 2, 2);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("removeDuplicates", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode removeDuplicates(LinkedListNode head) {
        LinkedListNode curr = head.next;

        LinkedListNode prev = head;
        while (curr != null) {
            if (Integer.parseInt(String.valueOf(prev.val)) == Integer.parseInt(String.valueOf(curr.val))) {
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
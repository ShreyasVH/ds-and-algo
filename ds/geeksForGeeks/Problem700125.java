/*
Remove duplicates from an unsorted linked list

Given an unsorted linked list. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all other duplicates are to be removed.

Examples:

Input: LinkedList: 5->2->2->4
Output: 5->2->4
Explanation: Given linked list elements are 5->2->2->4, in which 2 is repeated only. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain 5->2->4
 
Input: LinkedList: 2->2->2->2->2
Output: 2
Explanation:Given linked list elements are 2->2->2->2->2, in which 2 is repeated. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain only 2.
Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1 <= number of nodes <= 10^6
0 <= node->data <= 10^6
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700125
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(5, 2, 2, 4);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("removeDuplicates", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 2, 2, 2, 2);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("removeDuplicates", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode removeDuplicates(LinkedListNode head) {
        if(head == null)
        {
            return head;
        }
        LinkedListNode curr = head;
        Set<Integer> set = new HashSet<>();

        LinkedListNode prev = null;
        while(curr != null)
        {
            int value = Integer.parseInt(String.valueOf(curr.val));
            if(set.contains(value)) {
                prev.next = curr.next;
            } else {
                set.add(value);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
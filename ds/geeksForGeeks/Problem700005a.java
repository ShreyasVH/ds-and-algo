/*
Reverse a linked list

You are given the head of a singly linked list. You have to reverse the linked list and return the head of the reversed list.

Examples:

Input:
      
Output: 4 -> 3 -> 2 -> 1
Explanation: After reversing the linkedList
      
Input: 
      
Output: 8 -> 9 -> 10 -> 7 -> 2
Explanation: After reversing the linked list
      
Input: 
      
Output: 8
Explanation:
       
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700005a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseList", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 7, 10, 9, 8);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseList", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(8);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("reverseList", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode rest = head.next;

        if (head == null || rest == null) {
            return head;
        }

        LinkedListNode reversedRest = reverseList(rest);
        rest.next = head;
        head.next = null;

        return reversedRest;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n) [for recursion stack]
*/
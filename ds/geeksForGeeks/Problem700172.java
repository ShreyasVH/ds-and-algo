/*
Check If Circular Linked List

Given the head, the head of a singly linked list, Returns true if the linked list is circular & false if it is not circular.

A linked list is called circular if it is not NULL terminated and all nodes are connected in the form of a cycle. 

Note: The linked list does not contain any inner loop.

Examples:

Input: 

Output: true
Explanation: As shown in figure the first and last node is connected, i.e. 5 --> 2

Input: 
 
Output: false
Explanation: As shown in figure this is not a circular linked list.
Constraints:
1 <= number of nodes <= 100
1 <= node -> data <= 10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700172
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(2, 4, 6, 7, 5);
        head.next.next.next.next.next = head;
        System.out.println((boolean) clazz.getMethod("isCircular", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 4, 6, 7, 5, 1);
        System.out.println((boolean) clazz.getMethod("isCircular", LinkedListNode.class).invoke(problem, head));
	}

	public boolean isCircular(LinkedListNode head) {
        LinkedListNode curr = head;

        while(curr != null)
        {
            if (curr.next == head) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
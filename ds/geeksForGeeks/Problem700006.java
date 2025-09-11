/*
Reverse alternate nodes in Link List

Given a linked list, you have to perform the following task:

Extract the alternative nodes starting from the second node.
Reverse the extracted list.
Append the extracted list at the end of the original list.
Note: Try to solve the problem without using any extra memory.

Examples:

Input: LinkedList: 10->4->9->1->3->5->9->4
Output: 10->9->3->9->4->5->1->4

Explanation: Alternative nodes in the given linked list are 4,1,5,4. Reversing the alternative nodes from the given list, and then appending them to the end of the list results in a list 10->9->3->9->4->5->1->4.
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1 <= size of linked list <= 10^6
0 <= Node_value <= 10^9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700006
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(10, 4, 9, 1, 3, 5, 9, 4);
        LinkedListUtils.print(head);
        clazz.getMethod("rearrange", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.print(head);

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 3, 4, 5, 6, 7, 8);
        LinkedListUtils.print(head);
        clazz.getMethod("rearrange", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.print(head);
	}

    public static LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode curr = head;
        LinkedListNode next = null, prev = null;

        while(curr != null)
        {
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

	public static void rearrange(LinkedListNode odd) {
        LinkedListNode curr = odd;
        LinkedListNode second = null;
        LinkedListNode secondTail = null;
        LinkedListNode firstTail = null;
        while(curr != null) {
            if (curr.next != null) {
                if (second == null) {
                    second = curr.next;
                    secondTail = second;
                } else {
                    secondTail.next = curr.next;
                    secondTail = secondTail.next;
                }

                curr.next = curr.next.next;
                secondTail.next = null;
            }
            firstTail = curr;
            curr = curr.next;
        }

        second = reverse(second);
        
        firstTail.next = second;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
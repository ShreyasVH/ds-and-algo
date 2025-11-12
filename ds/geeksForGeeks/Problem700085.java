/*
Linked List in Zig-Zag fashion

Given a Linked list head, rearrange it such that the converted list should be of the form a <= b >= c <= d >= e <= f .. where a, b, c are consecutive data nodes of the linked list and such that the order of linked list is sustained.

For example: In 11 15 20 5 10 we consider only 11 20 5 15 10 because it satisfies the above condition and the order of the linked list. 5 20 11 15 10 is not considered as it does not follow the order of the linked list.

To maintain the order, keep swapping the adjacent nodes of the linked list (whenever required) to get the desired output. 

Note: You have to return the head to Zig-Zag LinkedList, and the driver code will print "true" if your LinkedList is Zig-Zag else it will print "false".

Examples:

Input: LinkedList: 1->2->3->4 
Output: true
Explanation:

Input: LinkedList: 11->15->20->5->10
Output: true
Explanation: 

In the given linked list, after arranging them as 11 < 20 > 5 < 15 > 10 in the pattern as asked above.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= number of nodes <= 1000
1 <= node -> data <= 10^4
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700085
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("zigZag", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(11, 15, 20, 5, 10);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("zigZag", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(89, 19, 59, 32, 92);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("zigZag", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode zigZag(LinkedListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }

        if(Integer.parseInt(String.valueOf(head.val)) > Integer.parseInt(String.valueOf(head.next.val)))
        {
            int temp = Integer.parseInt(String.valueOf(head.val));
            head.val = Integer.parseInt(String.valueOf(head.next.val));
            head.next.val = temp;
        }

        LinkedListNode mid = head.next;

        LinkedListNode prev = head;
        boolean direction = true;
        while(mid != null && mid.next != null)
        {
            if(
                (direction && (Integer.parseInt(String.valueOf(mid.val)) < Integer.parseInt(String.valueOf(prev.val)) || Integer.parseInt(String.valueOf(mid.val)) < Integer.parseInt(String.valueOf(mid.next.val))))
                ||
                (!direction && (Integer.parseInt(String.valueOf(mid.val)) > Integer.parseInt(String.valueOf(prev.val)) || Integer.parseInt(String.valueOf(mid.val)) > Integer.parseInt(String.valueOf(mid.next.val))))
            )
            {
                int temp = Integer.parseInt(String.valueOf(mid.val));
                mid.val = Integer.parseInt(String.valueOf(mid.next.val));
                mid.next.val = temp;
            }

            prev = mid;
            mid = mid.next;
            direction = !direction;
        }

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
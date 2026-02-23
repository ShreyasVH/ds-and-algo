/*
Intersection in Y Shaped Lists

You are given the heads of two non-empty singly linked lists, head1 and head2, that intersect at a certain point. Return that Node where these two linked lists intersect.

Note: It is guaranteed that the intersected node always exists.

In the custom input you have to give input for CommonList which pointed at the end of both head1 and head2 to form a Y-shaped linked list.
Examples:

Input: head1: 10 -> 15 -> 30, head2: 3 -> 6 -> 9 -> 15 -> 30
Output: 15
Explanation: From the above image, it is clearly seen that the common part is 15 -> 30, whose starting point is 15.
    
Input: head1: 4 -> 1 -> 8 -> 5, head2: 5 -> 6 -> 1 -> 8 -> 5
Output: 1
Explanation: From the above image, it is clearly seen that the common part is 1 -> 8 -> 5, whose starting point is 1.
    
Constraints:
2 ≤ total number of nodes ≤ 2*10^5
-10^4 ≤ node->data ≤ 10^4
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700163a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = new LinkedListNode(10);
        LinkedListNode common = LinkedListUtils.getList(15, 30);
        head1.next = common;
        LinkedListUtils.print(head1);
        LinkedListNode head2 = LinkedListUtils.getList(3, 6, 9);
        head2.next.next.next = common;
        LinkedListUtils.print(head2);
        System.out.println(((LinkedListNode) clazz.getMethod("intersectPoint", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2)).val);

        System.out.println("-------------------------------------------------------");

        head1 = new LinkedListNode(4);
        common = LinkedListUtils.getList(1, 8, 5);
        head1.next = common;
        LinkedListUtils.print(head1);
        head2 = LinkedListUtils.getList(5, 6);
        head2.next.next = common;
        LinkedListUtils.print(head2);
        System.out.println(((LinkedListNode) clazz.getMethod("intersectPoint", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2)).val);
	}

	public LinkedListNode intersectPoint(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode curr = head1;
        int len1 = 0;
        while(curr != null)
        {
            len1++;
            curr = curr.next;
        }

        int len2 = 0;
        curr = head2;
        while(curr != null)
        {
            len2++;
            curr = curr.next;
        }

        LinkedListNode first = head1;
        LinkedListNode second = head2;
        if(len1 > len2)
        {
            int diff = len1 - len2;
            while(diff > 0)
            {
                first = first.next;
                diff--;
            }
        } else if (len1 < len2) {
            int diff = len2 - len1;
            while(diff > 0)
            {
                second = second.next;
                diff--;
            }
        }

        while(first != null && second != null && first != second)
        {
            first = first.next;
            second = second.next;
        }

        if(first != null)
        {
            return first;
        }
        return null;
    }
}


/*
Time complexity: O(m + n)
Space complexity: O(1)
*/
/*
Intersection Sorted Linked Lists

Given that two linked lists are sorted in increasing order, create a new linked list representing the intersection of the two linked lists. The new linked list should be made without changing the original lists.

Note: The elements of the linked list are not necessarily distinct.

Examples:

Input: LinkedList1 = 1->2->3->4->6, LinkedList2 = 2->4->6->8
Output: 2->4->6
Explanation: For the given two linked list, 2, 4 and 6 are the elements in the intersection.

Input: LinkedList1 = 10->20->40->50, LinkedList2 = 15->40
Output: 40
Explaination:

Constraints:
1 <= size of linked lists <= 10^4
1 <= node->data<= 10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700191
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = LinkedListUtils.getList(1, 2, 3, 4, 6);
        LinkedListUtils.print(head1);
        LinkedListNode head2 = LinkedListUtils.getList(2, 4, 6, 8);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("findIntersection", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        System.out.println("-------------------------------------------------------");

        head1 = LinkedListUtils.getList(10, 20, 40, 50);
        LinkedListUtils.print(head1);
        head2 = LinkedListUtils.getList(15, 40);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("findIntersection", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));
	}

	public LinkedListNode findIntersection(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode common = new LinkedListNode(0);
        LinkedListNode commonTail = common;

        LinkedListNode curr1 = head1;
        LinkedListNode curr2 = head2;

        while(curr1 != null && curr2 != null)
        {
            if(Integer.parseInt(String.valueOf(curr1.val)) < Integer.parseInt(String.valueOf(curr2.val)))
            {
                while(curr1 != null && Integer.parseInt(String.valueOf(curr1.val)) < Integer.parseInt(String.valueOf(curr2.val)))
                {
                    curr1 = curr1.next;
                }
            }
            else if(Integer.parseInt(String.valueOf(curr1.val)) > Integer.parseInt(String.valueOf(curr2.val)))
            {
                while(curr2 != null && Integer.parseInt(String.valueOf(curr1.val)) > Integer.parseInt(String.valueOf(curr2.val)))
                {
                    curr2 = curr2.next;
                }
            }
            else
            {
                commonTail.next = new LinkedListNode(Integer.parseInt(String.valueOf(curr1.val)));
                commonTail = commonTail.next;

                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        return common.next;
    }
}


/*
Time complexity: O(n + m)
Space complexity: O(k) [for output]
*/
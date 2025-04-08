/*
Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem32
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(4);
        LinkedListNode head2 = new LinkedListNode(1);
        head2.next = new LinkedListNode(3);
        head2.next.next = new LinkedListNode(4);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("mergeTwoLists", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        head1 = null;
        head2 = null;
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("mergeTwoLists", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        head1 = null;
        head2 = new LinkedListNode(0);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("mergeTwoLists", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));
	}

	public LinkedListNode mergeTwoLists(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode dummy = new LinkedListNode(-1);

        LinkedListNode current = dummy;
        while(list1 != null && list2 != null)
        {
            if((int) list1.val < (int) list2.val)
            {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            }
            else
            {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }

        if(list1 != null)
        {
            current.next = list1;
        }
        else if(list2 != null)
        {
            current.next = list2;
        }


        return dummy.next;
    }
}


/*
Time complexity: O(m + n)
Space complexity: O(1)
*/
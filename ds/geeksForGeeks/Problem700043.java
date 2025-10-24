/*
Add Number Linked Lists

You are given the head of two singly linked lists head1 and head2 representing two non-negative integers. You have to return the head of the linked list representing the sum of these two numbers.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: 
    
Output:  1 -> 1 -> 2 -> 2
Explanation: Given numbers are 123 and 999. There sum is 1122.
    
Input: 
    
Output: 7 -> 0 
Explanation: Given numbers are 63 and 7. There sum is 70.
    
Constraints:
1 ≤ Number of nodes in head1, head2 ≤ 10^5
0 ≤ node->data ≤ 9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700043
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = LinkedListUtils.getList(1, 2, 3);
        LinkedListUtils.print(head1);
        LinkedListNode head2 = LinkedListUtils.getList(9, 9, 9);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addTwoLists", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        System.out.println("-------------------------------------------------------");

        head1 = LinkedListUtils.getList(0, 0, 6, 3);
        LinkedListUtils.print(head1);
        head2 = LinkedListUtils.getList(0, 7);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addTwoLists", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));
	}

    public LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        while(curr != null)
        {
            LinkedListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public LinkedListNode ignoreZeroesAtBeginning(LinkedListNode head)
    {
        LinkedListNode newHead = head;

        while(newHead != null && Integer.parseInt(String.valueOf(newHead.val)) == 0)
        {
            newHead = newHead.next;
        }

        return newHead;
    }

	public LinkedListNode addTwoLists(LinkedListNode head1, LinkedListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);

        LinkedListNode total = null;
        LinkedListNode totalTail = null;

        int carry = 0;
        while(head1 != null || head2 != null)
        {
            int val = carry;
            if(head1 != null)
            {
                val += Integer.parseInt(String.valueOf(head1.val));
                head1 = head1.next;
            }

            if(head2 != null)
            {
                val += Integer.parseInt(String.valueOf(head2.val));
                head2 = head2.next;
            }

            carry = val / 10;
            val = val % 10;

            LinkedListNode node = new LinkedListNode(val);
            if(total == null)
            {
                total = node;
            }
            else
            {
                totalTail.next = node;
            }
            totalTail = node;
        }

        if(carry > 0)
        {
            totalTail.next = new LinkedListNode(carry);
        }

        return ignoreZeroesAtBeginning(reverse(total));
    }
}


/*
Time complexity: O(m + n)
Space complexity: O(1)
*/
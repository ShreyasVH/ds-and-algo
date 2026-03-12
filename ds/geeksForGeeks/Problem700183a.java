/*
Decimal Equivalent of Binary Linked List

Given a singly linked list. The link list represents a binary number, ie- it contains only 0s and 1s. Find its decimal equivalent.
The significance of the bits decreases with the increasing index in the linked list. An empty linked list is considered to represent the decimal value 0. 

Since the answer can be very large, the answer modulo 109+7 should be returned.

Examples:

Input: Linked List = 1 -> 1 -> 1 -> 0

Output: 14
Explanation: 1*23 + 1*22 + 1*21 + 0*20 =  8 + 4 + 2 + 0 = 14

Input: Linked List: 0 -> 1 -> 1
Output: 3
Explanation: 0*22 + 1*21 + 1*20 =  1 + 2 + 0 = 3

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
0 <= size of linked lists <= 10^6
data of each node is either 0 or 1
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700183a
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 1, 1, 0);
        LinkedListUtils.print(head);
        System.out.println((long) clazz.getMethod("DecimalValue", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(0, 1, 1);
        LinkedListUtils.print(head);
        System.out.println((long) clazz.getMethod("DecimalValue", LinkedListNode.class).invoke(problem, head));
	}

    public long DecimalValue(LinkedListNode head) {
        LinkedListNode curr = head;

        long value = 0l;
        while(curr != null)
        {
            value = ((2 * value) + Integer.parseInt(String.valueOf(curr.val))) % 1000000007;

            curr = curr.next;
        }

        return value;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
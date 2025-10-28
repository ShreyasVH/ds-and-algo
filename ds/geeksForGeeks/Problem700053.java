/*
Add 1 to a Linked List Number

You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 10^5
0 <= list[i] <= 9
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700053
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(4, 5, 6);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addOne", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 3);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addOne", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(9, 9, 9);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addOne", LinkedListNode.class).invoke(problem, head));
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

    public LinkedListNode addOne(LinkedListNode head) {
        if (null != head) {
            head = reverse(head);

            LinkedListNode curr = head;

            int carry = 0;
            LinkedListNode tail = null;
            while(null != curr)
            {
                int val = Integer.parseInt(String.valueOf(curr.val));

                int newVal = val + carry;

                if (curr == head) {
                    newVal++;
                }

                carry = newVal / 10;
                newVal = newVal % 10;

                curr.val = newVal;

                tail = curr;
                curr = curr.next;
            }

            if (carry > 0) {
                tail.next = new LinkedListNode(carry);
            }

            return reverse(head);
        }

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
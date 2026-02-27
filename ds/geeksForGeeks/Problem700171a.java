/*
Middle of a Linked List


You are given the head of a linked list, You have to return the value of the middle node of the linked list.

If the number of nodes is odd, return the middle node value.
If the number of nodes is even, there are two middle nodes, so return the second middle node value.
Examples:

Input: 
   
Output: 3
Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.
   

Input:
   
Output: 7 
Explanation: The given linked list is 2->4->6->7->5->1 so, there are two middle node 6 and 7, return the second middle node as 7.
   
Constraints:
1 ≤ no. of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700171a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);
        System.out.println((int) clazz.getMethod("getMiddle", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 4, 6, 7, 5, 1);
        LinkedListUtils.print(head);
        System.out.println((int) clazz.getMethod("getMiddle", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1);
        LinkedListUtils.print(head);
        System.out.println((int) clazz.getMethod("getMiddle", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2);
        LinkedListUtils.print(head);
        System.out.println((int) clazz.getMethod("getMiddle", LinkedListNode.class).invoke(problem, head));
	}

    public int getMiddle(LinkedListNode head) {
        LinkedListNode middle = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null)
        {
            middle = middle.next;
            fast = fast.next.next;
        }

        return Integer.parseInt(String.valueOf(middle.val));
    }
}


/*
Time complexity: 
Space complexity: 
*/
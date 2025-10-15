/*
Rotate a Linked List

You are given the head of a singly linked list, you have to left rotate the linked list k times. Return the head of the modified linked list.

Examples:

Input: k = 4,
   
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40
   
Input: k = 6,
   
Output: 30 -> 40 -> 10 -> 20 
   
Constraints:
1 ≤ number of nodes ≤ 10^5
0 ≤ k ≤ 10^9
0 ≤ node.data ≤ 10^9

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700023
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(10, 20, 30, 40, 50);
        int k = 4;
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("rotate", LinkedListNode.class, int.class).invoke(problem, head, k));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(10, 20, 30, 40);
        k = 6;
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("rotate", LinkedListNode.class, int.class).invoke(problem, head, k));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(10, 20, 30, 40);
        k = 12;
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("rotate", LinkedListNode.class, int.class).invoke(problem, head, k));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(10);
        k = 3;
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("rotate", LinkedListNode.class, int.class).invoke(problem, head, k));
	}

	public LinkedListNode rotate(LinkedListNode head, int k) {
        LinkedListNode curr = head;

        int length = 0;
        LinkedListNode last = null;
        while(curr != null)
        {
            length++;
            last = curr;
            curr = curr.next;
        }

        last.next = head;

        k = k % length;

        if(k == 0)
        {
            last.next = null;
            return head;
        }

        curr = head;
        for(int i = 1; i < k; i++)
        {
            curr = curr.next;
        }

        LinkedListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
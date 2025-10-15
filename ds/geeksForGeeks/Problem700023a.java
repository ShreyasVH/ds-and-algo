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

public class Problem700023a
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

        k = k % length;

        if(k == 0)
        {
            last.next = null;
            return head;
        }

        return rotateRecursive(head, k);
    }

    public LinkedListNode rotateRecursive(LinkedListNode head, int k)
    {
        if(k == 0 || head == null)
        {
            return head;
        }

        LinkedListNode newHead = head.next;
        head.next = null;

        LinkedListNode last = null;
        LinkedListNode curr = newHead;
        while(curr != null)
        {
            last = curr;
            curr = curr.next;
        }

        last.next = head;

        return rotateRecursive(newHead, k - 1);
    }
}


/*
Time complexity: O(k * n)
Space complexity: O(k) [for recursion stack]
*/
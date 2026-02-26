/*
Kth from End of Linked List

You are given the head of a linked list and the number k, You have to return the kth node from the end of linkedList. If k is more than the number of nodes, then the return -1.

Examples

Input: LinkedList: 1->2->3->4->5->6->7->8->9, k = 2
Output: 8
Explanation: The given linked list is 1->2->3->4->5->6->7->8->9. The 2nd node from end is 8.

Input: LinkedList: 10->5->100->5, k = 5
Output: -1
Explanation: The given linked list is 10->5->100->5. Since 'k' is more than the number of nodes, the output is -1.

Constraints:
1 ≤ number of nodes ≤ 10^6
1 ≤ node->data , x ≤ 10^6
1 ≤ k ≤ 10^6
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700170a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        LinkedListUtils.print(head);
        int k = 2;
        System.out.println((int) clazz.getMethod("getKthFromLast", LinkedListNode.class, int.class).invoke(problem, head, k));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(10, 5, 100, 5);
        LinkedListUtils.print(head);
        k = 5;
        System.out.println((int) clazz.getMethod("getKthFromLast", LinkedListNode.class, int.class).invoke(problem, head, k));
	}

    public int getKthFromLast(LinkedListNode head, int k) {
        LinkedListNode first = head;

        int i = 1;
        while(i <= k && first != null)
        {
            first = first.next;
            i++;
        }

        if(i != k + 1)
        {
            return -1;
        }

        LinkedListNode second = head;
        while(first != null)
        {
            first = first.next;
            second = second.next;
        }

        return Integer.parseInt(String.valueOf(second.val));
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
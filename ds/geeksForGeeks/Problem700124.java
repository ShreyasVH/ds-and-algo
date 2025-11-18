/*
Quick Sort on Linked List

You are given a Linked List. Sort the given Linked List using quicksort. 

Examples:

Input: Linked list: 1->6->2
Output: 1->2->6

Explanation:
After sorting the nodes, we have 1, 2 and 6.
Input: Linked list: 1->9->3->8
Output: 1->3->8->9

Explanation:
After sorting the nodes, we have 1, 3, 8 and 9. 
Constraints:
1<= size of linked list <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700124
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 6, 2);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("quickSort", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 9, 3, 8);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("quickSort", LinkedListNode.class).invoke(problem, head));
	}

    public LinkedListNode getTail(LinkedListNode head)
    {
        LinkedListNode tail = head;

        while(tail != null && tail.next != null)
        {
            tail = tail.next;
        }

        return tail;
    }

	public LinkedListNode quickSort(LinkedListNode node) {
        LinkedListNode tail = getTail(node);

        quickSort(node, tail);

        return node;
    }

    public void quickSort(LinkedListNode head, LinkedListNode tail) {
        if(head == null || head == tail)
        {
            return;
        }

        LinkedListNode pivot = partition(head, tail);

        quickSort(head, pivot);
        quickSort(pivot.next, tail);
    }

    public LinkedListNode partition(LinkedListNode head, LinkedListNode tail) {

        LinkedListNode pivot = head;

        LinkedListNode pre = head;
        LinkedListNode curr = head;

        while(curr != tail.next)
        {
            if(Integer.parseInt(String.valueOf(curr.val)) < Integer.parseInt(String.valueOf(pivot.val)))
            {
                int temp = Integer.parseInt(String.valueOf(curr.val));
                curr.val = Integer.parseInt(String.valueOf(pre.next.val));
                pre.next.val = temp;

                pre = pre.next;
            }

            curr = curr.next;
        }

        int temp = Integer.parseInt(String.valueOf(pivot.val));
        pivot.val = Integer.parseInt(String.valueOf(pre.val));
        pre.val = temp;

        return pre;
    }
}


/*
Time complexity: O(n log n)
                 O (n^2) [almost or fully sorrted]
Space complexity: O(log n)
                    O(n) [worst case]
*/
/*
Rearrange a linked list

Given a singly linked list, the task is to rearrange it in a way that all odd position nodes are together and all even position nodes are together. (Considering 1-based indexing.)

Note: You should place all odd-positioned nodes first and then the even-positioned ones. Also, the relative order of odd-positioned nodes and even-positioned nodes should be maintained. 

Examples:

Input: LinkedList: 1->2->3->4
Output: 1->3->2->4 
Explanation: Odd elements are 1, 3 and even elements are 2, 4. Hence, resultant linked list is 1->3->2->4
 
Input: LinkedList: 1->2->3->4->5
Output: 1->3->5->2->4 
Explanation: Odd elements are 1, 3, 5 and even elements are 2, 4. Hence, resultant linked list is 1->3->5->2->4.
 
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ number of nodes ≤ 10^4
0 ≤ node->data ≤ 10^3
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700045
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4);
        LinkedListUtils.print(head);
        clazz.getMethod("rearrangeEvenOdd", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.print(head);

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);
        clazz.getMethod("rearrangeEvenOdd", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.print(head);

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1);
        LinkedListUtils.print(head);
        clazz.getMethod("rearrangeEvenOdd", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.print(head);
	}

	public void rearrangeEvenOdd(LinkedListNode head) {
        LinkedListNode curr = head;

        LinkedListNode oddHead = null, oddTail = null;
        LinkedListNode evenHead = null, evenTail = null;

        int index = 0;
        while(curr != null) {
            index++;
            if (index % 2 == 1) {
                if (oddHead == null) {
                    oddHead = curr;
                } else {
                    oddTail.next = curr;
                }
                oddTail = curr;
            } else {
                if (evenHead == null) {
                    evenHead = curr;
                } else {
                    evenTail.next = curr;
                }
                evenTail = curr;
            }

            curr = curr.next;
        }

        oddTail.next = evenHead;
        // Handling single element lists
        if (evenTail != null) {
            evenTail.next = null;
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
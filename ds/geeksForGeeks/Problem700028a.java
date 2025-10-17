/*
Sort a linked list of 0s, 1s and 2s

Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 10^6
0 ≤ node->data ≤ 2

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700028a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 2, 1, 2, 0, 2, 2);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("segregate", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 2, 0, 1);
        LinkedListUtils.print(head);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("segregate", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode segregate(LinkedListNode head) {
        LinkedListNode zeroHead = new LinkedListNode(0);
        LinkedListNode oneHead = new LinkedListNode(0);
        LinkedListNode twoHead = new LinkedListNode(0);

        LinkedListNode zeroTail = zeroHead;
        LinkedListNode oneTail = oneHead;
        LinkedListNode twoTail = twoHead;

        LinkedListNode curr = head;

        while(curr != null)
        {
            int val = Integer.parseInt(String.valueOf(curr.val));
            if(val == 0)
            {
                zeroTail.next = curr;
                zeroTail = curr;
            }
            else if(val == 1)
            {
                oneTail.next = curr;
                oneTail = curr;
            }
            else
            {
                twoTail.next = curr;
                twoTail = curr;
            }

            curr = curr.next;
        }

        zeroTail.next = ((oneHead != oneTail) ? oneHead.next : twoHead.next);
        oneTail.next = twoHead.next;
        twoTail.next = null;

        return zeroHead.next;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
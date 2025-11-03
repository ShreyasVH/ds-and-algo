/*


*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700073
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = LinkedListUtils.getList(1, 3);
        LinkedListUtils.print(head1);
        LinkedListNode head2 = LinkedListUtils.getList(2, 4);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("mergeResult", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        System.out.println("-------------------------------------------------------");

        head1 = LinkedListUtils.getList(5, 10, 15, 40);
        LinkedListUtils.print(head1);
        head2 = LinkedListUtils.getList(2, 3, 20);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("mergeResult", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));
	}

    public LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode prev = null;
        LinkedListNode curr = head;

        while(curr != null)
        {
            LinkedListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

	public LinkedListNode mergeResult(LinkedListNode node1, LinkedListNode node2) {
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode dummyTail = dummy;

        while(node1 != null && node2 != null)
        {
            int val1 = Integer.parseInt(String.valueOf(node1.val));
            int val2 = Integer.parseInt(String.valueOf(node2.val));

            if(val1 < val2)
            {
                dummyTail.next = node1;
                node1 = node1.next;
            }
            else
            {
                dummyTail.next = node2;
                node2 = node2.next;
            }
            dummyTail = dummyTail.next;

        }

        if(node1 != null)
        {
            dummyTail.next = node1;
        }

        if(node2 != null)
        {
            dummyTail.next = node2;
        }


        return reverse(dummy.next);
    }
}


/*
Time complexity: O(n + m)
Space complexity: O(1)
*/
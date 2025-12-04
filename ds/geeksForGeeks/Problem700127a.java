/*


*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700127a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(4);
        head.next.next.next = head;
        int data = 2;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(4);
        head.next.next = new LinkedListNode(7);
        head.next.next.next = new LinkedListNode(9);
        head.next.next.next.next = head;
        data = 5;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(4);
        head.next = new LinkedListNode(7);
        head.next.next = new LinkedListNode(9);
        head.next.next.next = head;
        data = 1;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = head;
        data = 4;
        LinkedListUtils.printCircularList(head);
        LinkedListUtils.printCircularList((LinkedListNode) clazz.getMethod("sortedInsert", LinkedListNode.class, int.class).invoke(problem, head, data));
	}

	public LinkedListNode sortedInsert(LinkedListNode head, int data) {
        LinkedListNode curr = head;

        boolean placeFound = false;
        LinkedListNode tail = null;
        do
        {
            int val = Integer.parseInt(String.valueOf(curr.val));

            if (val > data) {
                LinkedListNode node = new LinkedListNode(val);
                curr.val = data;
                node.next = curr.next;
                curr.next = node;

                placeFound = true;

                break;
            }

            tail = curr;
            curr = curr.next;
        } while(curr != head);

        if (!placeFound) {
            LinkedListNode node = new LinkedListNode(data);
            tail.next = node;
            node.next = head;
        }

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
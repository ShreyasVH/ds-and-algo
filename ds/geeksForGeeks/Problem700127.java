/*


*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700127
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

	public LinkedListNode sortedInsertOld(LinkedListNode head, int data) {
        LinkedListNode curr = head;

        LinkedListNode prev = null;
        boolean placeFound = false;
        LinkedListNode node = new LinkedListNode(data);
        do
        {
            int val = Integer.parseInt(String.valueOf(curr.val));

            if (val > data) {
                if(prev == null)
                {
                    head = node;

                    LinkedListNode tail = curr;
                    do
                    {
                        prev = tail;
                        tail = tail.next;
                    } while(tail != curr);
                }

                prev.next = node;
                node.next = curr;

                placeFound = true;

                break;
            }

            prev = curr;
            curr = curr.next;
        } while (curr != head);

        if (!placeFound) {
            prev.next = node;
            node.next = head;
        }

        return head;
    }

    public LinkedListNode sortedInsert(LinkedListNode head, int data) {
        LinkedListNode node = new LinkedListNode(data);

        if(data <= Integer.parseInt(String.valueOf(head.val)))
        {
            LinkedListNode tail = head;
            while(tail.next != head)
            {
                tail = tail.next;
            }

            tail.next = node;
            node.next = head;

            return node;
        }

        LinkedListNode curr = head;
        while (curr.next != head && Integer.parseInt(String.valueOf(curr.next.val)) < data)
        {
            curr = curr.next;
        } 

        node.next = curr.next;
        curr.next = node;

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
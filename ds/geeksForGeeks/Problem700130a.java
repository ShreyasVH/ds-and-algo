/*
Split a Linked List into two halves

Given a Circular linked list. The task is split into two Circular Linked lists. If there are an odd number of nodes in the given circular linked list then out of the resulting two halved lists, the first list should have one node more than the second list.

Examples :

Input: LinkedList : 10->4->9
Output: 10->4 , 9

Explanation: After dividing linked list into 2 parts , the first part contains 10, 4 and second part contain only 9.
Input: LinkedList : 10->4->9->10
Output: 10->4 , 9->10

Explanation: After dividing linked list into 2 parts , the first part contains 10, 4 and second part contain 9, 10.
Constraints:
2 <= number of nodes <= 10^5
1 <= node->data <= 10^3

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700130a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(10);
        head.next = new LinkedListNode(4);
        head.next.next = new LinkedListNode(9);
        head.next.next.next = head;
        LinkedListUtils.printCircularList(head);
        Pair<LinkedListNode, LinkedListNode> pair = (Pair<LinkedListNode, LinkedListNode>) clazz.getMethod("splitList", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.printCircularList(pair.first);
        LinkedListUtils.printCircularList(pair.second);

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(10);
        head.next = new LinkedListNode(4);
        head.next.next = new LinkedListNode(9);
        head.next.next.next = new LinkedListNode(8);
        head.next.next.next.next = head;
        LinkedListUtils.printCircularList(head);
        pair = (Pair<LinkedListNode, LinkedListNode>) clazz.getMethod("splitList", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.printCircularList(pair.first);
        LinkedListUtils.printCircularList(pair.second);
	}

	public Pair<LinkedListNode, LinkedListNode> splitList(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast.next != head && fast.next.next != head)
        {
            slow = slow.next;
            fast = fast.next.next;
        } 

        LinkedListNode last;
        if(fast.next == head)
        {
            last = fast;
        }
        else
        {
            last = fast.next;
        }

        LinkedListNode second = slow.next;
        slow.next = head;
        last.next = second;
        return new Pair<>(head, second);
    }

    class Pair<F, S>
    {
        F first;
        S second;

        Pair(F first, S second)
        {
            this.first = first;
            this.second = second;
        }
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
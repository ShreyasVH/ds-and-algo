/*
Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem26
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        LinkedListNode middle = (LinkedListNode) clazz.getMethod("middleNode", LinkedListNode.class).invoke(problem, head);
        System.out.println(middle.val);

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        middle = (LinkedListNode) clazz.getMethod("middleNode", LinkedListNode.class).invoke(problem, head);
        System.out.println(middle.val);
	}

    public int getLength(LinkedListNode head)
    {
        int length = 0;

        while(head != null)
        {
            length++;
            head = head.next;
        }

        return length;
    }

	public LinkedListNode middleNode(LinkedListNode head) {
        int length = getLength(head);
        int middleIndex = length / 2;

        LinkedListNode middle = head;
        while(middleIndex > 0)
        {
            middle = middle.next;
            middleIndex--;
        }
        
        return middle;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
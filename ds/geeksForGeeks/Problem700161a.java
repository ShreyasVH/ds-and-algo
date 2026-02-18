/*
Delete without head pointer

You are given a node del_node of a Singly Linked List where you have to delete this given node from the linked list but you are not given the head of the list.

After deleting the given node:

The number of nodes in the linked list should decrease by one.
All the values before & after the del_node node should be in the same order.
Note: It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.

Examples:

Input: Linked List = 1 -> 2, del_node = 1
Output: 2
Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.
 
Input: Linked List = 10 -> 20 -> 4 -> 30, del_node = 20
Output: 10->4->30
Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.

Constraints:
2 ≤ number of nodes ≤ 10^6  
1 ≤ node->data ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700161a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2);
        LinkedListUtils.print(head);
        clazz.getMethod("deleteNode", LinkedListNode.class).invoke(problem, head);
        LinkedListUtils.print(head);

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(10, 20, 4, 30);
        LinkedListUtils.print(head);
        clazz.getMethod("deleteNode", LinkedListNode.class).invoke(problem, head.next);
        LinkedListUtils.print(head);
	}

	public void deleteNode(LinkedListNode del_node) {
        if(del_node == null || del_node.next == null)
        {
            return;
        }

        LinkedListNode next = del_node.next;
        del_node.val = Integer.parseInt(String.valueOf(next.val));
        del_node.next = next.next;
        next.next = null;
        next = null;
    }
}


/*
Time complexity: O(1)
Space complexity: O(1)
*/
/*
Find Length of Linked List

Given head of a singly linked list. The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.

Examples :

Input: head : 1->2->3->4->5

Output: 5
Explanation: Length of the linked list is 5, as there 
are 5 nodes present in it.
Input: head : 2->4->6->7->5->1->0
 
Output: 7
Explanation: Length of the linked list is 7, as there 
are 7 nodes present in it.
Constraints:
1 <= number of nodes <= 4*10^4
1 <= node->data <= 10^3

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700039
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);
        System.out.println((int) clazz.getMethod("getCount", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(2, 4, 6, 7, 5, 1, 0);
        LinkedListUtils.print(head);
        System.out.println((int) clazz.getMethod("getCount", LinkedListNode.class).invoke(problem, head));
	}

	public int getCount(LinkedListNode head) {
        LinkedListNode curr = head;
        int count = 0;
        while(curr != null)
        {
            count++;
            curr = curr.next;
        }
        return count;
    }
}


/*
Time complexity: 
Space complexity: 
*/
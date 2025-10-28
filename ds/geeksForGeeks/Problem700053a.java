/*
Add 1 to a Linked List Number

You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 10^5
0 <= list[i] <= 9
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700053a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(4, 5, 6);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addOne", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 3);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addOne", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(9, 9, 9);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("addOne", LinkedListNode.class).invoke(problem, head));
	}

	public LinkedListNode addOne(LinkedListNode head) {
        if (null != head) {
            LinkedListNode curr = head;
            LinkedListNode lastNotNine = null;

            while(curr != null)
            {
                int val = Integer.parseInt(String.valueOf(curr.val));

                if (val != 9)
                    lastNotNine = curr;

                curr = curr.next;
            }

            if (lastNotNine == null)
            {
                LinkedListNode node = new LinkedListNode(1);
                curr = head;

                node.next = head;
                head = node;
            }
            else
            {
                lastNotNine.val = Integer.parseInt(String.valueOf(lastNotNine.val)) + 1;
                curr = lastNotNine.next;
            }

            while(curr != null)
            {
                curr.val = 0;
                curr = curr.next;
            }

        }

        return head;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
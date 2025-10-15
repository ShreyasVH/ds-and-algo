/*
Delete N nodes after M nodes of a linked list

Given a linked list, delete n nodes after skipping m nodes of a linked list until the last of the linked list.
Examples:

Input: Linked List: 9->1->3->5->9->4->10->1, n = 1, m = 2

Output: 9->1->5->9->10->1

Explanation: Deleting 1 node after skipping 2 nodes each time, we have list as 9-> 1-> 5-> 9-> 10-> 1.
Input: Linked List: 1->2->3->4->5->6, n = 1, m = 6

Output: 1->2->3->4->5->6

Explanation: After skipping 6 nodes for the first time , we will reach of end of the linked list, so, we will get the given linked list itself.
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1 <= size of linked list <= 1000
0 < n, m <= size of linked list

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700021a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(9, 1, 3, 5, 9, 4, 10, 1);
        int n = 1;
        int m = 2;
        LinkedListUtils.print(head);
        clazz.getMethod("linkdelete", LinkedListNode.class, int.class, int.class).invoke(problem, head, n, m);
        LinkedListUtils.print(head);

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 3, 4, 5, 6);
        n = 1;
        m = 6;
        LinkedListUtils.print(head);
        clazz.getMethod("linkdelete", LinkedListNode.class, int.class, int.class).invoke(problem, head, n, m);
        LinkedListUtils.print(head);

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 3, 4, 5, 6);
        n = 2;
        m = 2;
        LinkedListUtils.print(head);
        clazz.getMethod("linkdelete", LinkedListNode.class, int.class, int.class).invoke(problem, head, n, m);
        LinkedListUtils.print(head);
	}

	public void linkdelete(LinkedListNode head, int n, int m) {
        if(head == null) return;
        
        LinkedListNode curr = head;
        for(int i = 1; i < m && curr != null; i++)
        {
            curr = curr.next;
        }

        if(curr == null) return;

        LinkedListNode del = curr.next;
        for(int i = 0; i < n && del != null; i++)
        {
            del = del.next;
        }

        curr.next = del;
        linkdelete(del, n, m);
    }
}


/*
Time complexity: O(L)
Space complexity: O(L / (m + n))
*/
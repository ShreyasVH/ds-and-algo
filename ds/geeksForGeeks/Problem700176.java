/*
Merge two sorted linked lists

Given the head of two sorted linked lists consisting of nodes respectively. Merge both lists and return the head of the sorted merged list.

Examples:

Input:
  
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:
   
Input:
  
Output: 1 -> 1 -> 2 -> 4
Explanation:
  
Constraints:
1 ≤ list1.size, list2.size ≤ 10^3
0 ≤ node->data ≤ 10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700176
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = LinkedListUtils.getList(5, 10, 15, 40);
        LinkedListUtils.print(head1);
        LinkedListNode head2 = LinkedListUtils.getList(2, 3, 20);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("sortedMerge", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        System.out.println("-------------------------------------------------------");

        head1 = LinkedListUtils.getList(1, 1);
        LinkedListUtils.print(head1);
        head2 = LinkedListUtils.getList(2, 4);
        LinkedListUtils.print(head2);
        LinkedListUtils.print((LinkedListNode) clazz.getMethod("sortedMerge", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));
	}

	public LinkedListNode sortedMerge(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode dummy = new LinkedListNode(0);

        LinkedListNode tail = dummy;

        while(head1 != null && head2 != null)
        {
            if(Integer.parseInt(String.valueOf(head1.val)) <= Integer.parseInt(String.valueOf(head2.val)))
            {
                tail.next = head1;
                head1 = head1.next;
            }
            else
            {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if(head1 != null)
        {
            tail.next = head1;
        }

        if(head2 != null)
        {
            tail.next = head2;
        }
        
        return dummy.next;
    }
}


/*
Time complexity: O(m + n)
Space complexity: O(1)
*/
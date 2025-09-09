/*
Print Linked List

You are given the head of a singly linked list. Return an array containing the values of the nodes.

Examples:

Input:
    
Output: [1, 2, 3, 4, 5]
Explanation: The linked list contains 5 elements [1, 2, 3, 4, 5]. The elements are printed in a single line.

Input:
    
Output: [10, 20, 30, 40, 50, 60]
Explanation: The linked list contains 5 elements [10, 20, 30, 40, 50, 60]. The elements are printed in a single line.
Constraints :
1 ≤ numbers of nodes ≤ 10^5
1 ≤ node values ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700004
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);
        System.out.println((ArrayList<Integer>) clazz.getMethod("printList", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(10, 20, 30, 40, 50, 60);
        LinkedListUtils.print(head);
        System.out.println((ArrayList<Integer>) clazz.getMethod("printList", LinkedListNode.class).invoke(problem, head));
	}

	public ArrayList<Integer> printList(LinkedListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null)
        {
            list.add(Integer.valueOf(head.val.toString()));
            head = head.next;
        }
        
        return list;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
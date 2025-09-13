/*
Frequency in a Linked List

Given a singly linked list and a key, count the number of occurrences of the given key in the linked list.

Examples:

Input: Linked List: 1->2->1->2->1->3->1, key = 1

Output: 4
Explanation: 1 appears 4 times. 

Input: Linked List: 1->2->1->2->1, key = 3

Output: 0
Explanation: 3 appears 0 times.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ number of nodes, key ≤ 10^5
1 ≤ data of node ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700019
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 1, 2, 1, 3, 1);
        int key = 1;
        System.out.println((int) clazz.getMethod("count", LinkedListNode.class, int.class).invoke(problem, head, key));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 2, 1, 2, 1);
        key = 3;
        System.out.println((int) clazz.getMethod("count", LinkedListNode.class, int.class).invoke(problem, head, key));
	}

	public static int count(LinkedListNode head, int key) {
        LinkedListNode curr = head;
        int c = 0;
        while (curr != null) {
            if(Integer.valueOf(String.valueOf(curr.val)) == key)
            {
                c++;
            }
            curr = curr.next;
        }
        return c;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
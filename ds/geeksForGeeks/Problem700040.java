/*
Node at a given index in linked list

Given the head of a Singly Linked List and an index, The task is to find the node at the given index(1-based index) of the linked list. If no such index exists then return -1.

Examples :

Input: LinkedList: 1->2->3->4->5->6->7 , index = 3

Output: 3
Explanation: The Node value at index 3 is 3.
Input: LinkedList: 19->28->37->46->55 , index = 6

Output: -1
Explanation: As number of nodes are less than k so there is no node at index 6 , therefore our answer is -1.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= number of nodes <= 10^5
1 <= node->data , k <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700040
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList(1, 2, 3, 4, 5, 6, 7);
        int index = 3;
        System.out.println((int) clazz.getMethod("GetNth", LinkedListNode.class, int.class).invoke(problem, head, index));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(19, 28, 37, 46, 55);
        index = 6;
        System.out.println((int) clazz.getMethod("GetNth", LinkedListNode.class, int.class).invoke(problem, head, index));
	}

	public int GetNth(LinkedListNode head, int index) {
        int i = 0;
        LinkedListNode curr = head;
        while(curr != null)
        {
            i++;
            if(i == index)
            {
                return Integer.parseInt(String.valueOf(curr.val));
            }
            curr = curr.next;
        }
        
        return -1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
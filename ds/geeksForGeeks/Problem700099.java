/*
Detect Loop in linked list

You are given the head of a singly linked list. You have to determine whether the given linked list contains a loop or not. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null. Note that pos is not passed as a parameter.

Examples:

Input: pos = 2,
   
Output: true
Explanation: There exists a loop as last node is connected back to the second node.
Input: pos = 0,
   
Output: false
Explanation: There exists no loop in given linked list.
Input: pos = 1,
   
Output: true
Explanation: There exists a loop as last node is connected back to the first node.
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^3       
0 ≤ pos ≤ number of nodes
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700099
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode repeatNode = new LinkedListNode(3);
        head.next = repeatNode;
        head.next.next = new LinkedListNode(4);
        head.next.next.next = repeatNode;

        System.out.println((boolean) clazz.getMethod("detectLoop", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = LinkedListUtils.getList(1, 8, 3, 4);
        System.out.println((boolean) clazz.getMethod("detectLoop", LinkedListNode.class).invoke(problem, head));

        System.out.println("-------------------------------------------------------");

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(7);
        head.next.next = new LinkedListNode(8);
        head.next.next.next = new LinkedListNode(10);
        head.next.next.next.next = head;
        System.out.println((boolean) clazz.getMethod("detectLoop", LinkedListNode.class).invoke(problem, head));
	}

	public boolean detectLoop(LinkedListNode head) {
        Set<LinkedListNode> set = new HashSet<>();

        LinkedListNode curr = head;

        while(curr != null)
        {
            if(set.contains(curr))
            {
                return true;
            }
            set.add(curr);

            curr = curr.next;
        }


        return false;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
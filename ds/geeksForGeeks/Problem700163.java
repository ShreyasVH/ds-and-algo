/*
Intersection in Y Shaped Lists

You are given the heads of two non-empty singly linked lists, head1 and head2, that intersect at a certain point. Return that Node where these two linked lists intersect.

Note: It is guaranteed that the intersected node always exists.

In the custom input you have to give input for CommonList which pointed at the end of both head1 and head2 to form a Y-shaped linked list.
Examples:

Input: head1: 10 -> 15 -> 30, head2: 3 -> 6 -> 9 -> 15 -> 30
Output: 15
Explanation: From the above image, it is clearly seen that the common part is 15 -> 30, whose starting point is 15.
    
Input: head1: 4 -> 1 -> 8 -> 5, head2: 5 -> 6 -> 1 -> 8 -> 5
Output: 1
Explanation: From the above image, it is clearly seen that the common part is 1 -> 8 -> 5, whose starting point is 1.
    
Constraints:
2 ≤ total number of nodes ≤ 2*10^5
-10^4 ≤ node->data ≤ 10^4
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700163
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = new LinkedListNode(10);
        LinkedListNode common = LinkedListUtils.getList(15, 30);
        head1.next = common;
        LinkedListUtils.print(head1);
        LinkedListNode head2 = LinkedListUtils.getList(3, 6, 9);
        head2.next.next.next = common;
        LinkedListUtils.print(head2);
        System.out.println(((LinkedListNode) clazz.getMethod("intersectPoint", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2)).val);

        System.out.println("-------------------------------------------------------");

        head1 = new LinkedListNode(4);
        common = LinkedListUtils.getList(1, 8, 5);
        head1.next = common;
        LinkedListUtils.print(head1);
        head2 = LinkedListUtils.getList(5, 6);
        head2.next.next = common;
        LinkedListUtils.print(head2);
        System.out.println(((LinkedListNode) clazz.getMethod("intersectPoint", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2)).val);
	}

	public LinkedListNode intersectPoint(LinkedListNode head1, LinkedListNode head2) {
        Stack<LinkedListNode> s1 = new Stack<>();
        Stack<LinkedListNode> s2 = new Stack<>();

        LinkedListNode curr = head1;
        while(curr != null)
        {
            s1.push(curr);

            curr = curr.next;
        }

        curr = head2;
        while(curr != null)
        {
            s2.push(curr);
            curr = curr.next;
        }

        LinkedListNode common = null;
        while(!s1.empty() && !s2.empty() && s1.peek() == s2.peek())
        {
            common = s1.pop();
            s2.pop();
        }

        return common;
    }
}


/*
Time complexity: O(m + n)
Space complexity: O(m + n)
*/
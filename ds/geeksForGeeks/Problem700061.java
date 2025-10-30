/*
Compare two linked lists

Given two strings, head1 and head2, represented as linked lists where each character is stored in a node's data field, complete the function compare() that mimics the behavior of strcmp(). Specifically, the function should return:

0 if both strings are identical,
1 if the first linked list is lexicographically greater, and
-1 if the second linked list is lexicographically greater.
Examples:

Input: head1 = a->b->a->b->a , head2 = a->b->a->a

Output: 1
Explanation: String consisting of nodes of first linked list is lexicographically greater than the second one. So, the result is 1.
Input: head1 = a->a->b , head2 = a->a->b

Output: 0
Explanation: String consisting of nodes of first linked list is same as the second one. So, the result is 0.
Input: head1 = a->b->c->d , head2 = a->b->c->e
Output: -1
Explanation: String consisting of nodes of second linked list is lexicographically greater than the first one. So, the result is -1.
Constraints:
1 <= no. of nodes in head1 and head2 <= 100

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700061
{
	public static void main(String args[]) throws Exception
	{
        Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head1 = LinkedListUtils.getList('a', 'b', 'a', 'b', 'a');
        LinkedListNode head2 = LinkedListUtils.getList('a', 'b', 'a', 'a');
        System.out.println((int) clazz.getMethod("compare", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        System.out.println("-------------------------------------------------------");

        head1 = LinkedListUtils.getList('a', 'a', 'b');
        head2 = LinkedListUtils.getList('a', 'a', 'b');
        System.out.println((int) clazz.getMethod("compare", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));

        System.out.println("-------------------------------------------------------");

        head1 = LinkedListUtils.getList('a', 'b', 'c', 'd');
        head2 = LinkedListUtils.getList('a', 'b', 'c', 'e');
        System.out.println((int) clazz.getMethod("compare", LinkedListNode.class, LinkedListNode.class).invoke(problem, head1, head2));
	}

    public int compare(LinkedListNode head1, LinkedListNode head2) {
        int val = 0;

        while((head1 != null) && (head2 != null))
        {
            char char1 = (char) head1.val;
            char char2 = (char) head2.val;

            int comparedValue = Character.compare(char1, char2);

            if (comparedValue != 0)
            {
                if(comparedValue < 1)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1 != null)
        {
            val = 1;
        }
        else if (head2 != null)
        {
            val = -1;
        }

        return val;
    }
}


/*
Time complexity: O(min(m, n))
Space complexity: O(1)
*/
/*
Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true

Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem31a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);
        System.out.println((boolean) clazz.getMethod("isPalindrome", LinkedListNode.class).invoke(problem, head));

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        System.out.println((boolean) clazz.getMethod("isPalindrome", LinkedListNode.class).invoke(problem, head));
	}

	public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode mid = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            mid = mid.next;
        }

        LinkedListNode prev = null;
        LinkedListNode current = mid;
        while(current != null)
        {
            LinkedListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        current = head;
        LinkedListNode secondHead = prev;

        while(secondHead != null)
        {
            if(current.val != secondHead.val)
            {
                return false;
            }

            current = current.next;
            secondHead = secondHead.next;
        }

        return true;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
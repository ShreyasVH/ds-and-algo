/*
Linked list of strings forms a palindrome

Given a linked list with string data, check whether the combined string formed is palindrome. If the combined string is palindrome then return true otherwise return false.

Example:

Input: a -> bc -> d -> dcb -> a

Output : true
Explanation: As string "abcddcba" is palindrome the function should return true.

Input: a -> bc -> d -> a

Output : false
Explanation: As string "abcdba" is not palindrome the function should return false.
Expected Time Complexity:  O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Node.data.length<= 103
1<=list.length<=103

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700056 {
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        LinkedListNode head = LinkedListUtils.getList("a", "bc", "d", "dcb", "a");
        LinkedListUtils.print(head);
        System.out.println((boolean) clazz.getMethod("compute", LinkedListNode.class).invoke(problem, head));

        System.out.println("----------------------------------");

        head = LinkedListUtils.getList("a", "bc", "d", "a");
        LinkedListUtils.print(head);
        System.out.println((boolean) clazz.getMethod("compute", LinkedListNode.class).invoke(problem, head));
	}

	public boolean isPalindrome(String s)
	{
		for(int i = 0; i < (s.length() / 2); i++)
		{
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
			{
				return false;
			}
		}
		return true;
	}

	public boolean compute(LinkedListNode root) {
		StringBuilder sb = new StringBuilder();

		while(root != null)
		{
			sb = sb.append(root.val.toString());
			root = root.next;
		}

		return isPalindrome(sb.toString());
	}
}

/*
Time complexity: O(n)
Space complexity: O(n)
*/
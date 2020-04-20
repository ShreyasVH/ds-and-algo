/*
	Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
*/
import java.util.Stack;
class Solution
{
	public static class LinkedNode
	{
		char val;
		LinkedNode next;

		public LinkedNode(char data)
		{
			this.val = data;
		}
	}

	public static void main(String[] args)
	{
		Solution s = new Solution();
		LinkedNode head = s.construct(new char[]{'r', 'a', 'd', 'a', 'r'});
		System.out.println(s.isPlaindrome(head));

		head = s.construct(new char[]{'a', 'b', 'b', 'a'});
		System.out.println(s.isPlaindrome(head));

		head = s.construct(new char[]{'r', 'a', 'i', 'n', 'b', 'o', 'w'});
		System.out.println(s.isPlaindrome(head));
	}

	public boolean isPlaindrome(LinkedNode head)
	{
		boolean isPlaindrome = true;
		Stack<LinkedNode> s = new Stack<>();

		LinkedNode cur = head;
		while(null != cur)
		{
			s.push(cur);
			cur = cur.next;
		}

		cur = head;
		while(null != cur)
		{
			LinkedNode temp = s.pop();
			if(temp.val != cur.val)
			{
				isPlaindrome = false;
				break;
			}

			cur = cur.next;
		}

		return isPlaindrome;
	}

	public LinkedNode construct(char[] nums)
	{
		LinkedNode head = null;
		LinkedNode tail = null;

		for(int i = 0; i < nums.length; i++)
		{
			LinkedNode node = new LinkedNode(nums[i]);

			if(null == head)
			{
				head = node;
				tail = node;
			}
			else
			{
				tail.next = node;
				tail = node;
			}
		}

		return head;
	}
}
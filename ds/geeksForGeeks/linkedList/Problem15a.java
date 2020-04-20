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
		
		LinkedNode slow = head;
		LinkedNode fast = head;
		LinkedNode prev = null;

		while((null != fast) && (null != fast.next))
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedNode secondHead = null;
		if(null == fast)
		{
			secondHead = slow;
		}
		else
		{
			secondHead = slow.next;
			prev = slow;
		}

		secondHead = reverse(secondHead);

		LinkedNode cur = head;
		while(null != secondHead)
		{
			if(secondHead.val != cur.val)
			{
				isPlaindrome = false;
				break;
			}
			cur = cur.next;
			secondHead = secondHead.next;
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

	public LinkedNode reverse(LinkedNode head)
	{
		LinkedNode cur = head;
		LinkedNode prev = null;
		LinkedNode next;

		while(null != cur)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static void print(LinkedNode head)
	{
		while(null != head)
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
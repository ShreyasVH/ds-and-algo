/*
	Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.

	If there are even nodes, then there would be two middle nodes, we need to print second middle element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
*/

class Solution
{
	public static class LinkedNode
	{
		int val;
		LinkedNode next;

		public LinkedNode(int data)
		{
			this.val = data;
		}
	}

	public static void main(String[] args)
	{
		LinkedNode head = construct(new int[]{1, 2, 3, 4, 5});
		System.out.println(middle(head));

		LinkedNode head1 = construct(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(middle(head1));

		LinkedNode head2 = construct(new int[]{1});
		System.out.println(middle(head2));

		LinkedNode head3 = construct(new int[]{1, 2});
		System.out.println(middle(head3));

		LinkedNode head4 = construct(new int[]{});
		try
		{
			System.out.println(middle(head4));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

	public static int middle(LinkedNode head)
	{
		if(null == head)
		{
			throw new RuntimeException("Empty List");
		}
		else
		{
			LinkedNode middle = head;
			int index = 0;

			LinkedNode curr = head;
			while(null != head)
			{
				if((index & 1) == 1)
				{
					middle = middle.next;
				}
				head = head.next;
				index++;
			}
			return middle.val;
		}
	}

	public static LinkedNode construct(int[] nums)
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
/*
	Length of linked list - Recursive
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
		LinkedNode head = construct(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(length(head));

		LinkedNode head1 = construct(new int[]{1});
		System.out.println(length(head1));

		LinkedNode head2 = construct(new int[]{});
		System.out.println(length(head2));
	}

	public static int length(LinkedNode head)
	{
		if(null == head)
		{
			return 0;
		}
		else
		{
			return (length(head.next) + 1);
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
/*
	Search for key in linked list - Recursive
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
		System.out.println(search(head, 3));

		LinkedNode head1 = construct(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(search(head1, 7));
	}

	public static boolean search(LinkedNode head, int key)
	{
		if(null == head)
		{
			return false;
		}
		else
		{
			return ((head.val == key) || search(head.next, key));
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
/*
	Delete a linked list
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
		head = delete(head);
		print(head);
	}

	public static LinkedNode delete(LinkedNode head)
	{
		head = null;
		return head;
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
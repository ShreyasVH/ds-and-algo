/*
	Linkedlist deletion at index
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
		head = delete(head, 2);
		// print(head);
		head = delete(head, 0);
		// print(head);
		head = delete(head, 3);
		print(head);
	}

	public static LinkedNode delete(LinkedNode head, int pos)
	{
		if(null != head)
		{
			if(0 == pos)
			{
				LinkedNode prevHead = head;
				head = head.next;
				prevHead = null;
			}
			else
			{
				LinkedNode prev = null;

				LinkedNode curr = head;
				int index = 0;
				while((null != curr) && (index < pos))
				{
					prev = curr;
					curr = curr.next;
					index++;
				}

				if(null != curr)
				{
					prev.next = curr.next;
					curr = null;
				}
				else
				{
					throw new RuntimeException("Out of bounds");
				}
			}
		}


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
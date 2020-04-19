/*
	Linkedlist deletion of key
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
		head = delete(head, 3);
		head = delete(head, 1);
		head = delete(head, 6);
		print(head);
	}

	public static LinkedNode delete(LinkedNode head, int key)
	{
		if(null != head)
		{
			if(head.val == key)
			{
				LinkedNode prevHead = head;
				head = head.next;
				prevHead = null;
			}
			else
			{
				LinkedNode prev = null;

				LinkedNode curr = head;
				while((null != curr) && (curr.val != key))
				{
					prev = curr;
					curr = curr.next;
				}

				if(null != curr)
				{
					prev.next = curr.next;
					curr = null;
				}
				else
				{
					throw new RuntimeException("Key not found");
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
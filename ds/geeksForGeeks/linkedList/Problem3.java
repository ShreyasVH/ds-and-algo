/*
	Linkedlist insertion
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
		LinkedNode head = construct(new int[]{2, 4, 5});
		head = insert(head, 1, 3);
		head = insert(head, 0, 1);
		head = insert(head, 5, 6);
		print(head);
	}

	public static LinkedNode insert(LinkedNode head, int pos, int data)
	{
		if(null == head)
		{
			if(pos == 0)
			{
				head = new LinkedNode(data);
			}
		}
		else
		{
			LinkedNode node = new LinkedNode(data);
			if(pos == 0)
			{
				node.next = head;
				head = node;
			}
			else
			{
				LinkedNode prev = null;
				int index = 0;
				LinkedNode curr = head;
				while((null != curr) && (index < pos))
				{
					prev = curr;
					index++;
					curr = curr.next;
				}

				if(pos != index)
				{
					throw new RuntimeException("Out of bounds");
				}

				prev.next = node;
				node.next = curr;
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
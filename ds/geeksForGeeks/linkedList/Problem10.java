/*
	Given a Linked List and a number n, write a function that returns the value at the n’th node from the end of the Linked List.
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
		System.out.println(getFromEnd(head, 0));

		LinkedNode head1 = construct(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(getFromEnd(head1, 3));

		LinkedNode head2 = construct(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(getFromEnd(head2, 5));

		LinkedNode head3 = construct(new int[]{1, 2, 3, 4, 5, 6});
		try
		{
			System.out.println(getFromEnd(head3, 7));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		

		LinkedNode head4 = construct(new int[]{1, 2, 3, 4, 5, 6});
		try
		{
			System.out.println(getFromEnd(head4, -4));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		

		LinkedNode head5 = construct(new int[]{});
		try
		{
			System.out.println(getFromEnd(head5, 6));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		LinkedNode head6 = construct(new int[]{1});
		System.out.println(getFromEnd(head6, 0));
		
	}

	public static int getFromEnd(LinkedNode head, int pos)
	{
		if(null == head)
		{
			throw new RuntimeException("Empty List");
		}
		else if(pos < 0)
		{
			throw new RuntimeException("Invalid Index");
		}
		else
		{
			int length = 0;
			LinkedNode curr = head;
			while(null != curr)
			{
				length++;
				curr = curr.next;
			}

			if(length <= pos)
			{
				throw new RuntimeException("Invalid Index");
			}
			else
			{
				pos = (length - pos - 1);

				curr = head;
				int index = 0;
				while((null != curr) && (index < pos))
				{
					curr = curr.next;
					index++;
				}
				return curr.val;
			}
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
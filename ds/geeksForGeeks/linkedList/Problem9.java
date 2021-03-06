/*
	Find nth node - Iterative
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
		System.out.println(get(head, 0));

		LinkedNode head1 = construct(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(get(head1, 3));

		LinkedNode head2 = construct(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(get(head2, 5));

		LinkedNode head3 = construct(new int[]{1, 2, 3, 4, 5, 6});
		try
		{
			System.out.println(get(head3, 7));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		

		LinkedNode head4 = construct(new int[]{1, 2, 3, 4, 5, 6});
		try
		{
			System.out.println(get(head4, -4));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		

		LinkedNode head5 = construct(new int[]{});
		try
		{
			System.out.println(get(head5, 7));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

	public static int get(LinkedNode head, int pos)
	{
		if(null == head)
		{
			throw new RuntimeException("Empty List");
		}
		else
		{
			if(pos < 0)
			{
				throw new RuntimeException("Invalid index");
			}
			else if(pos == 0)
			{
				return head.val;
			}
			else
			{
				LinkedNode curr = head;
				int index = 0;
				while((null != curr) && (index < pos))
				{
					curr = curr.next;
					index++;
				}

				if(null == curr)
				{
					throw new RuntimeException("Invalid index");
				}
				else
				{
					return curr.val;
				}
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
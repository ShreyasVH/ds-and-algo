/*
	Given a singly linked list and a key, count number of occurrences of given key in linked list. For example, if given linked list is 1->2->1->2->1->3->1 and given key is 1, then output should be 4.
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
		LinkedNode head = construct(new int[]{1, 2, 1, 2, 1, 3, 1});
		System.out.println(count(head, 1));

		LinkedNode head2 = construct(new int[]{1, 2, 1, 2, 1, 3, 1});
		System.out.println(count(head2, 2));

		LinkedNode head3 = construct(new int[]{1, 2, 1, 2, 1, 3, 1});
		System.out.println(count(head3, 5));

		LinkedNode head4 = construct(new int[]{});
		try
		{
			System.out.println(count(head4, 1));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

	public static int count(LinkedNode head, int key)
	{
		if(null == head)
		{
			throw new RuntimeException("Empty list");
		}
		else
		{
			LinkedNode rest = head.next;
			int count = ((head.val == key) ? 1 : 0);

			if(null == rest)
			{
				return count;
			}
			else
			{
				return (count + count(head.next, key));
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
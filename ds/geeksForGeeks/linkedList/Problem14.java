/*
	Write a function detectAndCountLoop() that checks whether a given Linked List contains loop and if loop is present then returns count of nodes in loop. For example, loop is present in below linked list and length of loop is 4. If loop is not present, then function should return 0.
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
		Solution s = new Solution();

		// LinkedNode first = new LinkedNode(1);
		// LinkedNode second = new LinkedNode(2);
		// LinkedNode third = new LinkedNode(3);
		// LinkedNode fourth = new LinkedNode(4);
		// LinkedNode fifth = new LinkedNode(5);

		// first.next = second;
		// second.next = third;
		// third.next = fourth;
		// fourth.next = fifth;
		// fifth.next = third;
		// System.out.println(s.length(first));

		LinkedNode first = new LinkedNode(1);
		LinkedNode second = new LinkedNode(2);
		LinkedNode third = new LinkedNode(3);
		LinkedNode fourth = new LinkedNode(4);
		LinkedNode fifth = new LinkedNode(5);

		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// fifth.next = third;
		System.out.println(s.length(first));
	}

	public int length(LinkedNode head)
	{
		int length = 0;

		boolean hasLoop = false;

		LinkedNode slow = head;
		LinkedNode fast = head;

		while((null != fast) && (null != fast.next))
		{
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast)
			{
				hasLoop = true;
				break;
			}
		}

		if(hasLoop)
		{
			LinkedNode cur = slow;

			do
			{
				length++;
				cur = cur.next;
			}
			while(cur != slow);
		}


		return length;
	}
}
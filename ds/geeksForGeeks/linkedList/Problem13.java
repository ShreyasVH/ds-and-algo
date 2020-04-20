/*
	Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.
*/
import java.util.Set;
import java.util.HashSet;
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
		// System.out.println(s.hasLoop(first));

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
		System.out.println(s.hasLoop(first));
	}

	public boolean hasLoop(LinkedNode head)
	{
		boolean hasLoop = false;
		Set<LinkedNode> hash = new HashSet<>();
		

		while(null != head)
		{
			if(hash.contains(head))
			{
				hasLoop = true;
				break;
			}
			hash.add(head);


			head = head.next;
		}

		return hasLoop;
	}
}
/*
	Time Complexity: O(n)
	Space Complexity: O(n)
*/
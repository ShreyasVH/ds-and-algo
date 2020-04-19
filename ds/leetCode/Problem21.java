/*
	Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

	Example:

	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
*/

class Solution
{
	public static class ListNode
	{
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(true)
        {
        	if(null == l1)
        	{
        		tail.next = l2;
        		break;
        	}
        	else if(null == l2)
        	{
        		tail.next = l1;
        		break;
        	}

        	if(l1.val <= l2.val)
        	{
        		tail.next = l1;
        		l1 = l1.next;
        	}
        	else
        	{
        		tail.next = l2;
        		l2 = l2.next;
        	}

        	tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	// ListNode l1 = s.construct(new int[]{1, 2, 4});
    	// ListNode l2 = s.construct(new int[]{3, 5});
    	// print(s.mergeTwoLists(l1, l2));

    	ListNode l1 = s.construct(new int[]{1, 2, 3});
    	ListNode l2 = s.construct(new int[]{4, 5});
    	print(s.mergeTwoLists(l1, l2));
    }

    public static ListNode construct(int[] array)
    {
    	ListNode head = null;
    	ListNode tail = null;

    	for(int i = 0; i < array.length; i++)
    	{
    		ListNode node = new ListNode(array[i]);
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

    public static void print(ListNode head)
    {
    	while(null != head)
    	{
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.println();
    }
}
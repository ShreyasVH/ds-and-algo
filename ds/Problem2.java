/*
	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
*/

public class Problem2
{
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);

		ListNode l2 = new ListNode(8);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(1);

		print(addTwoNumbers(l1, l2));
	}

	public static void print(ListNode l)
	{
		while(null != l)
		{
			System.out.print(l.val);
			l = l.next;
		}
		System.out.println("");
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
        ListNode result = null;
        ListNode tail = null;
        
        int carry = 0;
        while((null != l1) || (null != l2))
        {
            int num = carry;
            
            if(null != l1)
            {
                num += l1.val;
            }
            
            if(null != l2)
            {
                num += l2.val;
            }
            
            carry = (num / 10);
            
            ListNode resultNode = new ListNode(num % 10);
            
            if(null == result)
            {
                result = resultNode;
            }
            else
            {
                tail.next = resultNode;
            }
            tail = resultNode;

            if(null != l1)
            {
            	l1 = l1.next;
            }

            if(null != l2)
            {
            	l2 = l2.next;
            }
        }

        if(carry == 1)
        {
        	if(null != tail)
        	{
        		tail.next = new ListNode(1);
        	}
        }
        return result;
        
    }
}

class ListNode
{
	int val;
 	ListNode next;
 	ListNode(int x)
 	{
 		val = x;
	}
}
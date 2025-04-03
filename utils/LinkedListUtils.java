package utils;

import utils.LinkedListNode;

public class LinkedListUtils
{
    public static void print(LinkedListNode head)
	{
    	while(head != null)
    	{
    		System.out.print(head.val + " ");
            head = head.next;
    	}
    	System.out.println();
    }

    public static LinkedListNode getList(Object... elements)
    {
        LinkedListNode head = null;
        LinkedListNode tail = null;

        for(Object element: elements)
        {
            LinkedListNode node = new LinkedListNode(element);
            if(head == null)
            {
                head = node;
            }
            else
            {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }
}
package utils;

import utils.LinkedListNode;

public class LinkedListUtils
{
    public static void print(LinkedListNode head)
	{
        LinkedListNode current = head;
    	while(current != null)
    	{
            if(current != head)
            {
                System.out.print(" -> ");
            }
    		System.out.print(current.val);
            current = current.next;
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
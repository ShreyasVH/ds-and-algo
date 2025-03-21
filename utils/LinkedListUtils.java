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
}
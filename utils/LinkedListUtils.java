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

    public static void printCircularList(LinkedListNode head)
    {
        if(head == null)
        {
            return;
        }

        LinkedListNode current = head;
        do
        {
            if(current != head)
            {
                System.out.print(" -> ");
            }
            System.out.print(current.val);
            current = current.next;
        } while(current != head);
        System.out.print(" -> ");
        System.out.println(current.val);
    }

    public static void print(DoublyLinkedListNode head)
    {
        DoublyLinkedListNode current = head;
        while(current != null)
        {
            if(current != head)
            {
                System.out.print(" <-> ");
            }
            System.out.print(current.val);
            current = current.next;
        }
        System.out.println();
    }

    public static void printReverse(DoublyLinkedListNode head)
    {
        DoublyLinkedListNode tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }
        

        DoublyLinkedListNode current = tail;
        while(current != null)
        {
            if(current != tail)
            {
                System.out.print(" <-> ");
            }
            System.out.print(current.val);
            current = current.prev;
        }
        System.out.println();
    }

    public static DoublyLinkedListNode getDoublyLinkedList(Object... elements)
    {
        DoublyLinkedListNode head = null;
        DoublyLinkedListNode tail = null;

        for(Object element: elements)
        {
            DoublyLinkedListNode node = new DoublyLinkedListNode(element);
            if(head == null)
            {
                head = node;
            }
            else
            {
                tail.next = node;
            }
            node.prev = tail;
            tail = node;
        }

        return head;
    }
}
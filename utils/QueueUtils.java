package utils;

import java.util.Queue;

public class QueueUtils
{
    public static void print(Queue<Integer> q)
	{
    	for(int val: q)
    	{
    		System.out.print(val + " ");
    	}
    	System.out.println();
    }
}
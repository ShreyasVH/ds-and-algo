/*
Queue using Linked List


Implement a Queue using Linked List. 
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop an element from the queue and print the poped element)

Examples:

Input: Q = 5, Queries = 1 2 1 3 2 1 4 2
Output: 2 3 
Explanation: 
[1,2] queue will be 2
[1,3] queue will be 2,3
[2] poped element will be 2 the queue will be 3
[1, 4] queue will be 3, 4
[2] poped element will be 3 

Input: Q = 4, Queries = 1 2 2 2 1 3
Output: 2 -1
Explanation:
[1, 2] queue will be 2
[2]  poped element will be 2 then
    the queue will be empty. 
[2]  the queue is empty and hence -1
[1, 3] the queue will be 3
Constraints:
1 <= Q <= 100
1 <= x <= 100

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700210
{
    LinkedListNode front, rear;

	public static void main(String args[]) throws Exception
	{
		Problem700210 problem = new Problem700210();
        problem.push(2);
        problem.push(3);
        System.out.println(problem.pop());
        problem.push(4);
        System.out.println(problem.pop());

        System.out.println("---------------------------------------");

        problem = new Problem700210();
        problem.push(2);
        System.out.println(problem.pop());
        System.out.println(problem.pop());
        problem.push(3);
	}

	public void push(int x) {
        LinkedListNode node = new LinkedListNode(x);
        if(isEmpty())
        {
            front = node;
            rear = node;
        }
        else
        {
            rear.next = node;
            rear = rear.next;
        }
    }

    public int pop()
    {
        int val = -1;
        if(!isEmpty())
        {
            val = (int) front.val;
            LinkedListNode prevFront = front;
            front = front.next;
            prevFront.next = null;
        }

        return val;
    }

    public int peek()
    {
        int val = -1;
        if(!isEmpty())
        {
            val = (int) front.val;
        }
        return val;
    }

    public boolean isEmpty()
    {
        return front == null;
    }
}


/*
Time complexity: O(1)
Space complexity: O(1)
*/
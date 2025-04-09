/*
Queue Using Array

Implement a Queue using an Array. Queries in the Queue are of the following type:
(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop an element from the queue and print the popped element. If the queue is empty then return -1)

We just have to implement the functions push and pop and the driver code will handle the output.

Examples:

Input: Queries = 1 2 1 3 2 1 4 2
Output: 2 3
Explanation: For query 1 2 the queue will be {2} 1 3 the queue will be {2 3} 2   poped element will be 2 the queue will be {3} 1 4 the queue will be {3 4} 2 popped element will be 3 
Input: Queries = 1 3 2 2 1 4   
Output: 3 -1
Explanation: For query 1 3 the queue will be {3} 2 popped element will be 3 the queue will be empty 2 there is no element in the queue and hence -1 1 4 the queue will be {4}. 

Input: Queries = 1 3 2 2 1 3   
Output: 3 -1
Explanation: For query 1 3 the queue will be {3} 2 popped element will be 3 the queue will be empty 2 there is no element in the queue and hence -1 1 3 the queue will be {3} and hence -1 1 3 the queue will be {3}.
Constraints:
1 ≤ number of query≤ 10^5
0 ≤ x ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700211
{
    int[] arr;
    int front, rear;

    public Problem700211()
    {
        arr = new int[100000];
        front = -1;
        rear = -1;
    }

	public static void main(String args[]) throws Exception
    {
        Problem700211 problem = new Problem700211();
        problem.push(2);
        problem.push(3);
        System.out.println(problem.pop());
        problem.push(4);
        System.out.println(problem.pop());

        System.out.println("---------------------------------------");

        problem = new Problem700211();
        problem.push(2);
        System.out.println(problem.pop());
        System.out.println(problem.pop());
        System.out.println(problem.pop());
        problem.push(3);
    }

    public void push(int x) {
        if(isEmpty())
        {
            front = 0;
        }
        arr[++rear] = x;
    }

    public int pop()
    {
        int ele = -1;

        if(!isEmpty())
        {
            ele = arr[front];

            for(int i = front; i < rear; i++)
            {
                arr[i] = arr[i + 1];
            }
            arr[rear--] = 0;
        }

        return ele;
    }

    public int peek()
    {
        int ele = -1;

        if(!isEmpty())
        {
            ele = arr[front];
        }

        return ele;
    }

    public boolean isEmpty()
    {
        return rear == -1;
    }
}


/*
Time complexity: 
Space complexity: 
*/
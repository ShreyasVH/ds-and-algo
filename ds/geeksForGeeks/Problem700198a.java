/*
Stack using two queues

Implement a Stack using two queues q1 and q2.

Examples:

Input:
push(2)
push(3)
pop()
push(4)
pop()
Output: 3 4
Explanation:
push(2) stack will be [2]
push(3) stack will be [2 3]
pop()   popped element will be 3 the stack will be [2] 
push(4) the stack will be [2 4]
pop()   popped element will be 4  
Input:
push(2)
pop()
pop()
push(3)
Output: 2 -1
Explanation:
push( 2 ) stack will be [ 2 ]
pop( ) popped element will be 2
pop( ) stack is empty so popped element will be -1
push( ) stack will be [ 3 ]
Constraints:
1<=Number of queries<=100
1<= size of stack<=100

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700198a
{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String args[]) throws Exception
    {
        Problem700198a problem = new Problem700198a();
        problem.push(2);
        problem.push(3);
        System.out.println(problem.pop());
        problem.push(4);
        System.out.println(problem.pop());

        System.out.println("-------------------------");
        
        problem = new Problem700198a();
        problem.push(2);
        System.out.println(problem.pop());
        System.out.println(problem.peek());
        System.out.println(problem.pop());
        problem.push(3);
    }

    public void push(int x)
    {
        q2.offer(x);
        while(!q1.isEmpty())
        {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop()
    {
        int ele = -1;
        if(!q1.isEmpty())
        {
            ele = q1.poll();
        }

        return ele;
    }

    public int peek()
    {
        int ele = -1;
        if(!q1.isEmpty())
        {
            ele = q1.peek();
        }

        return ele;
    }

    public boolean empty()
    {
        return q1.isEmpty();
    }
}


/*
Time complexity: 
Space complexity: 
*/
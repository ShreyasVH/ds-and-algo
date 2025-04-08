/*
Queue using two Stacks

Implement a Queue using 2 stacks s1 and s2 .
A Query q is of 2 Types
(i) 1 x (a query of this type means  pushing 'x' into the queue)
(ii) 2   (a query of this type means to pop element from queue and print the poped element)

Note : If there is no element return -1 as answer while popping.

Examples :

Input: q=5, queries[][]=[[1, 2], [1, 3], [2], [1, 4], [2]]
Output: [2, 3]
Explanation: 
In the first testcase
[1 2] the queue will be [2]
[1 3] the queue will be [2 3]
[2]   poped element will be 2 the queue 
will be [3]
[1 4] the queue will be [3 4]
[2 ]  poped element will be 3.

Input: q = 4, queries[][] = [[1, 2], [2], [2], [1, 4]]
Output: [2, -1]
Explanation: 
In the second testcase 
[1, 2] the queue will be [2]
[2]   poped element will be [2] and 
    then the queue will be empty
[2]   the queue is empty and hence -1
[1, 4] the queue will be [4].
Constraints:
1 <= q <= 100
1 <= x <= 100

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700195
{
    Stack<Integer> s1;
    Stack<Integer> s2;

    public Problem700195()
    {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }


	public static void main(String args[]) throws Exception
	{
		Problem700195 problem = new Problem700195();
        problem.push(2);
        problem.push(3);
        System.out.println(problem.pop());
        problem.push(4);
        System.out.println(problem.pop());

        System.out.println("--------------");

        problem = new Problem700195();
        problem.push(2);
        System.out.println(problem.pop());
        System.out.println(problem.pop());
        problem.push(4);
	}

	public void push(int x) {
        s1.push(x);
    }

    public int pop()
    {
        if(s2.empty())
        {
            while(!s1.empty())
            {
                s2.push(s1.pop());
            }
        }

        int ele = -1;
        if(!s2.empty())
        {
            ele = s2.pop();
        }
        return ele;
    }

    public int peek()
    {
        if(s2.empty())
        {
            while(!s1.empty())
            {
                s2.push(s1.pop());
            }
        }

        int ele = -1;
        if(!s2.empty())
        {
            ele = s2.peek();
        }
        return ele;
    }

    public boolean empty()
    {
        return s1.empty() && s2.empty();
    }
}


/*
Time complexity: 
Space complexity: 
*/
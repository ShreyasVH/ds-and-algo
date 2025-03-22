/*
Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
 

Follow-up: Can you implement the stack using only one queue?

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem37
{
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;


        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        
        public void push(int x) {
            q1.add(x);
        }
        
        public int pop() {
            while(q1.size() > 1)
            {
                q2.add(q1.poll());
            }
            int val = q1.poll();

            Queue<Integer> temp = q2;
            q2 = q1;
            q1 = temp;

            return val;
        }
        
        public int top() {
            while(q1.size() > 1)
            {
                q2.add(q1.poll());
            }

            int val = q1.peek();
            q2.add(q1.poll());

            Queue<Integer> temp = q2;
            q2 = q1;
            q1 = temp;

            return val;
        }
        
        public boolean empty() {
            return q1.isEmpty();
        }
    }


	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        clazz.getMethod("execute").invoke(problem);
	}

	public void execute() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}


/*
Time complexity: 
    push - O(1)
    pop  - O(n)
    top - O(n)
    empty - O(1)
Space complexity: O(n) 
*/
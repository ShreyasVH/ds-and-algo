/*
Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem33
{
    class MinStack {
        Stack<int[]> stack;

        public MinStack() {
            stack = new Stack<>();
        }
        
        public void push(int val) {
            int min = val;
            if(!stack.isEmpty())
            {
                min = Math.min(val, stack.peek()[1]);
            }
            stack.push(new int[]{val, min});
        }
        
        public void pop() {
            stack.pop();
        }
        
        public int top() {
            int[] item = stack.peek();
            return item[0];
        }
        
        public int getMin() {
            int[] item = stack.peek();
            return item[1];
        }
    }


	public static void main(String args[]) throws Exception
	{
        Problem33 problem = new Problem33();
        problem.execute();
		
	}

    public void execute()
    {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin() + " ");
        stack.pop();
        System.out.println(stack.top() + " ");
        System.out.println(stack.getMin() + " ");
    }
}


/*
Time complexity: O(1)
Space complexity: O(n)
*/
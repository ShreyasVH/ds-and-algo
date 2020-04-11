/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
     

    Example:

    Solution Solution = new Solution();
    Solution.push(-2);
    Solution.push(0);
    Solution.push(-3);
    Solution.getMin();   --> Returns -3.
    Solution.pop();
    Solution.top();      --> Returns 0.
    Solution.getMin();   --> Returns -2.
*/
import java.util.Stack;
class Solution {

    /** initialize your data structure here. */
    private Stack<Integer> s;
    private int min = Integer.MAX_VALUE;

    public Solution()
    {
        s = new Stack<>();
    }
    
    public void push(int x)
    {
        if(x <= this.min)
        {
            s.push(this.min);
            this.min = x;
        }

        s.push(x);
    }
    
    public void pop()
    {
        if(s.pop() == this.min)
        {
            this.min = s.pop();
        }
    }
    
    public int top()
    {
        return s.peek();
    }
    
    public int getMin()
    {
        return this.min;
    }

    public static void main(String[] args)
    {
        Solution stack = new Solution();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        // stack.print();
        System.out.println(stack.getMin());
        stack.pop();
        // stack.print();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
/*
    Time Complexity: O(1)
    Space Comlexity: O(n) Worst case when elements are added in decreasing order
*/
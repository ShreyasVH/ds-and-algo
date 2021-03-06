/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
     

    Example:

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.
*/
import java.util.List;
import java.util.ArrayList;
class MinStack {

    /** initialize your data structure here. */
    private Node head;

    public MinStack()
    {
        
    }
    
    public void push(int x)
    {
        if(null == this.head)
        {
            this.head = new Node(x, x, null);
        }
        else
        {
            this.head = new Node(x, Integer.min(x, this.head.min), this.head);
        }
    }
    
    public void pop()
    {
        this.head = this.head.next;
    }
    
    public int top()
    {
        return this.head.val;
    }
    
    public int getMin()
    {
        return this.head.min;
    }

    private class Node
    {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next)
        {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args)
    {
        MinStack stack = new MinStack();
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
    Space Comlexity: O(n)
*/
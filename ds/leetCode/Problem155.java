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
import java.util.List;
import java.util.ArrayList;
class Solution {

    /** initialize your data structure here. */
    private final List<Integer> data;
    private final List<Integer> temp;

    public Solution()
    {
        this.data = new ArrayList<>();
        this.temp = new ArrayList<>();
    }
    
    public void push(int x)
    {
        this.data.add(x);

        if(this.temp.size() == 0)
        {
        	this.temp.add(x);
        }
        else
        {
        	this.temp.add(Integer.min(x, this.temp.get(this.temp.size() - 1)));
        }
    }
    
    public void pop()
    {
        if(this.data.size() > 0)
        {
        	this.data.remove(this.data.size() - 1);
        	this.temp.remove(this.temp.size() - 1);
        }
    }
    
    public int top()
    {
    	int top = -1;
        if(this.data.size() > 0)
        {
        	top = this.data.get(this.data.size() - 1);
        }
        return top;
    }
    
    public int getMin()
    {
        int min = -1;
        if(this.temp.size() > 0)
        {
        	min = this.temp.get(this.temp.size() - 1);
        }
        return min;
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
	Space Comlexity: O(n)
*/
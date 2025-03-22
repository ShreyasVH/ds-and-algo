/*
Given a stack of integers sort them in ascending order

Example: 

input: [34, 4, 31, 98, 92, 23]

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem36
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(4);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        print((Stack) clazz.getMethod("stackSort", Stack.class).invoke(problem, stack));
	}

	public Stack<Integer> stackSort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty())
        {
            int val = stack.pop();

            while(!temp.isEmpty() && temp.peek() < val)
            {
                stack.push(temp.pop());
            }

            temp.push(val);
        }

        return temp;
    }

    public static void print(Stack<Integer> stack)
    {
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}


/*
Time complexity: best case O(n)
                    worst case O(n2) [if originalstack is already sorted]
Space complexity: O(n)
*/
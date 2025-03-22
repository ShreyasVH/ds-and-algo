/*
Reverse first k elements of a queue


*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem39
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        int k = 3;
        QueueUtils.print((Queue) clazz.getMethod("reverse", Queue.class, int.class).invoke(problem, q, k));
	}

	public Queue<Integer> reverse(Queue<Integer> q, int k) {
        int n = q.size();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < k; i++)
        {
            stack.push(q.poll());
        }

        while(!stack.isEmpty())
        {
            q.add(stack.pop());
        }

        for(int i = k; i < n; i++)
        {
            q.add(q.poll());
        }

        return q;
    }
}


/*
Time complexity: O(n)
Space complexity: O(k)
*/
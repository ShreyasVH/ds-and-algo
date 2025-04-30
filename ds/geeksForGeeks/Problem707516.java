/*
Course Schedule

There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have prerequisites[][] tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick to finish all tasks.
Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. Returning any correct order will give the output as true, whereas any invalid order will give the output false. 

Examples:

Input: n = 2, prerequisites[][] = [[1, 0]]
Output: true
Explanation: Only possible order is [0, 1].

Input: n = 4, prerequisites[][] = [[1, 0], [2, 0], [3, 1], [3, 2]]
Output: true
Explanation: There are a total of 4 tasks to pick. To pick task 3 you should have finished both tasks 1 and 2. Both tasks 1 and 2 should be pick after you finished task 0. So one correct task order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3]. Returning any of these order will result in an output of true.
Constraints:
1 ≤ n ≤ 10^5
0 ≤ prerequisites[i][0], prerequisites[i][1] < n
All prerequisite pairs are unique
prerequisites[i][0] ≠ prerequisites[i][1]

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem707516
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int n = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println((ArrayList<Integer>) clazz.getMethod("findOrder", int.class, int[][].class).invoke(problem, n, prerequisites));

        System.out.println("-------------------------------------");

        n = 4;
        prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println((ArrayList<Integer>) clazz.getMethod("findOrder", int.class, int[][].class).invoke(problem, n, prerequisites));
	}

	public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        int edgeCount = prerequisites.length;
        for(int i = 0; i < edgeCount; i++)
        {
            int[] edge = prerequisites[i];
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        boolean[] visited = new boolean[n];
        ArrayList<Integer> order = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] recStack = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                if(findOrder(i, adj, visited, stack, recStack))
                {
                    return new ArrayList<>();
                }
            }
        }

        while(!stack.empty())
        {
            order.add(stack.pop());
        }

        return order;
    }

    public static boolean findOrder(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for(int neighbor: adj.get(node))
        {
            if(!visited[neighbor])
            {
                if(findOrder(neighbor, adj, visited, stack, recStack))
                {
                    return true;
                }
            }
            else if(recStack[neighbor])
            {
                return true;
            }
        }

        stack.add(node);
        recStack[node] = false;
        return false;
    }
}


/*
Time complexity: 
Space complexity: 
*/
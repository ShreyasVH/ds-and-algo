/*
Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

*/

package ds.leetCode;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem207
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int n = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println((boolean) clazz.getMethod("canFinish", int.class, int[][].class).invoke(problem, n, prerequisites));

        System.out.println("-------------------------------------");

        n = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println((boolean) clazz.getMethod("canFinish", int.class, int[][].class).invoke(problem, n, prerequisites));
	}

	public boolean canFinish(int n, int[][] prerequisites) {
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
        boolean[] recStack = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                if(hasCycle(i, adj, visited, recStack))
                {
                    return false;
                }
            }
        }
        

        return true;
    }

    public boolean hasCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for(int neighbor: adj.get(node))
        {
            if(!visited[neighbor])
            {
                if(hasCycle(neighbor, adj, visited, recStack))
                {
                    return true;
                }
            }
            else if(recStack[neighbor])
            {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }
}


/*
Time complexity: 
Space complexity: 
*/
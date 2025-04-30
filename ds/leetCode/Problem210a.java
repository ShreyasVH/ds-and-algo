/*
Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.

*/

package ds.leetCode;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem210a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        ArrayUtils.print((int []) clazz.getMethod("findOrder", int.class, int[][].class).invoke(problem, numCourses, prerequisites));

        System.out.println("-----------------------------------------");

        numCourses = 4;
        prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        ArrayUtils.print((int []) clazz.getMethod("findOrder", int.class, int[][].class).invoke(problem, numCourses, prerequisites));

        System.out.println("-----------------------------------------");

        numCourses = 1;
        prerequisites = new int[][]{};
        ArrayUtils.print((int []) clazz.getMethod("findOrder", int.class, int[][].class).invoke(problem, numCourses, prerequisites));

        System.out.println("-----------------------------------------");

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        ArrayUtils.print((int []) clazz.getMethod("findOrder", int.class, int[][].class).invoke(problem, numCourses, prerequisites));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        int edgeCount = prerequisites.length;
        for(int i = 0; i < edgeCount; i++)
        {
            int[] edge = prerequisites[i];
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
        {
            if(inDegree[i] == 0)
            {
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while(!q.isEmpty())
        {
            Integer curr = q.poll();
            order[index++] = curr;

            for(int neightbor: adj.get(curr))
            {
                inDegree[neightbor]--;
                if(inDegree[neightbor] == 0)
                {
                    q.offer(neightbor);
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}


/*
Time complexity: 
Space complexity: 
*/
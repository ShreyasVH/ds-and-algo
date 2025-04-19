/*
Shortest path from 1 to n

Consider a directed graph whose vertices are numbered from 1 to n. There is an edge from a vertex i to a vertex j if and only if either j = i + 1 or j = 3 * i. The task is to find the minimum number of edges in a path from vertex 1 to vertex n.

Examples :

Input: n = 9
Output: 2
Explanation: Many paths are possible from 1 to 9. Shortest one possible is, 1 -> 3 -> 9, of length 2.

Input: n = 4
Output: 2
Explanation: Possible paths from 1 to 4 are, 1 -> 2 -> 3 -> 4 and 1 -> 3 -> 4. Second path of length 2 is the shortest.

Input: n = 15
Output: 4

Constraints:
1 ≤ n ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem704041
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int n = 9;
        System.out.println((int) clazz.getMethod("minStep", int.class).invoke(problem, n));

        System.out.println("---------------------");

        n = 4;
        System.out.println((int) clazz.getMethod("minStep", int.class).invoke(problem, n));

        System.out.println("---------------------");

        n = 15;
        System.out.println((int) clazz.getMethod("minStep", int.class).invoke(problem, n));
	}

	public int minStep(int n)
    {
        if(n == 1)
        {
            return 0;
        }

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        distance[1] = 0;

        while(!q.isEmpty())
        {
            int curr = q.poll();

            int next1 = curr + 1;
            int next2 = curr * 3;

            if(next1 <= n && !visited[next1])
            {
                q.offer(next1);
                visited[next1] = true;
                distance[next1] = distance[curr] + 1;
            }

            if(next2 <= n && !visited[next2])
            {
                q.offer(next2);
                visited[next2] = true;
                distance[next2] = distance[curr] + 1;
            }

            if(visited[n])
            {
                break;
            }
        }

        return distance[n];
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
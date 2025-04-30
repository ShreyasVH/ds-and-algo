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
        boolean[] visited = new boolean[n + 1]; 
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty())
        {
            int[] data = q.poll();
            int pos = data[0];
            int moves = data[1];

            if(pos == n)
            {
                return moves;
            }

            int nextPos1 = pos + 1;
            int nextPos2 = pos * 3;
            int[] nextPosArr = {nextPos1, nextPos2};
            for(int nextPos: nextPosArr)
            {
                if(nextPos > n)
                {
                    continue;
                }

                if(!visited[nextPos])
                {
                    visited[nextPos] = true;
                    q.offer(new int[]{nextPos, moves + 1});
                }
            }
        }

        return -1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
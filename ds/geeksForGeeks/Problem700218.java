/*
Directed Graph Cycle

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]

Output: true
Explanation: The diagram clearly shows a cycle 0 → 2 → 0

Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]

Output: false
Explanation: no cycle in the graph
Constraints:
1 ≤ V, E ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700218
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println((boolean) clazz.getMethod("isCyclic", int.class, int[][].class).invoke(problem, V, edges));

        System.out.println("------------------------------------");

        V = 4;
        edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println((boolean) clazz.getMethod("isCyclic", int.class, int[][].class).invoke(problem, V, edges));
	}

	public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        int edgeCount = edges.length;
        for(int i = 0; i < edgeCount; i++)
        {
            int[] edge = edges[i];
            int source = edge[0];
            int destination = edge[1];

            adj.get(source).add(destination);
        }

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                if(isCyclic(i, adj, visited, recStack))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCyclic(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack){
        visited[node] = true;
        recStack[node] = true;

        for(int neighbour: adj.get(node))
        {
            if(!visited[neighbour])
            {
                if(isCyclic(neighbour, adj, visited, recStack))
                {
                    return true;
                }
            }
            else if(recStack[neighbour])
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
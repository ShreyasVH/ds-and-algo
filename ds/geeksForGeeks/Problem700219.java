/*
Undirected Graph Cycle

Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

Examples:

Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation: 
 
1 -> 2 -> 0 -> 1 is a cycle.

Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation: 
 
No cycle in the graph.

Constraints:
1 ≤ V ≤ 10^5
1 ≤ E = edges.size() ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700219
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println((boolean) clazz.getMethod("isCycle", int.class, int[][].class).invoke(problem, V, edges));

        System.out.println("----------------------------------");

        V = 4;
        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}};
        System.out.println((boolean) clazz.getMethod("isCycle", int.class, int[][].class).invoke(problem, V, edges));
	}

	public boolean isCycle(int V, int[][] edges) {
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
            adj.get(destination).add(source);
        }

        boolean[] visited = new boolean[V];


        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                if(dfs(i, -1, adj, visited))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited)
    {
        visited[node] = true;

        for(int neighbour: adj.get(node))
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour, node, adj, visited))
                {
                    return true;
                }
            }
            else if(neighbour != parent)
            {
                return true;
            }
        }

        return false;
    }
}


/*
Time complexity: 
Space complexity: 
*/
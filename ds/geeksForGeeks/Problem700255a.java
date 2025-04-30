/*
Topological sort

Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]

Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
Constraints:
2  ≤  V  ≤  103
1  ≤  E = edges.size()  ≤  (V * (V - 1)) / 2

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700255a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 4;
        int E = 3;
        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println((ArrayList<Integer>) clazz.getMethod("topoSort", int.class, int[][].class).invoke(problem, V, edges));

        System.out.println("-------------------------------------");

        V = 6;
        E = 6;
        edges = new int[][]{{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5,2}};
        System.out.println((ArrayList<Integer>) clazz.getMethod("topoSort", int.class, int[][].class).invoke(problem, V, edges));
	}

	public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[V];
        int edgeCount = edges.length;
        for(int i = 0; i < edgeCount; i++)
        {
            int[] edge = edges[i];
            int source = edge[0];
            int destination = edge[1];

            adj.get(source).add(destination);
            inDegree[destination]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++)
        {
            if(inDegree[i] == 0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            Integer curr = q.poll();
            result.add(curr);

            for(int neighbor: adj.get(curr))
            {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0)
                {
                    q.offer(neighbor);
                }
            }
        }

        return result;
    }
}


/*
Time complexity: 
Space complexity: 
*/
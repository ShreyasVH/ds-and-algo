/*
Count the paths

Given a Directed acyclic graph(DAG) with V nodes labeled from 0 to V-1. Given edges, start, and destination, count the number of ways to reach from start to destination. There is a directed Edge from vertex edges[i][0] to the vertex edges[i][1]. Your task is to find the number of ways to reach from start to destination.

Examples :

Input: edges = [[0,1],[0,3],[2,0],[2,1],[1,3]], V = 4, start = 2, destination = 3
Output: 3
Explanation: There are three ways to reach at 3 from 2. These are : 2->1->3 , 2->0->3 and 2->0->1->3.

Input: edges = [[0,1]], V = 2, start = 0, destination = 1
Output: 1
Explanation: There is only one way to reach at 1 from 0 that is : 0->1.

Constraints:
1 <= V <= 15
0 <= start, destination, edges[i][0], edges[i][1] <= V-1

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem705707
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 4;
        int start = 2;
        int destination = 3;
        int[][] edges = {{0,1}, {0,3}, {2,0}, {2,1}, {1,3}};
        System.out.println((int) clazz.getMethod("possible_paths", int[][].class, int.class, int.class, int.class).invoke(problem, edges, V, start, destination));

        System.out.println("--------------------------------------");

        V = 4;
        start = 0;
        destination = 1;
        edges = new int[][]{{0,1}};
        System.out.println((int) clazz.getMethod("possible_paths", int[][].class, int.class, int.class, int.class).invoke(problem, edges, V, start, destination));
	}

	public int possible_paths(int[][] edges, int n, int start, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        int edgeCount = edges.length;
        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges[i];

            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
        }

        Integer[] memo = new Integer[n];

        return dfs(start, destination, graph, memo);
    }

    public int dfs(int node, int dest, List<List<Integer>> adj, Integer[] memo)
    {
        if(node == dest)
        {
            return 1;
        }

        if(memo[node] != null)
        {
            return memo[node];
        }

        int totalPaths = 0;
        for(int neighbour: adj.get(node))
        {
            totalPaths += dfs(neighbour, dest, adj, memo);
        }

        memo[node] = totalPaths;
        return totalPaths;
    }
}


/*
Time complexity: O(E + V)
Space complexity: O(V)
*/
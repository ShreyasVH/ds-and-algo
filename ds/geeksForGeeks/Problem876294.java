/*
Connected Components in an Undirected Graph

Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v.

Your task is to return a list of all connected components. Each connected component should be represented as a list of its vertices, with all components returned in a collection where each component is listed separately.

Note: You can return the components in any order, driver code will print the components in sorted order.

Examples :

Input: V = 5, edges[][] = [[0, 1], [2, 1], [3, 4]]
Output: [[0, 1, 2], [3, 4]]
Explanation:

Input: V = 7, edges[][] = [[0, 1], [6, 0], [2, 4], [2, 3], [3, 4]]
Output: [[0, 1, 6], [2, 3, 4], [5]]
Explanation:

Constraints:
1 ≤ V ≤ 10^5
1 ≤ edges.size() ≤ 10^5
0 <= edges[i][0], edges[i][1] < V
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem876294
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 5;
        int[][] edges = {{0, 1}, {2, 1}, {3, 4}};
        System.out.println((ArrayList<ArrayList<Integer>>) clazz.getMethod("getComponents", int.class, int[][].class).invoke(problem, V, edges));

        System.out.println("-------------------------------------");

        V = 7;
        edges = new int[][]{{0, 1}, {6, 0}, {2, 4}, {2, 3}, {3, 4}};
        System.out.println((ArrayList<ArrayList<Integer>>) clazz.getMethod("getComponents", int.class, int[][].class).invoke(problem, V, edges));
	}

	public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(V);

        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>(V));
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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                Collections.sort(component);
                result.add(component);
            }
        }

        return result;
    }

    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> component)
    {
        visited[node] = true;
        component.add(node);

        for(int neighbour: adj.get(node))
        {
            if(!visited[neighbour])
            {
                dfs(neighbour, adj, visited, component);
            }
        }
    }
}


/*
Time complexity: O(V + E + V log V)
Space complexity: O(V + E)
*/
/*
Print adjacency list

Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.

Example 1:

Input:
V = 5, E = 7
edges = [[0,1], [0,4], [4,1], [4,3], [1,3], [1,2], [3,2]]

Output: 
[[1,4], [0,2,3,4], [1,3], [1,2,4], [0,1,3]]
Explanation:
Node 0 is connected to 1 and 4.
Node 1 is connected to 0,2,3 and 4.
Node 2 is connected to 1 and 3.
Node 3 is connected to 1,2 and 4.
Node 4 is connected to 0,1 and 3.

Example 2:

Input:
V = 4, E = 3
edges = [[0,3], [0,2], [2,1]]
  
Output: 
[[2,3], [2], [0,1], [0]]
Explanation:
Node 0 is connected to 2 and 3.
Node 1 is only connected to 2.
Node 2 is connected to 0 and 1.
Node 3 is only connected to 0.
Constraints:
1 ≤ V, E ≤ 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem701247
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 5;
        int[][] edges = {{0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}};
        System.out.println((List<List<Integer>>) clazz.getMethod("printGraph", int.class, int[][].class).invoke(problem, V, edges));

        System.out.println("------------------------");

        V = 4;
        edges = new int[][]{{0,3}, {0,2}, {2,1}};
        System.out.println((List<List<Integer>>) clazz.getMethod("printGraph", int.class, int[][].class).invoke(problem, V, edges));
	}

	public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int edgeCount = edges.length;
        for(int i = 0; i < edgeCount; i++) {
            int[] edge = edges[i];
            int source = edge[0];
            int dest = edge[1];

            
            adj.get(source).add(dest);
            adj.get(dest).add(source);
        }

        return adj;
    }
}


/*
Time complexity: O(V + E)
Space complexity: O(V + E)
*/
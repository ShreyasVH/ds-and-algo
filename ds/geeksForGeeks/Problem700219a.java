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

public class Problem700219a
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

        int[] rank = new int[V];
        int[] parent = new int[V];
        for(int i = 0; i < V; i++)
        {
            parent[i] = i;
        }

        int edgeCount = edges.length;
        for(int i = 0; i < edgeCount; i++)
        {
            int[] edge = edges[i];
            int source = edge[0];
            int dest = edge[1];

            int sourceRoot = find(source, parent);
            int destRoot = find(dest, parent);

            if(sourceRoot == destRoot)
            {
                return true;
            }

            union(sourceRoot, destRoot, parent, rank);
        }
        return false;
    }

    public int find(int node, int[] parent)
    {
        if(parent[node] != node)
        {
            parent[node] = find(parent[node], parent);
        }

        return parent[node];
    }

    public void union(int a, int b, int[] parent, int[] rank)
    {
        if(rank[a] < rank[b])
        {
            parent[a] = b;
        }
        else if(rank[a] > rank[b])
        {
            parent[b] = a;
        }
        else
        {
            parent[b] = a;
            rank[a]++;
        }
    }
}


/*
Time complexity: 
Space complexity: 
*/
/*

You are given an undirected graph of N nodes (numbered from 0 to N-1) and M edges. Return 1 if the graph is a tree, else return 0.

Note: The input graph can have self-loops and multiple edges.

Example 1:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [1, 3]]
Output: 
1
Explanation: 
Every node is reachable and the graph has no loops, so it is a tree

Example 2:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [2, 0]]
Output: 
0
Explanation: 
3 is not connected to any node and there is a loop 0->1->2->0, so it is not a tree.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isTree() which takes the integer N (the number nodes in the input graph) and the edges representing the graph as input parameters and returns 1 if the input graph is a tree, else 0.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 2*10^5
0 <= M <= 2*10^5
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem710138
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int n = 4;
        int m = 3;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}};
        ArrayList<ArrayList<Integer>> egdeList = (ArrayList<ArrayList<Integer>>) clazz.getMethod("toList", int[][].class).invoke(problem, (Object) edges);
        System.out.println((boolean) clazz.getMethod("isTree", int.class, int.class, ArrayList.class).invoke(problem, n, m, egdeList));

        System.out.println("-------------------------------------------------");

        n = 4;
        m = 3;
        edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        egdeList = (ArrayList<ArrayList<Integer>>) clazz.getMethod("toList", int[][].class).invoke(problem, (Object) edges);
        System.out.println((boolean) clazz.getMethod("isTree", int.class, int.class, ArrayList.class).invoke(problem, n, m, egdeList));
	}



	public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        boolean[] visited = new boolean[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }


        int edgeCount = edges.size();
        for(int i = 0; i < edgeCount; i++)
        {
            ArrayList<Integer> edge = edges.get(i);

            int source = edge.get(0);
            int dest = edge.get(1);

            adj.get(source).add(dest);
            adj.get(dest).add(source);
        }

        if(hasCycle(0, -1, visited, adj))
        {
            return false;
        }

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = true;

        for(int neighbour: adj.get(node))
        {
            if(!visited[neighbour])
            {
                if(hasCycle(neighbour, node, visited, adj))
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

    public ArrayList<ArrayList<Integer>> toList(int[][] arr)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int rowCount = arr.length;
        for(int i = 0; i < rowCount; i++)
        {
            int[] row = arr[i];

            ArrayList<Integer> item = new ArrayList<>();
            item.add(row[0]);
            item.add(row[1]);

            list.add(item);
        }

        return list;
    }
}


/*
Time complexity: 
Space complexity: 
*/
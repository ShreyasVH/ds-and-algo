/*
DFS of Graph

Given a connected undirected graph containing V vertices represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list, and return a list containing the DFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 4, 3, 1]
Explanation: Starting from 0, the DFS traversal proceeds as follows:
Visit 0 → Output: 0 
Visit 2 (the first neighbor of 0) → Output: 0, 2 
Visit 4 (the first neighbor of 2) → Output: 0, 2, 4 
Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3 
Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1

Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the DFS traversal proceeds as follows: 
Visit 0 → Output: 0 
Visit 1 (the first neighbor of 0) → Output: 0, 1 
Visit 2 (the first neighbor of 1) → Output: 0, 1, 2 
Visit 3 (the first neighbor of 2) → Output: 0, 1, 2, 3 
Backtrack to 2 and visit 4 → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ V = adj.size() ≤ 10^4
1 ≤ adj[i][j] ≤ 10^4



*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.util.stream.Collectors;
import java.lang.reflect.Constructor;

public class Problem700203
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[][] arr = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        ArrayList<ArrayList<Integer>> adj = Arrays.stream(arr)
            .map(row -> new ArrayList<>(Arrays.stream(row).boxed().collect(Collectors.toList())))
            .collect(Collectors.toCollection(ArrayList::new));
        System.out.println((ArrayList) clazz.getMethod("dfs", ArrayList.class).invoke(problem, adj));

        System.out.println("----------------------------------");

        arr = new int[][]{{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        adj = Arrays.stream(arr)
            .map(row -> new ArrayList<>(Arrays.stream(row).boxed().collect(Collectors.toList())))
            .collect(Collectors.toCollection(ArrayList::new));
        System.out.println((ArrayList) clazz.getMethod("dfs", ArrayList.class).invoke(problem, adj));
	}

	public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(adj, 0, new boolean[adj.size()], result);
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited, ArrayList<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);
        for(int neighbour: adj.get(vertex)) {
            if(!visited[neighbour])
            {
                dfs(adj, neighbour, visited, result);
            }
        }
    }
}


/*
Time complexity: 
Space complexity: 
*/
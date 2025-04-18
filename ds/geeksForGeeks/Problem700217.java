/*
BFS of graph

Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps: 
Visit 0 → Output: 0 
Visit 2 (first neighbor of 0) → Output: 0, 2 
Visit 3 (next neighbor of 0) → Output: 0, 2, 3 
Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4


Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal proceeds as follows: 
Visit 0 → Output: 0 
Visit 1 (the first neighbor of 0) → Output: 0, 1 
Visit 2 (the next neighbor of 0) → Output: 0, 1, 2 
Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3 
Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ V = adj.size() ≤ 10^4
1 ≤ adj[i][j] ≤ 10^4

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.util.stream.Collectors;
import java.lang.reflect.Constructor;

public class Problem700217
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
        System.out.println((ArrayList) clazz.getMethod("bfs", ArrayList.class).invoke(problem, adj));

        System.out.println("----------------------------------");

        arr = new int[][]{{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        adj = Arrays.stream(arr)
            .map(row -> new ArrayList<>(Arrays.stream(row).boxed().collect(Collectors.toList())))
            .collect(Collectors.toCollection(ArrayList::new));
        System.out.println((ArrayList) clazz.getMethod("bfs", ArrayList.class).invoke(problem, adj));
	}

	public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[adj.size()];
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty())
        {
            int vertex = q.poll();
            result.add(vertex);

            for(int neighbour: adj.get(vertex))
            {
                if(!visited[neighbour])
                {
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
        return result;
    }
}


/*
Time complexity: O(V + E)
Space complexity: O(V)
*/
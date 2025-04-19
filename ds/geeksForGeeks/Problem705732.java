/*
Sum of dependencies in a graph

Given a directed graph with V nodes and E edges, the graph's edges are represented as a 2D array, edges[][]. Each row in the array represents a directed edge (u, v), meaning there is a directed edge from node u to node v. If there is a directed edge from u to v, it means that u depends on v. The Number of Dependencies (NoD) for a node x is the total count of nodes that x depends upon.

Your task is to calculate the sum of the Number of Dependencies (NoD) for all nodes in the graph.

Examples:

Input: V = 4, E = 4, edges[][] = [[0,2],[0,3],[1,3],[2,3]]

Output: 4
Explanation: For the graph in diagram, A depends on C and D i.e. A's NoD is 2, B depends on D i.e. B's NoD is 1, C depends on D i.e. D's NoD is 1 and D depends on none. Hence answer is 2 + 1 + 1 + 0 = 4.

Input: V = 4, E = 3, edges[][] = [[0,3],[0,2],[0,1]]
Output: 3
Explanation: The sum of dependencies: 3 + 0 + 0 + 0 = 3.

Constraints:
1 <= V <= 10^5
1 <= E <= 10^5
edges.size() = E
edges[i].size() = 2
0 <= edges[i][j] <= V-1

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem705732
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 4;
        int[][] edges = {{0,2}, {0,3}, {1,3}, {2,3}};
        System.out.println((int) clazz.getMethod("sumOfDependencies", int.class, int[][].class).invoke(problem, V, edges));

        System.out.println("---------------------------");

        V = 4;
        edges = new int[][]{{0,3}, {0,2}, {0,1}};
        System.out.println((int) clazz.getMethod("sumOfDependencies", int.class, int[][].class).invoke(problem, V, edges));
	}

	public int sumOfDependencies(int V, int[][] edges) {
        return edges.length;
    }
}


/*
Time complexity: 
Space complexity: 
*/
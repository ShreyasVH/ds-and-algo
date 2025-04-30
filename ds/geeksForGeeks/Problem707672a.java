/*
Clone an Undirected Graph

Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes, having a distinct label from 0 to n-1, where each adj[i] represents the list of vertices connected to vertex i.

Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.

class Node {
    val: integer
    neighbors: List[Node]
}
Your task is to complete the function cloneGraph( ) which takes a starting node of the graph as input and returns the copy of the given node as a reference to the cloned graph.

Note: If you return a correct copy of the given graph, then the driver code will print true; and if an incorrect copy is generated or when you return the original node, the driver code will print false.

Examples :

Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
Output: true
Explanation: 

As the cloned graph is identical to the original one the driver code will print true.

Input: n = 3, adjList[][] = [[1, 2], [0], [0]]
Output: true
Explanation: 

As the cloned graph is identical to the original one the driver code will print true.
Constraints:
1 ≤ n ≤ 10^4
0 ≤ no. of edges ≤ 10^5
0 ≤ adjList[i][j] < n
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem707672a
{
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }

	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int V = 4;
        int[][] edges = {{1, 2}, {0, 2}, {0, 1, 3}, {2}};
        Node graph = (Node) clazz.getMethod("getGraph", int.class, int[][].class).invoke(problem, V, (Object) edges);
        print(V, graph);
        System.out.println();
        print(V, (Node) clazz.getMethod("cloneGraph", Node.class).invoke(problem, graph));

        System.out.println("-------------------------------------");

        V = 3;
        edges = new int[][]{{1, 2}, {0}, {0}};
        graph = (Node) clazz.getMethod("getGraph", int.class, int[][].class).invoke(problem, V, (Object) edges);
        print(V, graph);
        System.out.println();
        print(V, (Node) clazz.getMethod("cloneGraph", Node.class).invoke(problem, graph));
	}

    public Node getGraph(int V, int[][] adj)
    {
        Node[] nodes = new Node[V];

        for(int i = 0; i < V; i++)
        {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < V; i++)
        {
            int source = i;
            for(int destination: adj[i])
            {
                nodes[source].neighbors.add(nodes[destination]);
            }
        }

        return nodes[0];
    }

    public static void print(int V, Node graph)
    {
        boolean[] visited = new boolean[V];

        Queue<Node> q = new LinkedList<>();

        q.offer(graph);
        visited[graph.val] = true;

        while(!q.isEmpty())
        {
            Node curr = q.poll();

            System.out.print(curr.val + " -> ");

            for(Node neighbor: curr.neighbors)
            {
                System.out.print(neighbor.val + " ");
                if(!visited[neighbor.val])
                {
                    q.offer(neighbor);
                    visited[neighbor.val] = true;
                }
            }
            System.out.println();
        }
    }

	public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new Node(node.val));

        while(!q.isEmpty())
        {
            Node curr = q.poll();

            for(Node neighbor: curr.neighbors)
            {
                if(!visited.containsKey(neighbor))
                {
                    q.offer(neighbor);
                    visited.put(neighbor, new Node(neighbor.val));
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}


/*
Time complexity: 
Space complexity: 
*/
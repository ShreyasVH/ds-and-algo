/*
Union-Find

This problem is to implement disjoint set union. There will be 2 incomplete functions namely union and find. You have to complete these functions. 

Union: Join two subsets into a single set.
isConnected: Determine which subset a particular element is in. This can be used for determining if two elements are in same subset.

Example 1:

Input:
N = 5
q = 4
Queries = 
Union(1,3)
isConnected(1,2)
Union(1,5)
isConnected(3,5)
Output:
0
1
Explanation: Initially all nodes 1 2 3 4 5
are not connected. 
After Union(1,3), node 1 and 3 will be
connected.
When we do isConnected(1,2),  as node 1
and 2 are not connected it will return 0.
After Union(1,5), node 1 and 5 will be
connected.
When we do isConnected(3,5),  as node
1 and 3 are connected, and node 1 and 5
are connected, hence 3 and 5 are
connected. Thus it will return 1.

Example 2:

Input:
N = 5
q = 4
Queries = 
Union(1,4)
Union(1,5)
isConnected(2,3)
Union(3,4)
Output: 0
Your Task:

You have to complete the function union_() which merges the node1 and node2. You will also have to complete the function isConnected() which will return whether the two nodes are connected.

Note: Both function will contain two arrays par[] and ranks1[] along with two nodes. Initially par[i] = i and rank1[i] = 1 

Expected Time Complexity: O(N + Q).
Expected Auxiliary Space: O(1).

Constraints: 
1 <= N <= 10^5
1<= Q <= 10^5
1 <= node1, node2 <= N

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem701408
{
	public static void main(String args[]) throws Exception
	{

		Problem701408 problem = new Problem701408();
        int n = 5;
        int[] par = new int[n + 1];
        int[] rank = new int[n + 1];
        for(int i = 1; i <= n; i++)
        {
            par[i] = i;
        }
        problem.union_(1, 3, par, rank);
        System.out.println(problem.isConnected(1, 2, par, rank));
        problem.union_(1, 5, par, rank);
        System.out.println(problem.isConnected(3, 5, par, rank));

        System.out.println("-----------------------------------");

        problem = new Problem701408();
        n = 5;
        par = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1; i <= n; i++)
        {
            par[i] = i;
        }
        problem.union_(1, 4, par, rank);
        problem.union_(1, 5, par, rank);
        System.out.println(problem.isConnected(2, 3, par, rank));
        problem.union_(3, 4, par, rank);
	}

	public void union_(int a, int b, int par[], int rank[])
    {
        int rootA = find(a, par);
        int rootB = find(b, par);

        if(rootA == rootB)
        {
            return;
        }

        if(rank[rootA] < rank[rootB])
        {
            par[rootA] = rootB;
        }
        else if(rank[rootA] > rank[rootB])
        {
            par[rootB] = rootA;
        }
        else
        {
            par[rootB] = rootA;
            rank[rootA]++;
        }
    }

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        return find(a, par) == find(b, par);
    }

    public int find(int x, int[] par)
    {
        if(par[x] != x)
        {
            par[x] = find(par[x], par);
        }

        return par[x];
    }
}


/*
Time complexity: 
Space complexity: 
*/
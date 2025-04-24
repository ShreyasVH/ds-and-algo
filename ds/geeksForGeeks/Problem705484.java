/*
Snake and Ladder Problem

Given a 5x6 snakes and ladders board, find the minimum number of dice throws required to reach the destination or last cell (30th cell) from the source (1st cell).

You are given an integer N denoting the total number of snakes and ladders and an array arr[] of 2*N size where 2*i and (2*i + 1)th values denote the starting and ending point respectively of ith snake or ladder. The board looks like the following.
Note: Assume that you have complete control over the 6 sided dice. No ladder starts from 1st cell.


                                   

Example 1:

Input:
N = 8
arr[] = {3, 22, 5, 8, 11, 26, 20, 29, 
       17, 4, 19, 7, 27, 1, 21, 9}
Output: 3
Explanation:
The given board is the board shown
in the figure. For the above board 
output will be 3. 
a) For 1st throw get a 2. 
b) For 2nd throw get a 6.
c) For 3rd throw get a 2.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minThrow() which takes N and arr as input parameters and returns the minimum number of throws required to reach the end of the game.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 10
1 ≤ arr[i] ≤ 30  

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem705484
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int N = 8;
        int[] arr = {3, 22, 5, 8, 11, 26, 20, 29, 17, 4, 19, 7, 27, 1, 21, 9};
        System.out.println((int) clazz.getMethod("minThrow", int.class, int[].class).invoke(problem, N, arr));
	}

	public static int minThrow(int N, int arr[]){
        Queue<int[]> q = new LinkedList<>();
        int destination = 30;

        boolean[] visited = new boolean[destination + 1];
        int[] board = new int[destination + 1];
        Arrays.fill(board, -1);

        for(int i = 0; i < 2 * N; i += 2)
        {
            board[arr[i]] = arr[i + 1];
        }

        int[] parent = new int[destination + 1];
        Arrays.fill(parent, -1);

        q.add(new int[]{1, 0});
        visited[1] = true;
        parent[1] = 0;

        while(!q.isEmpty())
        {
            int[] data = q.poll();

            int pos = data[0];
            int moves = data[1];

            if(pos == destination)
            {
                // printPath(parent, destination);
                return moves;
            }

            for(int dice = 1; dice <= 6; dice++)
            {
                int nextPos = pos + dice;

                if(nextPos > destination)
                {
                    continue;
                }

                if(board[nextPos] != -1)
                {
                    nextPos = board[nextPos];
                }

                if(!visited[nextPos])
                {
                    visited[nextPos] = true;
                    parent[nextPos] = pos;
                    q.offer(new int[]{nextPos, moves + 1});
                }
            }
        }


        return -1;
    }

    public static void printPath(int[] parent, int destination)
    {
        List<Integer> path = new ArrayList<>();

        int curr = destination;
        while(curr != 0)
        {
            path.add(curr);
            curr = parent[curr];
        }

        Collections.reverse(path);
        System.out.println(path);
    }
}


/*
Time complexity: 
Space complexity: 
*/
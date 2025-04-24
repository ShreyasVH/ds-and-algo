/*
Snakes and Ladders

You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.

Note that you only take a snake or ladder at most once per dice roll. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of dice rolls required to reach the square n2. If it is not possible to reach the square, return -1.

 

Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.

Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1
 

Constraints:

n == board.length == board[i].length
2 <= n <= 20
board[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 are not the starting points of any snake or ladder.

*/

package ds.leetCode;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem909
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[][] points = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println((int) clazz.getMethod("snakesAndLadders", int[][].class).invoke(problem, (Object) points));

        System.out.println("------------------------------");

        points = new int[][]{{-1, -1}, {-1, 3}};
        System.out.println((int) clazz.getMethod("snakesAndLadders", int[][].class).invoke(problem, (Object) points));
	}

	public int snakesAndLadders(int[][] points) {
        Queue<int[]> q = new LinkedList<>();
        int n = points.length;
        int destination = n * n;
        boolean[] visited = new boolean[destination + 1];
        int[] parent = new int[destination + 1];
        Arrays.fill(parent, -1);


        q.offer(new int[]{1, 0});
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
                int newPos = pos + dice;

                if(newPos > destination)
                {
                    continue;
                }

                int[] coordinates = getCoOrdinates(n, newPos);
                
                if(points[coordinates[0]][coordinates[1]] != -1)
                {
                    newPos = points[coordinates[0]][coordinates[1]];
                }

                if(!visited[newPos])
                {
                    visited[newPos] = true;
                    parent[newPos] = pos;
                    q.offer(new int[]{newPos, moves + 1});
                }
            }
        }

        return -1;
    }

    public int[] getCoOrdinates(int n, int num)
    {
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        if(r % 2 == 1)
        {
            c = n - 1 - c;
        }
        r = n - 1 - r;
        
        return new int[]{r, c};
    }

    public void printPath(int[] parent, int destination)
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
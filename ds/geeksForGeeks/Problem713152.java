/*
Maximum Weight Node

Given a maze with n cells. Each cell may have multiple entry points but not more than one exit point (i.e entry/exit points are unidirectional doors like valves).

You are given an array exits[], where exits[i] contains the exit point of the ith cell.
If exits[i] is -1, then ith cell doesn't have an exit.

The task is to find the cell with maximum weight (The weight of a cell i is the sum of all the cell indexes that have exit point as i ). If there are multiple cells with the maximum weight return the cell with highest index.

Note: The cells are indexed with an integer value from 0 to n-1.
A cell i has weight 0 if no cell has exit point as i.

Examples:

Input: exits[] = [2, 0, -1, 2}
Output: 2
Explanation: 
1 -> 0 -> 2 <- 3
weight of 0th cell = 1
weight of 1st cell = 0 (because there is no cell pointing to the 1st cell)
weight of 2nd cell = 0+3 = 3
weight of 3rd cell = 0
There is only one cell which has maximum weight (i.e 2)
So, cell 2 is the output.

Input: exits[] = [-1]
Output: 0
Explanation:
weight of 0th cell is 0.
There is only one cell so cell 0 has maximum weight.
Constraints:
1  ≤  n  ≤  10^5
-1  <  exits[i]  <  N
exits[i]  ≠  i



*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem713152
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] exits = {2, 0, -1, 2};
        System.out.println((int) clazz.getMethod("maxWeightCell", int[].class).invoke(problem, exits));

        System.out.println("-----------------------");

        exits = new int[]{-1};
        System.out.println((int) clazz.getMethod("maxWeightCell", int[].class).invoke(problem, exits));

        System.out.println("-----------------------");

        exits = new int[]{1, 2, 1, 1, 2};
        System.out.println((int) clazz.getMethod("maxWeightCell", int[].class).invoke(problem, exits));
	}

	public int maxWeightCell(int[] exits) {
        int n = exits.length;
        int[] weights = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (exits[i] != -1) {
                weights[exits[i]] += i;
            }
        }

        int maxWeight = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (weights[i] > maxWeight) {
                maxWeight = weights[i];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if(weights[i] == maxWeight) {
                return i;
            }
        }

        return -1;
    }
}


/*
Time complexity: O(n)
Space complexity: O(n)
*/
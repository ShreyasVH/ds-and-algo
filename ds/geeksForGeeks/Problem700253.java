/*
The Celebrity Problem

A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0],
                [0, 1, 0],
                [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person and 1st person does not know anyone. Therefore, 1 is the celebrity person.

Input: mat[][] = [[1, 1], 
                [1, 1]]
Output: -1
Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.

Input: mat[][] = [[1]]
Output: 0

Constraints:
1 ≤ mat.size() ≤ 1000
0 ≤ mat[i][j] ≤ 1
mat[i][i] = 1
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700253
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[][] mat = {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        System.out.println((int) clazz.getMethod("celebrity", int[][].class).invoke(problem, (Object) mat));

        System.out.println("-------------------------------------------------------");

        mat = new int[][]{{1, 1}, {1, 1}};
        System.out.println((int) clazz.getMethod("celebrity", int[][].class).invoke(problem, (Object) mat));

        System.out.println("-------------------------------------------------------");

        mat = new int[][]{{1}};
        System.out.println((int) clazz.getMethod("celebrity", int[][].class).invoke(problem, (Object) mat));

        System.out.println("-------------------------------------------------------");

        mat = new int[][]{{1, 0, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println((int) clazz.getMethod("celebrity", int[][].class).invoke(problem, (Object) mat));

	}

	public int celebrity(int[][] mat) {
        int n = mat.length;

        for (int j = 0; j < n; j++) {
            boolean isKnown = true;
            for (int i = 0; i < n; i++) {
                if (mat[i][j] == 0) {
                    isKnown = false;
                    break;
                }
            }

            if (isKnown) {
                boolean knowsOthers = false;
                for (int k = 0; k < n; k++) {
                    if (j != k && mat[j][k] == 1) {
                        knowsOthers = true;
                        break;
                    }
                }

                if (!knowsOthers) {
                    return j;
                }

            }
        }

        return -1;
    }
}


/*
Time complexity: O(n ^ 2)
Space complexity: O(1)
*/
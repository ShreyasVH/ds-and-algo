/*


*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem701408
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println((int) clazz.getMethod("minTimeToVisitAllPoints", int[][].class).invoke(problem, points));

        points = new int[][]{{3, 2}, {-2, 2}};
        System.out.println((int) clazz.getMethod("minTimeToVisitAllPoints", int[][].class).invoke(problem, points));
	}

	public int problem(int[][] points) {
        
    }
}


/*
Time complexity: 
Space complexity: 
*/
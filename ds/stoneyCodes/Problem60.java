/*
K Closest Points to Origin

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 10^4
-10^4 <= xi, yi <= 10^4

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem60
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        ArrayUtils.print((int[][]) clazz.getMethod("kClosest", int[][].class, int.class).invoke(problem, points, k), k, 2);
        System.out.println("---------------------");

        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        k = 2;
        ArrayUtils.print((int[][]) clazz.getMethod("kClosest", int[][].class, int.class).invoke(problem, points, k), k, 2);
	}

    public int getDistance(int[] point)
    {
        return point[0] * point[0] + point[1] * point[1];
    }

	public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));

        for(int[] point: points)
        {
            maxHeap.add(point);
            if(maxHeap.size() > k)
            {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while(!maxHeap.isEmpty())
        {
            result[index++] = maxHeap.poll();
        }

        return result;
    }
}


/*
Time complexity: O(n logk)
Space complexity: O(k)
*/
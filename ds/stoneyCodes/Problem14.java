/*
Minimum Absolute Difference

Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 

Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]

Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 

Constraints:

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem14
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {4,2,1,3};
        System.out.println((List<List<Integer>>) clazz.getMethod("minimumAbsDifference", int[].class).invoke(problem, nums));

        nums = new int[]{1,3,6,10,15};
        System.out.println((List<List<Integer>>) clazz.getMethod("minimumAbsDifference", int[].class).invoke(problem, nums));

        nums = new int[]{3,8,-10,23,19,-4,-14,27};
        System.out.println((List<List<Integer>>) clazz.getMethod("minimumAbsDifference", int[].class).invoke(problem, nums));
	}

	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int minDifference = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                minDifference = Math.min(minDifference, Math.abs(arr[j] - arr[i]));
            }
        }

        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                int difference = Math.abs(arr[j] - arr[i]);
                if(difference == minDifference)
                {
                    result.add(Arrays.asList(arr[i], arr[j]));
                }
            }
        }
        return result;
    }
}


/*
Time complexity: O(n^2)
Space complexity: O(n) [for result]
*/
/*
Selection Sort

Given an array arr, use selection sort to sort arr[] in increasing order.

Examples :

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: Maintain sorted (in bold) and unsorted subarrays. Select 1. Array becomes 1 4 3 9 7. Select 3. Array becomes 1 3 4 9 7. Select 4. Array becomes 1 3 4 9 7. Select 7. Array becomes 1 3 4 7 9. Select 9. Array becomes 1 3 4 7 9.

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Input: arr[] = [38, 31, 20, 14, 30]
Output: [14, 20, 30, 31, 38]

Constraints:
1 ≤ arr.size() ≤ 10^3
1 ≤ arr[i] ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700147
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {4, 1, 3, 9, 7};
        clazz.getMethod("selectionSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);
        System.out.println("------------------------");

        arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        clazz.getMethod("selectionSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);
        System.out.println("------------------------");

        arr = new int[]{38, 31, 20, 14, 30};
        clazz.getMethod("selectionSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);
	}

	public void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++)
        {
            int smallest = i;
            for(int j = i; j < arr.length; j++)
            {
                if(arr[j] < arr[smallest])
                {
                    smallest = j;
                }
            }

            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }
}


/*
Time complexity: O(n^2)
Space complexity: O(1)
*/
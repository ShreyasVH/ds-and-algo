/*
Bubble Sort

Given an array, arr[]. Sort the array using bubble sort algorithm.

Examples :

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: After Sorting the array in ascending order of their values is [1, 3, 4, 7, 9].

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: Sort the array in ascending order of their values.

Input: arr[] = [1, 2, 3, 4, 5]
Output: [1, 2, 3, 4, 5]
Explanation: An array that is already sorted should remain unchanged after applying bubble sort.

Constraints:
1 ≤ arr.size() ≤ 10^3
1 ≤ arr[i] ≤ 10^3

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700143
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {4, 1, 3, 9, 7};
        ArrayUtils.print(arr);
        clazz.getMethod("bubbleSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);


        System.out.println("-------------------------------------------------------");

        arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayUtils.print(arr);
        clazz.getMethod("bubbleSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);


        System.out.println("-------------------------------------------------------");

        arr = new int[]{1, 2, 3, 4, 5};
        ArrayUtils.print(arr);
        clazz.getMethod("bubbleSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);
	}

	public void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}


/*
Time complexity: 
Space complexity: 
*/
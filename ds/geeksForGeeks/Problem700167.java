/*
Heap Sort

Given an array arr[]. The task is to sort the array elements by Heap Sort.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: After sorting elements using heap sort, elements will be in order as 1, 3, 4, 7, 9.

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: After sorting elements using heap sort, elements will be in order as 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.

Input: arr[] = [2, 1, 5]
Output: [1, 2, 5]
Explanation: After sorting elements using heap sort, elements will be in order as 1, 2, 5.

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700167
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {4, 1, 3, 9, 7};
        ArrayUtils.print(arr);
        clazz.getMethod("heapSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);

        System.out.println("-------------------------------------------------------");

        arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayUtils.print(arr);
        clazz.getMethod("heapSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);

        System.out.println("-------------------------------------------------------");

        arr = new int[]{2, 1, 5};
        ArrayUtils.print(arr);
        clazz.getMethod("heapSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);
	}

	public void heapSort(int arr[]) {
        int n = arr.length;

        for(int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i);
        }

        for(int i = n - 1; i >= 0; i--)
        {
            swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }

    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapify(int[] arr, int heapSize, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < heapSize && arr[left] > arr[i])
        {
            largest = left;
        }

        if(right < heapSize && arr[right] > arr[largest])
        {
            largest = right;
        }

        if(largest != i)
        {
            swap(arr, i, largest);

            heapify(arr, heapSize, largest);
        }
    }
}


/*
Time complexity: O(n log n)
Space complexity: O(1)
*/
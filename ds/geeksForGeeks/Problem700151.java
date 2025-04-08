/*
Quick Sort

Implement Quick Sort, a Divide and Conquer algorithm, to sort an array, arr[] in ascending order. Given an array, arr[], with starting index low and ending index high, complete the functions partition() and quickSort(). Use the last element as the pivot so that all elements less than or equal to the pivot come before it, and elements greater than the pivot follow it.

Note: The low and high are inclusive.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: After sorting, all elements are arranged in ascending order.

Input: arr[] = [2, 1, 6, 10, 4, 1, 3, 9, 7]
Output: [1, 1, 2, 3, 4, 6, 7, 9, 10]
Explanation: Duplicate elements (1) are retained in sorted order.

Input: arr[] = [5, 5, 5, 5]
Output: [5, 5, 5, 5]
Explanation: All elements are identical, so the array remains unchanged.

Constraints:
1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700151
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {4, 1, 3, 9, 7};
        int low = 0;
        int high = arr.length - 1;
        clazz.getMethod("quickSort", int[].class, int.class, int.class).invoke(problem, arr, low, high);
        ArrayUtils.print(arr);
        System.out.println("---------------------------");

        arr = new int[]{2, 1, 6, 10, 4, 1, 3, 9, 7};
        low = 0;
        high = arr.length - 1;
        clazz.getMethod("quickSort", int[].class, int.class, int.class).invoke(problem, arr, low, high);
        ArrayUtils.print(arr);
        System.out.println("---------------------------");

        arr = new int[]{5, 5, 5, 5};
        low = 0;
        high = arr.length - 1;
        clazz.getMethod("quickSort", int[].class, int.class, int.class).invoke(problem, arr, low, high);
        ArrayUtils.print(arr);
	}

	public void quickSort(int arr[], int low, int high) {
        if(low < high)
        {
            int pos = partition(arr, low, high);

            quickSort(arr, low, pos - 1);
            quickSort(arr, pos + 1, high);
        }
    }

    public int partition(int arr[], int low, int high) {
        int randomIndex = (new Random()).nextInt(high - low + 1) + low;
        int temp = arr[high];
        arr[high] = arr[randomIndex];
        arr[randomIndex] = temp;

        int pivot = arr[high];

        int i = low;

        for(int j = low; j < high; j++)
        {
            if(arr[j] < pivot)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }
}


/*
Time complexity: O(n log n)
                 O (n^2) [almost or fully sorrted]
Space complexity: O(log n)
                    O(n) [worst case]
*/
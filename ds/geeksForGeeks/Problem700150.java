/*
Merge Sort

Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Input: arr[] = [1, 3 , 2]
Output: [1, 2, 3]

Constraints:
1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^5

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700150
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {4, 1, 3, 9, 7};
        int l = 0;
        int r = arr.length - 1;
        clazz.getMethod("mergeSort", int[].class, int.class, int.class).invoke(problem, arr, l, r);
        ArrayUtils.print(arr);
        System.out.println("-------------------");

        arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        l = 0;
        r = arr.length - 1;
        clazz.getMethod("mergeSort", int[].class, int.class, int.class).invoke(problem, arr, l, r);
        ArrayUtils.print(arr);
        System.out.println("-------------------");

        arr = new int[]{1, 3, 2};
        l = 0;
        r = arr.length - 1;
        clazz.getMethod("mergeSort", int[].class, int.class, int.class).invoke(problem, arr, l, r);
        ArrayUtils.print(arr);
	}

	public void mergeSort(int arr[], int l, int r) {
        if(l < r)
        {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] M = new int[n1];
        int[] N = new int[n2];

        for(int i = 0; i < n1; i++)
        {
            M[i] = arr[l + i];
        }

        for(int i = 0; i < n2; i++)
        {
            N[i] = arr[m + 1 + i];
        }

        int k = l;

        int i = 0;
        int j = 0;

        while(i < n1 && j < n2)
        {
            if(M[i] <= N[j])
            {
                arr[k++] = M[i];
                i++;
            }
            else
            {
                arr[k++] = N[j];
                j++;
            }
        }

        while(i < n1)
        {
            arr[k++] = M[i];
            i++;
        }

        while(j < n2)
        {
            arr[k++] = N[j];
            j++;
        }
    }
}


/*
Time complexity: O(n log n)
Space complexity: O(n)
*/
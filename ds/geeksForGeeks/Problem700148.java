/*


*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700148
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {4, 1, 3, 9, 7};
        clazz.getMethod("insertionSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);

        System.out.println("-------------------------------------------------------");

        arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        clazz.getMethod("insertionSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);

        System.out.println("-------------------------------------------------------");

        arr = new int[]{4, 1, 9};
        clazz.getMethod("insertionSort", int[].class).invoke(problem, arr);
        ArrayUtils.print(arr);
	}

	public void insertionSort(int arr[]) {
        for(int i = 0; i < arr.length; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}


/*
Time complexity: O(n ^ 2)
Space complexity: O(1)
*/
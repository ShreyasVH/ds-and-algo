/*
Remove Duplicates Sorted Array


You are given a sorted array arr[] containing positive integers. Your task is to remove all duplicate elements from this array such that each element appears only once. Return an array containing these distinct elements in the same order as they appeared.
Examples :

Input: arr[] = [2, 2, 2, 2, 2]
Output: [2]
Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position and you should return array containing [2] after modifying the array.

Input: arr[] = [1, 2, 4]
Output: [1, 2, 4]
Explation:  As the array does not contain any duplicates so you should return [1, 2, 4].

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^6
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem700246
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] arr = {2, 2, 2, 2, 2};
        System.out.println((ArrayList<Integer>) clazz.getMethod("removeDuplicates", int[].class).invoke(problem, arr));

        System.out.println("-------------------------------------------------------");

        arr = new int[]{1, 2, 4};
        System.out.println((ArrayList<Integer>) clazz.getMethod("removeDuplicates", int[].class).invoke(problem, arr));
	}

	public ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        if (arr.length > 0) {
            result.add(arr[0]);


            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    result.add(arr[i]);
                }
            }
        }

        return result;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
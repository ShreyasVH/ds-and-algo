/*
Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem59
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println((int) clazz.getMethod("findKthLargest", int[].class, int.class).invoke(problem, nums, k));

        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        System.out.println((int) clazz.getMethod("findKthLargest", int[].class, int.class).invoke(problem, nums, k));
	}

	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums)
        {
            minHeap.add(num);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}


/*
Time complexity: O(n logk)
Space complexity: O(k)
*/
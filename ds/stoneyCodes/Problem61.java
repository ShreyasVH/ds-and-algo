/*
Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem61
{
	public static void main(String args[]) throws Exception
	{
		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        ArrayUtils.print((int[]) clazz.getMethod("topKFrequent", int[].class, int.class).invoke(problem, nums, k));

        nums = new int[]{1};
        k = 1;
        ArrayUtils.print((int[]) clazz.getMethod("topKFrequent", int[].class, int.class).invoke(problem, nums, k));
	}

	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums)
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        for(int num: frequencyMap.keySet())
        {
            minHeap.add(num);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int index = k - 1;
        while(!minHeap.isEmpty())
        {
            result[index--] = minHeap.poll();
        }

        return result;
    }
}


/*
Time complexity: 
Space complexity: 
*/
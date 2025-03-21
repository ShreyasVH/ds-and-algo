/*
Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem9a
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println((int) clazz.getMethod("maxProfit", int[].class).invoke(problem, prices));

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println((int) clazz.getMethod("maxProfit", int[].class).invoke(problem, prices));
	}

	public int maxProfit(int[] prices) {
        int max = 0;

        int l = 0;
        int r = 1;

        while(r < prices.length)
        {
            if(prices[l] < prices[r])
            {
                max = Math.max(max, prices[r] - prices[l]);
            }
            else
            {
                l = r;
            }
            r++;
        }
        
        return max;
    }
}


/*
Time complexity: O(n)
Space complexity: O(1)
*/
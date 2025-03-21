/*
Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 
Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4

*/

package ds.stoneyCodes;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem17
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println((int) clazz.getMethod("coinChange", int[].class, int.class).invoke(problem, coins, amount));

        coins = new int[]{2};
        amount = 3;
        System.out.println((int) clazz.getMethod("coinChange", int[].class, int.class).invoke(problem, coins, amount));

        coins = new int[]{1};
        amount = 0;
        System.out.println((int) clazz.getMethod("coinChange", int[].class, int.class).invoke(problem, coins, amount));
	}

	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++)
        {
            for(int coin: coins)
            {
                if(i - coin >= 0)
                {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}


/*
Time complexity: O(n * amount)
Space complexity: O(amount)
*/
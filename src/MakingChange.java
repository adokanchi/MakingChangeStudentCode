import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Tony Dokanchi
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        return countWays(target, coins, 0);
    }

    public static long countWays(int target, int[] coins, int idx) {
        if (idx >= coins.length) return 0;
        if (idx == coins.length - 1) {
            if (target % coins[idx] == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        Arrays.sort(coins);

        int coinVal = coins[idx];
        int maxNumCoins = target / coinVal;

        long numWays = 0;
        for (int i = 0; i <= maxNumCoins; i++) {
            numWays += countWays(target - i * coinVal, coins, idx + 1);
        }


        return numWays;
    }

}

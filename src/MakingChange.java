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
        long[] counts = new long[target + 1];
        counts[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int coinVal : coins) {
                if (i >= coinVal) {
                    counts[i] += counts[i - coinVal];
                }
            }
        }
        return counts[target];
    }
}

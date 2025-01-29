/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Tony Dokanchi
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {
        // counts[i] is the number of ways to make the target value i using the coins in coins[].
        long[] currCounts = new long[target + 1];
        currCounts[0] = 1;
        long[] nextCounts = new long[target + 1];
        // Go coin by coin to avoid double-counting because of order
        for (int coinVal : coins) {
            for (int i = target; i >= 0; i--) {
//                computeNextCounts(currCounts, nextCounts, i, coinVal);
                long next = 0;
                for (int j = i; j >= 0; j -= coinVal) {
                    next += currCounts[j];
                }
                nextCounts[i] = next;
            }
            currCounts = nextCounts;
            nextCounts = new long[target + 1];
        }
        return currCounts[target];
    }

    private static void computeNextCounts(long[] currCounts, long[] nextCounts, int i, int coinVal) {
        if (i - coinVal < 0) {

        }

        if (nextCounts[i - coinVal] == 0) {
            computeNextCounts(currCounts, nextCounts, i - coinVal, coinVal);
        }

        nextCounts[i] = currCounts[i] + nextCounts[i - coinVal];
    }

}
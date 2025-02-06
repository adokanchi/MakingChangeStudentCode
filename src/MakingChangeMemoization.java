/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Tony Dokanchi
 */

public class MakingChangeMemoization {
    private static long[][] storedVals;
    private static final long EMPTY = -1;

    public static long countWays(int target, int[] coins) {
        storedVals = new long[coins.length][target + 1];
        for (int i = 0; i < storedVals.length; i++) for (int j = 0; j < storedVals[0].length; j++) storedVals[i][j] = EMPTY;
        return countWays(target, coins, 0);
    }

    private static long countWays(int target, int[] coins, int coinIdx) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        // Speedup: when there is one coin left, we can immediately return 1 or 0
        if (coinIdx == coins.length - 1) {
            if (target % coins[coinIdx] == 0) return 1;
            return 0;
        }

        // If we have computed this case before
        if (storedVals[coinIdx][target] != EMPTY) return storedVals[coinIdx][target];

        // If we haven't computed this case before
        long result = countWays(target, coins, coinIdx + 1) + countWays(target - coins[coinIdx], coins, coinIdx);
        storedVals[coinIdx][target] = result;
        return result;
    }
}
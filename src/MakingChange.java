/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Tony Dokanchi
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {
        // counts[i] is the number of combinations to make the target value i
        long[] counts = new long[target + 1];
        counts[0] = 1;
        // Go coin by coin to avoid counting duplicate combinations
        for (int coinVal : coins) {
            for (int i = coinVal; i <= target; i++) {
                counts[i] += counts[i - coinVal];
            }
        }
        return counts[target];
    }
}
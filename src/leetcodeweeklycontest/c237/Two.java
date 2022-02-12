package src.leetcodeweeklycontest.c237;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/19 11:01:53
 * description:
 */
public class Two {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ret = 0;
        for (int c : costs) {
            if (c <= coins) {
                coins -= c;
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }

    public int maxIceCream1(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int cnt = 0, p = 0;
        while (coins > 0 && p < n) {
            if (costs[p] <= coins) {
                coins -= costs[p++];
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public int maxIceCream2(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int ret = 0, i = 0;
        if (coins < costs[0]) return ret;
        while (coins > 0 && i < n) {
            coins -= costs[i++];
            if (coins >= 0) ret++;
        }
        return ret;
    }
}

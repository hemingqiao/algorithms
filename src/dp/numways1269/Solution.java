package src.dp.numways1269;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/13 12:59:56
 * description:
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 *
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 *
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *  
 *
 * 提示：
 *
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 *
 * 参考：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/gong-shui-san-xie-xiang-jie-xian-xing-dp-m9q9/
 */
public class Solution {
    int mod = (int) 1e9 + 7;
    public int numWays(int steps, int arrLen) {
        int max = Math.min(steps / 2, arrLen - 1);
        // dp[step][i]代表剩余步数为steps，位于索引i处的所有操作方案
        int[][] dp = new int[steps + 1][max + 1];
        // 起始位置为0，步数为steps，操作方案为1，由此可以进行初始化dp[steps][0] = 1;
        dp[steps][0] = 1;
        /*
        不失一般性的考虑 dp[i][j] 可以由哪些状态转移而来：
            由「原地」操作到达当前状态，消耗一次操作，此时由状态 dp[i + 1][j] 转移而来
            由「向左」操作到达当前状态，消耗一次操作，此时由状态 dp[i + 1][j + 1] 转移而来
            由「向右」操作到达当前状态，消耗一次操作，此时由状态 dp[i + 1][j - 1] 转移而来
        */
        for (int i = steps - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
                if (j + 1 <= max) dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % mod;
                if (j - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % mod;
            }
        }
        return dp[0][0];
    }

    public int numWays1(int steps, int len) {
        int max = Math.min(steps / 2, len - 1);
        // dp[step][i]代表剩余步数为steps，位于索引i处的所有操作方案
        int[][] dp = new int[steps + 1][max + 1];
        // 起始位置为0，步数为steps，操作方案为1，由此可以进行初始化dp[steps][0] = 1;
        dp[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            /*
            随着「可操作次数」的减少，「可达到的最远位置」下标也会逐步缩小。从目标状态 f[0][0]f[0][0] 进行倒推的话，会发现「可达到的最远位置」
            等于「可操作次数」
             */
            int edge = Math.min(i, max);
            for (int j = 0; j <= edge; j++) {
                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
                if (j + 1 <= max) dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % mod;
                if (j - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % mod;
            }
        }
        return dp[0][0];
    }
}

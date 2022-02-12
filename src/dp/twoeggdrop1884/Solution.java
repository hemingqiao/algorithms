package src.dp.twoeggdrop1884;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/13 17:06:11
 * description:
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 *
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
 * 如果第一枚鸡蛋碎了，可知 f = 0；
 * 如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
 * 否则，当两个鸡蛋都没碎时，可知 f = 2。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：14
 *  
 *
 * 提示：
 *
 * 1 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors
 *
 */
public class Solution {
    // @see https://leetcode-cn.com/problems/super-egg-drop/

    /*
    可以采用动态规划，用 dp[i][j] 表示有 i + 1 枚鸡蛋时，验证 j 层楼需要的最少操作次数， 我们可以分开分析 i = 0 和 i = 1 的情况：

        i = 0 即只剩一枚鸡蛋，此时我们需要从 1 层开始逐层验证才能确保获取确切的 f 值，因此对于任意的 j 都有 dp[0][j] = j
        i = 1，对于任意 j ，第一次操作可以选择在 [1, j] 范围内的任一楼层 k，如果鸡蛋在 k 层丢下后破碎，接下来问题转化成 i = 0 时验证
         k - 1 层需要的次数，即 dp[0][k - 1], 总操作次数为 dp[0][k - 1] + 1； 如果鸡蛋在 k 层丢下后没碎，接下来问题转化成 i = 1 时
         验证 j - k 层需要的次数， 即 dp[1][j - k], 总操作次数为 dp[1][j - k] + 1，考虑最坏的情况，两者取最大值则有
         dp[1][j] = min(dp[1][j], max(dp[0][k - 1] + 1, dp[1][j - k] + 1))
     @see https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors/solution/dong-tai-gui-hua-shu-xue-tui-dao-by-tang-1zz1/
     */
    public static int INF = (int) 1e9;

    public int twoEggDrop(int n) {
        // f[i][j]表示用 i + 1 个鸡蛋验证 j 层的最小操作次数
        int[][] f = new int[2][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) f[i][j] = j;
                else f[i][j] = INF;
            }
        }
        // 楼层为 0 的特殊情况
        f[0][0] = f[1][0] = 0;
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= j; k++) {
                f[1][j] = Math.min(f[1][j], Math.max(f[0][k - 1] + 1, f[1][j - k] + 1));
            }
        }
        return f[1][n];
    }
}

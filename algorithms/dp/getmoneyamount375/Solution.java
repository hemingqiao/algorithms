package blogandquestion.algorithms.dp.getmoneyamount375;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 21:09:58
 * description: 这个动态规划也不是很懂啊
 */
public class Solution {
//    public int getMoneyAmount(int n) {
//        /*
//         dp[i][j]表示从[i,j]中猜出正确数字所需要的最少花费金额.(dp[i][i] = 0)
//         假设在范围[i,j]中选择x, 则选择x的最少花费金额为: max(dp[i][x-1], dp[x+1][j]) + x
//         用max的原因是我们要计算最坏反馈情况下的最少花费金额(选了x之后, 正确数字落在花费更高的那侧)
//
//         初始化为(n+2)*(n+2)数组的原因: 处理边界情况更加容易, 例如对于求解dp[1][n]时x如果等于1,
//         需要考虑dp[0][1](0不可能出现, dp[0][n]为0)
//         而当x等于n时, 需要考虑dp[n+1][n+1](n+1也不可能出现, dp[n+1][n+1]为0)
//
//         如何写出相应的代码更新dp矩阵, 递推式dp[i][j] = max(max(dp[i][x-1], dp[x+1][j]) + x), x~[i:j],
//         可以画出矩阵图协助理解, 可以发现dp[i][x-1]始终在dp[i][j]的左部, dp[x+1][j]始终在dp[i][j]的下部,
//         所以更新dp矩阵时i的次序应当遵循bottom到top的规则, j则相反, 由于i肯定小于等于j, 所以我们只需要遍历更新矩阵的一半即可(下半矩阵)
//         */
//        int[][] dp = new int[n+2][n+2];
//        for(int i = n; i >= 1; --i) {
//            for(int j = i; j <= n; ++j) {
//                if(i == j) {
//                    dp[i][j] = 0;
//                } else {
//                    dp[i][j] = Integer.MAX_VALUE;
//                    for(int x = i; x <= j; ++x) {
//                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][x-1], dp[x+1][j]) + x);
//                    }
//                }
//            }
//        }
//        return dp[1][n];
//    }

    /**
     * 参考：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/375-cai-shu-zi-da-xiao-ii-bao-sou-dong-tai-gui-hua/
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            k + Math.max(k <= 1 ? 0 : dp[i][k - 1], k + 1 > j ? 0 : dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}

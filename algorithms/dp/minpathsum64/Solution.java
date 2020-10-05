package blogandquestion.algorithms.dp.minpathsum64;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 17:20:23
 * description:
 * see: http://imlgw.top/2019/09/01/leetcode-dong-tai-gui-hua/
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 第一行
                if (i == 0 && j != 0) {
                    // 当只有上面是矩形边界时，只能从左面来
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (i != 0 && j == 0) {
                    // 当只有左面是矩形边界时，只能从上面来
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (i != 0 && j != 0) {
                    // 当左边和上边都不是矩形边界是，也就是位于矩形内部
                    // 则dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else {
                    // i == 0 && j == 0 起点
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

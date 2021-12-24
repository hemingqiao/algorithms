package blogandquestion.algorithms.array.gridgame;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/26 20:58:05
 * description:
 * 给你一个下标从 0 开始的二维数组 grid ，数组大小为 2 x n ，其中 grid[r][c] 表示矩阵中 (r, c) 位置上的点数。现在有两个机器人正在矩阵上参与一场游戏。
 *
 * 两个机器人初始位置都是 (0, 0) ，目标位置是 (1, n-1) 。每个机器人只会 向右 ((r, c) 到 (r, c + 1)) 或 向下 ((r, c) 到 (r + 1, c)) 。
 *
 * 游戏开始，第一个 机器人从 (0, 0) 移动到 (1, n-1) ，并收集路径上单元格的全部点数。对于路径上所有单元格 (r, c) ，途经后 grid[r][c] 会重置为 0 。
 * 然后，第二个 机器人从 (0, 0) 移动到 (1, n-1) ，同样收集路径上单元的全部点数。注意，它们的路径可能会存在相交的部分。
 *
 * 第一个 机器人想要打击竞争对手，使 第二个 机器人收集到的点数 最小化 。与此相对，第二个 机器人想要 最大化 自己收集到的点数。两个机器人都发挥出自己的
 * 最佳水平 的前提下，返回 第二个 机器人收集到的 点数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[2,5,4],[1,5,1]]
 * 输出：4
 * 解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
 * 第一个机器人访问过的单元格将会重置为 0 。
 * 第二个机器人将会收集到 0 + 0 + 4 + 0 = 4 个点。
 * 示例 2：
 *
 *
 * 输入：grid = [[3,3,1],[8,5,2]]
 * 输出：4
 * 解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
 * 第一个机器人访问过的单元格将会重置为 0 。
 * 第二个机器人将会收集到 0 + 3 + 1 + 0 = 4 个点。
 * 示例 3：
 *
 *
 * 输入：grid = [[1,3,1,15],[1,3,3,1]]
 * 输出：7
 * 解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
 * 第一个机器人访问过的单元格将会重置为 0 。
 * 第二个机器人将会收集到 0 + 1 + 3 + 3 + 0 = 7 个点。
 *  
 *
 * 提示：
 *
 * grid.length == 2
 * n == grid[r].length
 * 1 <= n <= 5 * 104
 * 1 <= grid[r][c] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grid-game
 *
 * @see https://leetcode-cn.com/problems/grid-game/solution/mei-ju-di-yi-ge-ji-qi-ren-de-guai-wan-we-prfy/
 * @see https://leetcode-cn.com/problems/grid-game/solution/javaqian-zhui-he-by-merickbao-2-nq78/
 */
public class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] pre = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            pre[0][i] = pre[0][i - 1] + grid[0][i - 1];
            pre[1][i] = pre[1][i - 1] + grid[1][i - 1];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            long max = Math.max(pre[0][n] - pre[0][i], pre[1][i - 1]);
            ans = Math.min(ans, max);
        }
        return ans;
    }
}

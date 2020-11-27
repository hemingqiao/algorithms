package blogandquestion.algorithms.graph.countservers1267;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 21:58:49
 * description:
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 示例 2：
 *
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 示例 3：
 *
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-servers-that-communicate
 *
 * 参考：https://leetcode-cn.com/problems/count-servers-that-communicate/solution/zhong-gui-zhong-ju-liang-chong-tong-ji-ji-shu-fang/
 */
public class Solution {
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0; // count用来统计结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果坐标[i, j]处存在server，并且当前行或者当前列有其他server，计数加1
                if (grid[i][j] == 1) {
                    boolean isConnected = false;
                    // 判断同一行是否存在server
                    for (int k = 0; k < col; k++) {
                        if (grid[i][k] == 1 && k != j) {
                            isConnected = true;
                            break;
                        }
                    }

                    // 判断同一列是否存在server，如果同一行已经存在server了，这里就不需要进行重复判断了
                    for (int k = 0; k < row && !isConnected; k++) {
                        if (grid[k][j] == 1 && k != i) {
                            isConnected = true;
                            break;
                        }
                    }

                    if (isConnected) count++;
                }
            }
        }
        return count;
    }
}

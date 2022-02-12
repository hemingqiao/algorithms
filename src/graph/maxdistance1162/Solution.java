package src.graph.maxdistance1162;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 16:36:16
 * description:
 * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 *
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果网格上只有陆地或者海洋，请返回 -1。
 *
 * 示例 1：
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 *
 * 参考：https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        // dx和dy用来遍历上下左右
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    // 先把所有的陆地都入队
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 然后从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是距离最近的陆地最远的海洋
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll(); // 将陆地出队
            int x = point[0], y = point[1];
            // 将当前陆地四周的海洋入队
            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];
                if (X < 0 || X >= m || Y < 0 || Y >= n || grid[X][Y] != 0) {
                    continue;
                }
                grid[X][Y] = grid[x][y] + 1; // 直接修改原数组的值，用来标记已经访问过，同时记录了此处海洋距离陆地的距离（从1开始增加）
                hasOcean = true;
                queue.add(new int[]{X, Y}); // 将海洋入队
            }
        }

        // 没有陆地或者没有海洋
        if (point == null || !hasOcean) {
            return -1;
        }

        // 海洋的值是从1开始增加的，所以要减去1
        return grid[point[0]][point[1]] - 1;
    }
}

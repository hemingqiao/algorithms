package blogandquestion.algorithms.dfs.maxareaofisland695;

import collections.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/05 16:58:25
 * description: 再解题中，递归使用的较多，但是再实际工程中，多使用栈，一是容易理解，二是不容易出现递归栈满的情况。
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *  
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 *
 */
public class Solution {
    // 方便对四个方向的遍历（左，下，右，上逆时针顺序）
    int[] directions = new int[]{-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        int area = 0, local_area;
        int x, y;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果位于i、j处的节点值为1，开始搜索
                if (grid[i][j] > 0) {
                    local_area = 1;
                    grid[i][j] = 0; // 沉岛，防止再次搜索到
                    // 利用栈记录坐标
                    Stack<int[]> island = new Stack<>();
                    island.push(new int[]{i, j});
                    while (!island.isEmpty()) {
                        int[] top = island.pop();
                        // 以当前坐标为中心，按照逆时针顺序搜索当前位置的四个方向
                        for (int k = 0; k < 4; k++) {
                            // top[0] = i, top[1] = j;
                            x = top[0] + directions[k];
                            y = top[1] + directions[k + 1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0) {
                                local_area++;
                                grid[x][y] = 0;
                                island.push(new int[]{x, y});
                            }
                        }
                    }
                    // 遍历完栈之后，更新最大面积
                    area = Math.max(area, local_area);
                }
            }
        }
        return area;
    }
}

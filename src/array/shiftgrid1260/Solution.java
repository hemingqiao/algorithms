package src.array.shiftgrid1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/09 19:42:04
 * description:
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 *
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *
 * 提示：
 *
 * 1 <= grid.length <= 50
 * 1 <= grid[i].length <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shift-2d-grid
 *
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k = k % (m * n); // 优化
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                t.add(0);
            }
            ret.add(t);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 纸上画一画找到的规律
                int temp = i * n + j + k;
                int r = (temp / n) % m;
                int c = temp % n;
                ret.get(r).set(c, grid[i][j]);
            }
        }
        return ret;
    }

    // 上面麻烦之处在于处理返回值（要求返回List，其实返回数组更方便）
    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k = k % (m * n); // 优化
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 纸上画一画找到的规律
                int temp = i * n + j + k;
                int r = (temp / n) % m;
                int c = temp % n;
                ret[r][c] = grid[i][j];
            }
        }
        List res;
        res = Arrays.asList(ret);
        return res;
    }
}

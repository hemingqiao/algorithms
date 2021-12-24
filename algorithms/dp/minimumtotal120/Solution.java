package blogandquestion.algorithms.dp.minimumtotal120;

import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 08:48:30
 * description:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *  
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 *
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int len = triangle.size();
        int[][] dp = new int[len][len];
        // 初始化dp数组
        for (int i = 0; i < triangle.get(len - 1).size(); i++) {
            dp[len - 1][i] = triangle.get(len - 1).get(i);
        }
        for (int j = len - 2; j >= 0; j--) {
            for (int k = 0; k < triangle.get(j).size(); k++) {
                // 状态转移方程
                dp[j][k] = Math.min(dp[j + 1][k], dp[j + 1][k + 1]) + triangle.get(j).get(k);
            }
        }
        return dp[0][0];
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/triangle/solution/javadong-tai-gui-hua-si-lu-yi-ji-dai-ma-shi-xian-b/
 */
class DPOpt {
    /*
    2
    3 4
    6 5 7
    4 1 8 3
    最初dp存储的是最后一行的所有元素，求解第i行时，只用到了i + 1行的 [i + 1, j] 和 [i + 1, j + 1]
    可以将dp数组简化为一维，使用dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j)进行判断，并不会对后面产生影响
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int len = triangle.size();
        int[] dp = new int[len];
        // 初始化dp数组为最后一行元素的值
        for (int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
 */
class AnotherSolution {
    /*
    // 超时
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.cnt()) {
            return 0;
        }
        return Math.min(dfs(triangle, row + 1, col), dfs(triangle, row + 1, col + 1))
                + triangle.get(row).get(col);
    }
    */

    // 使用数组进行记忆化（有点类似动态规划）
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0, dp);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        if (row == triangle.size()) {
            return 0;
        }
        // 如果之前已经记录过这个坐标对应的值，直接返回
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        // 将结果记录下来
        dp[row][col] = Math.min(dfs(triangle, row + 1, col, dp), dfs(triangle, row + 1, col + 1, dp))
                + triangle.get(row).get(col);
        // 返回结果
        return dp[row][col];
    }
}

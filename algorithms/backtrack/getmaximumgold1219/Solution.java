package blogandquestion.algorithms.backtrack.getmaximumgold1219;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/20 13:43:49
 * description:
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 * 示例 2：
 *
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 输出：28
 * 解释：
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-maximum-gold
 *
 * 参考：https://leetcode-cn.com/problems/path-with-maximum-gold/solution/hui-su-suan-fa-tu-wen-xiang-jie-by-sdwwld/
 */
public class Solution {
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    // i代表行，j代表列
    private int dfs(int[][] grid, int i, int j) {
        // 递归的base case是i或者j越界，或者当前位置没有黄金（值为0）
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        int temp = grid[i][j]; // 保存当前位置的值
        grid[i][j] = 0; // 将当前位置的值置为0，避免被再次遍历
        int top = dfs(grid, i - 1, j);
        int right = dfs(grid, i, j + 1);
        int bottom = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);

        int max = Math.max(Math.max(Math.max(top, right), bottom), left);
        grid[i][j] = temp; // 撤销选择，复原当前位置的值，回溯
        return max + temp;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/path-with-maximum-gold/solution/java-dfswei-you-hua-by-17302010035/
 */
class AnotherSolution {
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    // 根据题目限定，选择非0的坐标作为起点
                    // 下面这样判断，比调用Math.max方法快一些
                    int gold = backtracking(grid, i, j);
                    if (gold > res) res = gold;
                }
            }
        }
        return res;
    }

    private int backtracking(int[][] grid, int i, int j) {
        int max = 0;
        int temp = grid[i][j];
        grid[i][j] = 0;
        if (i - 1 >= 0 && grid[i - 1][j] != 0) {
            max = Math.max(max, backtracking(grid, i - 1, j));
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] != 0) {
            max = Math.max(max, backtracking(grid, i, j + 1));
        }
        if (i + 1 < grid.length && grid[i + 1][j] != 0) {
            max = Math.max(max, backtracking(grid, i + 1, j));
        }
        if (j - 1 >= 0 && grid[i][j - 1] != 0) {
            max = Math.max(max, backtracking(grid, i, j - 1));
        }
        grid[i][j] = temp;
        return max + temp;
    }
}

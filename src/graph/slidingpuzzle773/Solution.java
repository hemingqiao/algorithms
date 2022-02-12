package src.graph.slidingpuzzle773;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/26 20:31:39
 * description:
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 *
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 *
 */
public class Solution {
    // 参考：https://www.acwing.com/video/2722/
    public int slidingPuzzle(int[][] board) {
        int[][] target = {{1, 2, 3}, {4, 5, 0}};
        if (Arrays.deepEquals(target, board)) return 0;
        Map<String, Integer> dist = new HashMap<>();
        Deque<int[][]> queue = new ArrayDeque<>();
        queue.offer(board);
        dist.put(Arrays.deepToString(board), 0);
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[][] t = queue.poll();
            String kt = Arrays.deepToString(t);
            int x = 0, y = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (t[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 2 && b >= 0 && b < 3) {
                    int[][] r = new int[2][3];
                    for (int j = 0; j < 2; j++) {
                        for (int k = 0; k < 3; k++) r[j][k] = t[j][k];
                    }
                    int temp = r[x][y];
                    r[x][y] = r[a][b];
                    r[a][b] = temp;
                    // 需要用String作为map的key值，否则每次循环都新建一个新的二维数组r，导致dist.containsKey()每次都返回false
                    String kr = Arrays.deepToString(r);
                    if (!dist.containsKey(kr)) {
                        dist.put(kr, dist.get(kt) + 1);
                        if (Arrays.deepEquals(r, target)) return dist.get(kr);
                        queue.offer(r);
                    }
                }
            }
        }
        // 没有搜索到到达目标的路径，则返回-1
        return -1;
    }


    // 错误解法，因为每次都新创建了一个二维数组r，所以导致dist.containsKey(r)每次都返回false
    // WA
    public int slidingPuzzle1(int[][] board) {
        int[][] target = {{1, 2, 3}, {4, 5, 0}};
        if (Arrays.deepEquals(target, board)) return 0;
        Map<int[][], Integer> dist = new HashMap<>();
        Deque<int[][]> queue = new ArrayDeque<>();
        queue.offer(board);
        dist.put(board, 0);
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[][] t = queue.poll();
            int x = 0, y = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (t[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 2 && b >= 0 && b < 3) {
                    int[][] r = new int[2][3];
                    for (int j = 0; j < 2; j++) {
                        for (int k = 0; k < 3; k++) r[j][k] = t[j][k];
                    }
                    int temp = r[x][y];
                    r[x][y] = r[a][b];
                    r[a][b] = temp;
                    if (!dist.containsKey(r)) {
                        dist.put(r, dist.get(t) + 1);
                        if (Arrays.deepEquals(r, target)) return dist.get(r);
                        queue.offer(r);
                    }
                }
            }
        }
        // 没有搜索到到达目标的路径，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] t = {{1, 2, 3}, {5, 4, 0}};
        int res = s.slidingPuzzle(t);
        System.out.println(res);
    }
}

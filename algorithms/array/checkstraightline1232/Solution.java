package blogandquestion.algorithms.array.checkstraightline1232;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 13:40:04
 * description:
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示
 * 横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 示例 1：
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *
 * 提示：
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 *
 */
public class Solution {
    // 直线方程，但是需要考虑到所有的点的x值都相同（即直线方程斜率为无穷大，此时只需判断所有的点的x值是否相同即可）
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        int[] start = coordinates[0];
        int[] end = coordinates[len - 1];
        if (end[0] == start[0]) {
            for (int i = 1; i < len - 1; i++) {
                if (coordinates[i][0] != end[0]) return false;
            }
        } else {
            double k = (end[1] - start[1]) * 1.0 / (end[0] - start[0]);
            double b = end[1] - k * end[0];
            for (int i = 1; i < len - 1; i++) {
                int[] temp = coordinates[i];
                if (temp[1] != k * temp[0] + b) return false;
            }
        }
        return true;
    }
}

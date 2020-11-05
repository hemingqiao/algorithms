package blogandquestion.algorithms.numbers.insert57;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/05 08:33:54
 * description: 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/insert-interval/solution/bi-xu-miao-dong-li-kou-qu-jian-ti-mu-zhong-die-qu-/
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        // 遍历区间，将区间左边且与插入区间相离的部分加入结果列表
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        // 当区间与插入区间有重叠时，进行区间合并，直到遍历到新区间与之后的区间相离
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // 将合并后的新区间加入结果列表
        res.add(new int[]{newInterval[0], newInterval[1]});
        // 如果原二维数组未遍历完，将剩余的区间加入结果列表
        while (i < intervals.length) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        return res.toArray(new int[][]{});
    }
}

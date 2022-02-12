package src.greedy.eraseoverlapintervals435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/03 08:31:26
 * description:
 * 在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
 * 就越大，就越能保留更多的区间。因此，采取的贪心策略为，优先保留结尾小且不相交的区间。
 * 具体实现是，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
 * 择的区间不重叠的区间。
 *
 * 题目描述如下：
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 *
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return 0;
        int n = intervals.length;
        // 对数组进行增序排序，排序基准是每个子数组的结尾
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int total = 0, prev = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prev) { // 两个区间有重叠
                ++total; // 记录重叠区间
            } else {
                prev = intervals[i][1]; // 区间前进一位
            }
        }
        return total;
    }
}

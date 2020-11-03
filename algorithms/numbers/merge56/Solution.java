package blogandquestion.algorithms.numbers.merge56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/03 21:34:04
 * description:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 *
 * 先对左区间进行排序，如果第一个区间的右区间小于第二个区间的左区间，无需进行合并，直接添加进结果数组；如果第一个区间的右区间值大于等于
 * 第二个区间的左区间值，则这两个区间可以合并，合并后新的右区间值取这两个合并的区间的右区间值的较大者，然后继续和后一个区间进行比较。
 * 解题思路
 * see: https://leetcode-cn.com/problems/non-overlapping-intervals/solution/ha-zhe-bu-jiu-shi-56ti-he-bing-qu-jian-de-ling-yi-/
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : (o1[0] == o2[0] ? 0 : 1);
            }
        });
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                // 如果后一个区间的左值小于等于前一个区间的右值，合并这两个区间
                // 同时将右值更新为两个合并的区间的右值中的较大者
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 否则直接将区间添加进结果列表，继续循环，比较下一个区间
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[][]{});
    }
}

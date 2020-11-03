package blogandquestion.algorithms.greedy.eraseoverlapintervals435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/03 08:47:25
 * description: 这个解法没有贪心策略好理解。但是时间击败100，确实执行的快。
 * 解题思路
 * see: https://leetcode-cn.com/problems/non-overlapping-intervals/solution/ha-zhe-bu-jiu-shi-56ti-he-bing-qu-jian-de-ling-yi-/
 */
public class AnotherSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int count = 0; // 记录需要移除的区间数
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] < right) {
                i++;
                count++;
                // 为了得到最小的count,合并区间时，右区间应该取两个合并区间最小的那个右区间值。
                right = Math.min(right, intervals[i][1]);
            }
            i++;
        }
        return count;
    }
}

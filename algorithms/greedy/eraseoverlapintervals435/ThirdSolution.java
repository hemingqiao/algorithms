package blogandquestion.algorithms.greedy.eraseoverlapintervals435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/31 20:02:27
 * description:
 * 在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
 * 就越大，就越能保留更多的区间。因此，采取的贪心策略为，优先保留结尾小且不相交的区间。
 * 具体实现是，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
 * 择的区间不重叠的区间。
 *
 * 参考：https://leetcode-cn.com/problems/non-overlapping-intervals/solution/wu-zhong-die-qu-jian-ji-bai-liao-100de-y-kkzr/
 */
public class ThirdSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // 产生重叠，必须移除一个
                // 如果产生了重叠，优先移除尾部较大的数组，将end更新为两者中尾部较小者
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {
                // 如果没有重叠，只需要更新end即可
                end = intervals[i][1];
            }
        }
        return count;
    }
}

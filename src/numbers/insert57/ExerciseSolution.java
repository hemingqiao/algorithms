package src.numbers.insert57;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/26 19:55:41
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int first = newInterval[0], second = newInterval[1];
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < first) {
            list.add(intervals[i]);
            i++;
        }
        // 合并存在重叠的区间
        while (i < n && intervals[i][0] <= second) {
            first = Math.min(first, intervals[i][0]);
            second = Math.max(second, intervals[i][1]);
            i++;
        }
        list.add(new int[]{first, second});
        while (i < n) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[0][]);
    }
}

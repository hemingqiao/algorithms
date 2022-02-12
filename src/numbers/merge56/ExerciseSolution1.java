package src.numbers.merge56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/19 13:19:57
 * description:
 */
public class ExerciseSolution1 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start, end});
        int[][] ret = new int[list.size()][];
        int p = 0;
        for (int[] arr : list) ret[p++] = arr;
        return ret;
    }
}

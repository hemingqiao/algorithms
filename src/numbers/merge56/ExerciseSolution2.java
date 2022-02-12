package src.numbers.merge56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/05 11:41:58
 * description:
 */
public class ExerciseSolution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] a = intervals[i];
            if (a[0] <= r) {
                r = Math.max(r, a[1]);
            } else {
                list.add(new int[]{l, r});
                l = a[0];
                r = a[1];
            }
        }
        list.add(new int[]{l, r});
        return list.toArray(new int[0][0]);
    }

    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] a = intervals[i];
            if (a[0] <= r) {
                r = Math.max(r, a[1]);
            } else {
                list.add(new int[]{l, r});
                l = a[0];
                r = a[1];
            }
        }
        list.add(new int[]{l, r});
        int m = list.size();
        int[][] ret = new int[m][2];
        for (int j = 0; j < m; j++) ret[j] = list.get(j);
        return ret;
    }
}

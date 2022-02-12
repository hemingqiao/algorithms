package src.numbers.merge56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/31 11:20:14
 * description:
 */
public class ExerciseSolution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int cover = intervals[0][1];
        int start = intervals[0][0];
        for (int i = 1; i < n; i++) {
            int[] pair = intervals[i];
            if (pair[0] <= cover) {
                cover = Math.max(cover, pair[1]);
            } else {
                list.add(new int[]{start, cover});
                start = pair[0];
                cover = pair[1];
            }
        }
        list.add(new int[]{start, cover});
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,4},{0,2},{3,5}};
        ExerciseSolution es = new ExerciseSolution();
        int[][] res = es.merge(test);
        System.out.println(Arrays.deepToString(res));
    }
}

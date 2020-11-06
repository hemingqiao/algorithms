package blogandquestion.algorithms.numbers.removecoveredintervals1288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/06 10:05:07
 * description: 对Solution中解法的优化，对数组排序时，如果首元素值相同，以第二个元素为基准降序排列。就可以减少判断的逻辑。
 */
public class AnotherSolution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        List<int[]> res = new ArrayList<>();
        // 对数组进行升序排序，以第一个元素为基准，如果第一个元素相同，则以第二个元素为基准降序排列
        // 排序后形如 [1,2] [2,9] [2,8] [3,5]
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] >= left && intervals[i + 1][1] <= right) {
                i++; // 因为元素已经排好序，如果满足while的条件，直接合并，不需要做其他处理，
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.size();
    }
}


/*
在 comparator 的 compare 方法中，如果处理是 a - b，则是升序排列，如果是 b - a，则是降序排列。这是因为：
对于待排序的两个元素 a, b 而言，如果排序函数返回-1（负数），表明 a 会位于 b前面，返回正数则表明 a 会位于 b 的后面。
a - b 恰好符合预期，如果 a 小于 b，则 a - b 返回负数，a 位于 b 之前，升序排列；
而如果使用了 b - a，刚好和之前相反，因为如果 a 小于 b，此时排序函数返回了正数，表明 a 会位于 b 后面，此时就是降序排列。
 */

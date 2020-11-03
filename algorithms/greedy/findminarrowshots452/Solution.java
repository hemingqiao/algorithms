package blogandquestion.algorithms.greedy.findminarrowshots452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/03 14:22:30
 * description: 与435类似，也是求解不重叠区间的个数，与435不同的是，在435中，[1, 2] 和 [2, 3]不重叠，而在这里是重叠的。
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 避免使用o1[1] - o2[1]，防止溢出（实际上，这一题的最后一个测试用例，整型就溢出了）
                return o1[1] < o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1);
            }
        });
        int count = 1, end = points[0][1]; // count从1开始计数，因为最开始就代表一个区间
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            count++;
            end = points[i][1];
        }
        return count;
    }
}

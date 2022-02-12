package src.numbers.merge56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/03 21:50:15
 * description: 和Solution解法不同之处就是将while循环换为了for循环
 * 解题思路
 * see: https://leetcode-cn.com/problems/merge-intervals/solution/javapai-xu-shuang-zhi-zhen-ji-bai-92-by-outvoker-c/
 */
public class AnotherSolution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : (o1[0] == o2[0] ? 0 : 1);
            }
        });
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果某个区间的左起点大于前一个区间的右终点的值，不需要对这个区间进行合并，可以直接将前一个区间添加进结果列表
            if (intervals[i][0] > right) {
                res.add(new int[]{left, right});
                // 更新区间的左值和右值
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                // 如果区间的左起点小于等于前一个区间的右终点的值，则合并这两个区间，新的区间的右终点的值为这两个合并区间的右值的较大者
                right = Math.max(right, intervals[i][1]);
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[][]{});
    }
}

package src.numbers.removecoveredintervals1288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/06 08:37:55
 * description:
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *  
 *
 * 提示：​​​​​​
 *
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-covered-intervals
 *
 */
public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        List<int[]> res = new ArrayList<>();
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
            while (i < intervals.length - 1 &&
                    ((intervals[i + 1][0] <= left && intervals[i + 1][1] >= right) || (intervals[i + 1][0] >= left && intervals[i + 1][1] <= right))) {
                i++;
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.size();
    }

    // test
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = new int[4][];
        intervals[0] = new int[]{1,2};
        intervals[1] = new int[]{1,4};
        intervals[2] = new int[]{3,4};
        intervals[3] = new int[]{4,5};
        int result = s.removeCoveredIntervals(intervals);
        System.out.println(result);
    }
}

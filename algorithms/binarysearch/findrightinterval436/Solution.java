package blogandquestion.algorithms.binarysearch.findrightinterval436;

import java.util.Arrays;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/28 22:15:09
 * description:
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 *
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 *
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 *
 *  
 * 示例 1：
 *
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 *
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1, 0, 1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 *
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1, 2, -1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 2 * 10^4
 * intervals[i].length == 2
 * -106 <= starti <= endi <= 10^6
 * 每个间隔的起点都 不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-right-interval
 *
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) p[i] = new Pair(intervals[i][0], i);
        Arrays.sort(p, (a, b) -> a.val - b.val);
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int[] in = intervals[i];
            ret[i] = getIndex(p, in[1]);
        }
        return ret;
    }

    public int getIndex(Pair[] p, int t) {
        int l = 0, r = p.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (p[mid].val >= t) r = mid;
            else l = mid + 1;
        }
        return p[l].val >= t ? p[l].idx : -1;
    }

    static class Pair {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}

package blogandquestion.algorithms.greedy.findminarrowshots452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/03 14:22:30
 * description: 与435类似，也是求解不重叠区间的个数，与435不同的是，在435中，[1, 2] 和 [2, 3]不重叠，而在这里是重叠的。
 * 解题思路
 * see: https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E8%B4%AA%E5%BF%83%E6%80%9D%E6%83%B3.md
 *
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 
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
            // 如果第i个气球的起始位置小于end，表明第一支箭可以射到这个气球
            if (points[i][0] <= end) {
                continue;
            }
            count++;
            end = points[i][1];
        }
        return count;
    }
}

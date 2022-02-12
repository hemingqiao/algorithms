package src.hashtable.leastbricks554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/02 11:06:58
 * description:
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 *
 * 示例 1：
 *
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 * 示例 2：
 *
 * 输入：wall = [[1],[1],[1]]
 * 输出：3
 *  
 * 提示：
 *
 * n == wall.length
 * 1 <= n <= 10^4
 * 1 <= wall[i].length <= 10^4
 * 1 <= sum(wall[i].length) <= 2 * 10^4
 * 对于每一行 i ，sum(wall[i]) 应当是相同的
 * 1 <= wall[i][j] <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 *
 * 参考：https://github.com/grandyang/leetcode/issues/554
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int maxFreq = 0, n = wall.size();
        // map用来记录每一个断点的出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            int m = row.size();
            // 每一行遍历到倒数第二块砖头
            for (int i = 0; i < m - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(sum));
            }
        }
        return n - maxFreq;
    }
}

package src.dp.maxenvelopes354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/25 19:15:03
 * description:
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 *
 * 这一题可以视为二维的最长递增子序列？
 * @see https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Solution {
    /*
    首先要给所有的信封按从小到大排序，首先根据宽度从小到大排，如果宽度相同，那么高度小的再前面，然后开始遍历，对于每一个信封，都遍历其前面所有的
    信封，如果当前信封的长和宽都比前面那个信封的大，那么就更新dp数组，通过dp[i] = max(dp[i], dp[j] + 1)。然后每遍历完一个信封，都更新一下
    结果res
     */

    // brute force solution
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int res = 0, n = envelopes.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int n = envelopes.length, size = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0, right = size, t = envelopes[i][1];
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (dp[mid] >= t) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            dp[left] = t;
            if (left == size) size++;
        }
        return size;
    }
}

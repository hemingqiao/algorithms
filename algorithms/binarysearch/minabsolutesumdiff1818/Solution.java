package blogandquestion.algorithms.binarysearch.minabsolutesumdiff1818;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/14 22:02:32
 * description:
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 *
 * |x| 定义为：
 *
 *     如果 x >= 0 ，值为 x ，或者
 *     如果 x <= 0 ，值为 -x
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 *
 * 示例 2：
 *
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 *
 * 示例 3：
 *
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *
 *
 *
 * 提示：
 *
 *     n == nums1.length
 *     n == nums2.length
 *     1 <= n <= 10^5
 *     1 <= nums1[i], nums2[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 *
 */
public class Solution {
    // see: https://www.acwing.com/solution/content/43459/
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = (int) (1e9 + 7);
        int n = nums1.length;
        long res = 0;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums1[i] - nums2[i]);
            c[i] = nums1[i];
        }
        if (res == 0) return 0;
        Arrays.sort(c);
        long ans = res;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1, target = nums2[i];
            // 找到nums1中大于等于nums2[i]中的元素，注意这里可能找到的是大于nums2[i]的第一个位置
            // 所以需要比较下l - 1位置处的值，l - 1位置处的值一定小于nums2[i]
            while (l < r) {
                int mid = l + r >> 1;
                if (c[mid] >= target) r = mid;
                else l = mid + 1;
            }
            ans = Math.min(ans, res - Math.abs(nums1[i] - nums2[i]) + Math.abs(c[l] - nums2[i]));
            if (l > 0) ans = Math.min(ans, res - Math.abs(nums1[i] - nums2[i]) + Math.abs(c[l - 1] - nums2[i]));
        }
        return (int) (ans % MOD);
    }
}

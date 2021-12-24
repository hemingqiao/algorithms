package blogandquestion.algorithms.leetcodeweeklycontest.c240;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/10 22:26:32
 * description:
 * 给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
 *
 * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​
 *
 * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
 *
 * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
 * 输出：2
 * 解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * 示例 2：
 *
 * 输入：nums1 = [2,2,2], nums2 = [10,10,1]
 * 输出：1
 * 解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
 * 最大距离是 1 ，对应下标对 (0,1) 。
 * 示例 3：
 *
 * 输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
 * 输出：2
 * 解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * 示例 4：
 *
 * 输入：nums1 = [5,4], nums2 = [3,2]
 * 输出：0
 * 解释：不存在有效下标对，所以返回 0 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= 10^5
 * 1 <= nums2.length <= 10^5
 * 1 <= nums1[i], nums2[j] <= 10^5
 * nums1 和 nums2 都是 非递增 数组
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-distance-between-a-pair-of-values
 *
 */
public class Two {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int pos = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (pos + 1 < nums2.length && nums2[pos + 1] >= nums1[i]) {
                pos++;
            }
            // 利用了nums1是一个非递增数组，前一个pos指向的元素的值一定是大于等于nums1[i]，所以nums1[i + 1]一定小于前一个pos指向的元素
            ans = Math.max(ans, pos - i);
        }
        return ans;
    }
}

package src.leetcodeweeklycontest.c238;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/02 15:57:46
 * description:
 * 元素的 频数 是该元素在一个数组中出现的次数。
 *
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 *
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * 示例 2：
 *
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * 示例 3：
 *
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element
 *
 * 参考：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/solution/jian-dan-yi-dong-zui-zi-ran-de-chu-li-lu-9i9a/
 */
public class Two {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, n = nums.length;
        int j = 0;
        long cnt = 0;
        for (int i = 1; i < n; i++) {
            // 计算窗口内的每一个值，和窗口内的最大值相差的总和
            cnt += (nums[i] - nums[i - 1]) * (i - j);
            // 如果超过了目标值
            while (cnt > k) {
                // 窗口左边界向右移动一位
                // 从cnt中减去窗口内最左侧的值与最后一个值的差距
                cnt -= nums[i] - nums[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}

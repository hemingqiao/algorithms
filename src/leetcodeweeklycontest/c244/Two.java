package src.leetcodeweeklycontest.c244;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/06 10:16:05
 * description:
 * 给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤：
 *
 * 找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。
 * 找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。
 * 将 nums[i] 减少到 nextLargest 。
 * 返回使 nums 中的所有元素相等的操作次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,1,3]
 * 输出：3
 * 解释：需要 3 次操作使 nums 中的所有元素相等：
 * 1. largest = 5 下标为 0 。nextLargest = 3 。将 nums[0] 减少到 3 。nums = [3,1,3] 。
 * 2. largest = 3 下标为 0 。nextLargest = 1 。将 nums[0] 减少到 1 。nums = [1,1,3] 。
 * 3. largest = 3 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 * 解释：nums 中的所有元素已经是相等的。
 * 示例 3：
 *
 * 输入：nums = [1,1,2,2,3]
 * 输出：4
 * 解释：需要 4 次操作使 nums 中的所有元素相等：
 * 1. largest = 3 下标为 4 。nextLargest = 2 。将 nums[4] 减少到 2 。nums = [1,1,2,2,2] 。
 * 2. largest = 2 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1,2,2] 。
 * 3. largest = 2 下标为 3 。nextLargest = 1 。将 nums[3] 减少到 1 。nums = [1,1,1,1,2] 。
 * 4. largest = 2 下标为 4 。nextLargest = 1 。将 nums[4] 减少到 1 。nums = [1,1,1,1,1] 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 5 * 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reduction-operations-to-make-the-array-elements-equal
 *
 */
public class Two {
    public int reductionOperations(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums) set.add(num);
        int l = set.size();
        for (int j = n - 1; j >= 0; j--) {
            int cnt = 1, i = j - 1;
            while (i >= 0 && nums[i] == nums[i + 1]) {
                ++cnt;
                --i;
                --j;
            }
            res += (l - 1) * cnt;
            l--;
        }
        return res;
    }

    public int reductionOperations1(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        // 使用双指针统计数组中共有多少个不同元素
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1]) {
                j++;
                i++;
            }
            l++;
        }
        int n = nums.length;
        for (int j = n - 1; j >= 0; j--) {
            int cnt = 1, i = j - 1;
            while (i >= 0 && nums[i] == nums[i + 1]) {
                ++cnt;
                --i;
                --j;
            }
            res += (l - 1) * cnt;
            l--;
        }
        return res;
    }


    // 这个解法妙
    // 参考：https://www.acwing.com/activity/content/problem/content/4179/1/
    public int reductionOperations2(int[] a) {
        Arrays.sort(a);
        int res = 0, s = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) s++;
            res += s;
        }
        return res;
    }
}

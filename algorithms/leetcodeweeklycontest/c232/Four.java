package blogandquestion.algorithms.leetcodeweeklycontest.c232;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/14 13:48:02
 * description:
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 *
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 *
 * 请你返回 好 子数组的最大可能 分数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,4,3,7,4,5], k = 3
 * 输出：15
 * 解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
 * 示例 2：
 *
 * 输入：nums = [5,5,4,5,4,1,1,1], k = 0
 * 输出：20
 * 解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 2 * 10^4
 * 0 <= k < nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-score-of-a-good-subarray
 *
 * @see blogandquestion.algorithms.bytedance
 */
public class Four {
    public int maximumScore(int[] nums, int k) {
        int res = 0, l = k, r = k, pivot = nums[k];
        int n = nums.length;
        while (true) {
            while (l - 1 >= 0 && nums[l - 1] >= pivot) l--;
            while (r + 1 < n && nums[r + 1] >= pivot) r++;
            res = Math.max(res, pivot * (r - l + 1));
            // 如果遍历完成，退出，否则选取新的基准
            if (l == 0 && r == n - 1) break;
            else if (l == 0) pivot = nums[r + 1];
            else if (r == n - 1) pivot = nums[l - 1];
            else pivot = Math.max(nums[l - 1], nums[r + 1]);
        }
        return res;
    }
}

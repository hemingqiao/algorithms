package blogandquestion.algorithms.array.nextpermutation31;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/21 21:59:15
 * description:
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 100
 *     0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 *
 */
public class ExerciseSolution1 {
    public void nextPermutation(int[] nums) {
        int n = nums.length, k = n - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) k--;
        if (k <= 0) reverse(nums, 0, n - 1);
        else {
            int t = k;
            while (t < n && nums[t] > nums[k - 1]) t++;
            swap(nums, k - 1, t - 1);
            reverse(nums, k, n - 1);
        }
    }

    public void reverse(int[] q, int l, int r) {
        while (l < r) {
            swap(q, l++, r--);
        }
    }

    public void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
}

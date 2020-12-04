package blogandquestion.algorithms.array.nextpermutation31;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 13:40:46
 * description:
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 *
 * 参考：https://github.com/grandyang/leetcode/issues/31
 * 参考：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                int j;
                for (j = len - 1; j >= 0; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(nums, i, j);
                reverse(nums, i + 1, len - 1);
                return;
            }
        }
        reverse(nums, 0, len - 1);
    }

    // 反转给定数组的给定区间
    private void reverse(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low++, high--);
        }
    }

    // 交换给定数组中的两个元素
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

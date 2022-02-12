package src.binarysearch.singlenonduplicate540;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/22 22:34:51
 * description:
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 *
 * 参考：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-leetcode/
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0, right = len;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (mid + 1 < len && nums[mid] == nums[mid + 1]) {
                // mid右侧有偶数个，如 1 1 4 5 5 6 6 8 8 9 9
                if ((len - mid) % 2 == 0) {
                    right = mid;
                } else {
                    // mid左侧有偶数个，如 1 1 4 4 5 5 6 8 8
                    left = mid + 2;
                }
            } else if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                // mid左侧有偶数个，如 1 1 4 4 5 5 6 6 8 9 9
                if ((mid - 1) % 2 == 0) {
                    left = mid + 1;
                } else {
                    // mid右侧有偶数个，如 1 1 4 5 5 6 6 8 8
                    right = mid - 1;
                }
            } else {
                // 前面两个判断都不成立，即nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]
                // 此时nums[mid]就是目标值
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1,1,2,3,3,4,4,8,8};
        int res = s.singleNonDuplicate(test);
        System.out.println(res);
    }
}

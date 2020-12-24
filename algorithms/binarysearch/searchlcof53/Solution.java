package blogandquestion.algorithms.binarysearch.searchlcof53;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/24 19:14:08
 * description:
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 *
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 等于是找target出现的最小索引
            // 所以当mid处的值小于target时，向右侧推进，当mid处的值大于等于target时，向左侧推进
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 退出循环时先判断left是否等于length在统计数目
        if (left == nums.length || nums[left] != target) {
            return 0;
        }
        int ret = 1;
        for (int start = left; start < nums.length - 1; start++) {
            if (nums[start] == nums[start + 1]) {
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{2, 2};
        int target = 3;
        int res = s.search(test, target);
        System.out.println(res);
    }
}

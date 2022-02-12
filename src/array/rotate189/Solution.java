package src.array.rotate189;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 11:00:32
 * description:
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 *
 */
public class Solution {
    // 没有达到题目的要求，使用了额外的空间（O(n)）
    public void rotate(int[] nums, int k) {
        int target;
        int len = nums.length;
        int[] copy = nums.clone();
        for (int i = 0; i < len; i++) {
            target = (i + k) % len;
            nums[target] = copy[i];
        }
    }

    // 暴力求解，每轮移动一个位置，一共k轮
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = len - 1; j >= 1; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
 */
class AnotherSolution {
    /*
    思路是先把前 n-k 个数字翻转一下，再把后k个数字翻转一下，最后再把整个数组翻转一下：

    1 2 3 4 5 6 7
    4 3 2 1 5 6 7
    4 3 2 1 7 6 5
    5 6 7 1 2 3 4
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

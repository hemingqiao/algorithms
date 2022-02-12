package src.array.sortedsquares977;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 19:10:33
 * description:
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 *
 * 参考：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/shi-ji-chong-pai-xu-he-shuang-zhi-zhen-shuang-zhi-/
 */
public class Solution {
    // 要利用好原数组已经排好序的条件
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 0, right = len - 1;
        int idx = len - 1;
        // 注意下面包括等于，当nums数组只有一个元素时，仍需要处理
        while (left <= right) {
            // 如果left处的值和right处的值之和小于0，表明abs(left) > abs(right)
            if (nums[left] + nums[right] < 0) {
                res[idx--] = nums[left] * nums[left];
                left++;
            } else {
                res[idx--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {-7, -3, 2, 3, 11};
        Solution s = new Solution();
        int[] res = s.sortedSquares(test);
        System.out.println(Arrays.toString(res));
    }
}

package blogandquestion.algorithms.numbers.findduplicate287;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 11:51:49
 * description: 我们知道二分查找要求有序，但是给定的数组不是有序的，那么怎么用二分查找呢？
 * <p>
 * 原数组不是有序，但是我们知道重复的那个数字肯定是 1 到 n 中的某一个，而 1,2...,n 就是一个有序序列。因此可以对 1,2...,n 进行二分查找。
 * <p>
 * mid = (1 + n) / 2，接下来判断最终答案是在 [1, mid] 中还是在 [mid + 1, n] 中。
 * <p>
 * 我们只需要统计原数组中小于等于 mid 的个数，记为 count。
 * <p>
 * 如果 count > mid ，根据鸽巢原理，在 [1,mid] 范围内的数字个数超过了 mid ，所以一定有一个重复数字。
 * <p>
 * 否则的话，既然不在 [1,mid] ，那么最终答案一定在 [mid + 1, n] 中。
 * <p>
 * 解题思路
 * see: https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--52/
 */
public class AnotherSolution {
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

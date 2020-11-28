package blogandquestion.algorithms.doublepointer.increasingtriplet334;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 19:59:46
 * description:
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 *
 * 参考：https://leetcode-cn.com/problems/increasing-triplet-subsequence/solution/java-0ms-100-by-shi-wen/
 * 参考：https://leetcode-cn.com/problems/increasing-triplet-subsequence/solution/334-di-zeng-de-san-yuan-zi-xu-lie-liang-chong-si-l/
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // length小于3，可以直接返回false
        if (nums == null || nums.length < 3) return false;
        int len = nums.length;
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            // 因为题目限定递增（严格递增，不能存在两个相等）所以判断条件是小于等于
            if (num <= min) {
                min = num;
            } else if (num <= second) {
                // 进入这个if语句表明 min < num <= second
                second = num;
            } else {
                // num比min和second都要大，找到了要求的递增三元组
                return true;
            }
        }
        return false;
    }
}

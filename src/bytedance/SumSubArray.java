package src.bytedance;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/26 10:00:36
 * description:
 * @see https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class SumSubArray {
    /*
    给出一个无序数组，区间值定义为区间和乘上区间内的最小数的值，求区间值最大的区间
    @see https://leetcode-cn.com/circle/discuss/pv7bY1/
     */

    // brute force
    // O(n^2)
    public int minSubarrayValue(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int fixed = nums[i];
            int left = i - 1, right = i + 1;
            int sum = fixed;
            while (left >= 0 && nums[left] >= fixed) {
                sum += nums[left];
                left--;
            }
            while (right < n && nums[right] >= fixed) {
                sum += nums[right];
                right++;
            }
            res = Math.max(res, fixed * sum);
        }
        return res;
    }

    /*
    暴力法思路：
    题目是找max(区间和 * 区间最小值)，而满足的区间最小值一定是数组的某个元素。因此可以枚举数组，枚举时每个元素（设为x）作为区间最小值，
    在x左右两侧找到第一个比x小的元素，分别记录左右边界的下标为l,r，寻找边界时计算当前区间的和。那么以x为区间最小值的最大区间值一定是[l+1,r-1]
    区间和 * x。整个算法的时间复杂度是O(N²)。
     */

    public static void main(String[] args) {
        SumSubArray ssa = new SumSubArray();
        int[] test = new int[]{6, 2, 1};
        int res = ssa.minSubarrayValue1(test);
        System.out.println(res);
    }

    public int minSubarrayValue1(int[] nums) {
        int n = nums.length;
        // 前缀和数组，便于求解区间和
        // sum(i, j) = preSum[j] - preSum[i], i,j [0, n)
        int[] h = new int[n + 2];
        for (int i = 1; i < n + 1; i++) h[i] = nums[i - 1];
        int[] preSum = new int[n + 3];
        for (int i = 1; i <= n + 2; i++) preSum[i] = preSum[i - 1] + h[i - 1];
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        // 维护一个单调递增栈
        for (int i = 0; i < n + 2; i++) {
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                int cur = stack.pop();
                int left = stack.peek(); // 当前元素左侧第一个小于当前柱体的元素索引
                int right = i; // // 当前元素右侧第一个小于当前柱体的元素索引
                res = Math.max(res, (preSum[right] - preSum[left + 1]) * h[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}

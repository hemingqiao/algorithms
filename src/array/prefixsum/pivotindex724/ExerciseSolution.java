package src.array.prefixsum.pivotindex724;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/16 16:02:39
 * description:
 */
public class ExerciseSolution {
    // 1、利用前缀和求解
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int total = preSum[n];
        for (int i = 0; i < n; i++) {
            // preSum[i] == total - preSum[i + 1]
            if (preSum[i] + preSum[i + 1] == total) return i;
        }
        return -1;
    }

    // 2、朴素解法，比前缀和要快一些
    public int pivotIndex1(int[] nums) {
        int sum = 0, leftSum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            if (leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}

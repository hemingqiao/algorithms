package blogandquestion.algorithms.dp.sumRange303;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/01 08:26:09
 * description:
 * 二刷
 */
public class ExerciseSolution {
    static class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            int n = nums.length;
            preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }

        // sum(i, j) = preSum(j + 1) - preSum(i); // [i, j]
        public int sumRange(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }
}

package blogandquestion.algorithms.dp.rob213;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 10:44:26
 * description:
 * 房屋围成一圈说明nums[0]和nums[len - 1]不能同时偷，可以分为[0, len - 2] 和 [1, len - 1]两种情况求解，然后在比较这两种情况的最大值
 * see: src/blogandquestion/algorithms/dp/rob198
 */
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robAuxiliary(nums, 0, len - 2), robAuxiliary(nums, 1, len - 1));
    }

    private int robAuxiliary(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}

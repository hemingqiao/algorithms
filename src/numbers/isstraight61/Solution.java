package src.numbers.isstraight61;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/03 09:51:09
 * description:
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int cnt = 0; // 用来统计大小王得个数
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                ++cnt;
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) return false;
        }
        // 最大值减去最小值的差值小于等于4，如果没有大小王，就是连续的五个整数，如果存在大小王，因为最大减去最小小于等于4，大小王可以视为任意值
        // 而且在上面循环中确保了除去大小王外，不存在相等的两个数字
        return nums[n - 1] - nums[0 + cnt] <= 4;
    }
}

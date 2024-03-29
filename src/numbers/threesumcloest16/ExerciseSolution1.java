package src.numbers.threesumcloest16;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/23 22:46:20
 * description:
 */
public class ExerciseSolution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1, k = n - 1; j < k; j++) {
                while (j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= target) k--;
                int a = nums[i] + nums[j] + nums[k];
                // 因为上面的while循环可能不会进入，也即a的值可能回小于target，所以这里需要加上绝对值
                if (Math.abs(a - target) < delta) {
                    res = a;
                    delta = Math.abs(a - target);
                }
                // 确保 j 和 k - 1 不重叠
                // 而在这里，无论是否进入while循环，b的值都是小于target的，所以target - b一定大于0
                if (k - 1 > j) {
                    int b = nums[i] + nums[j] + nums[k - 1];
                    if (target - b < delta) {
                        res = b;
                        delta = target - b;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExerciseSolution1 es1 = new ExerciseSolution1();
        int[] test = {-1, 2, 1, -4};
        int res = es1.threeSumClosest(test, 1);
        System.out.println(res);
    }
}

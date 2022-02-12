package src.numbers.minsubarraylen209;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/20 08:24:41
 * description:
 */
public class ExerciseSolution {
    // 利用前缀和优化n^3的暴力算法
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= s) return 1;
            a[i] = a[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[j + 1] - a[i] >= s) res = Math.min(res, j - i + 1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 对于每一个右指针i，找到一个最靠右边的且满足区间和大于等于target的j
    // 此时，若i向右移动一位，则j也一定向右移动，而不会向左移动（j具有单调性）
    public int minSubArrayLen1(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j < i && sum - nums[j] >= s) sum -= nums[j++];
            if (sum >= s) res = Math.min(res, i - j + 1);
        }
        if (res == Integer.MAX_VALUE) res = 0;
        return res;
    }
}

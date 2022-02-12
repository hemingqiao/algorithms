package src.leetcodeweeklycontest.c231;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/07 10:28:10
 * description:
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 *
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 *
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 * 示例 2：
 *
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= limit <= 10^6
 * -limit <= nums[i] <= limit
 * -10^9 <= goal <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-elements-to-add-to-form-a-given-sum
 *
 */
public class Two {
    // TLE
    public int minElements(int[] nums, int limit, int goal) {
        int n = nums.length;
        long sum = 0; // 要用长整型，妈的，整型会溢出，坑死👴了
        int cnt = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        long delta = goal - sum;
        // 如果对delta取绝对值的话，就不需要进行下面的判断了
        if (delta < 0) {
            for (int i = limit; i >= 1; i--) {
                while (delta + i <= 0) {
                    ++cnt;
                    delta += i;
                }
                if (delta == 0) return cnt;
            }
        } else {
            for (int i = limit; i >= 1; i--) {
                while (delta - i >= 0) {
                    ++cnt;
                    delta -= i;
                }
                if (delta == 0) return cnt;
            }
        }
        return -1;
    }

    public int minElements1(int[] nums, int limit, int goal) {
        int n = nums.length;
        long sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        long delta = Math.abs(sum - goal);
        if (delta == 0) return 0;
        if (limit > delta) return 1;
        cnt += delta / limit;
        delta -= (long) cnt * limit;
        if (delta > 0) ++cnt;
        return cnt;
    }

    public int minElements2(int[] nums, int limit, int goal) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        long delta = Math.abs(goal - sum);
        if (delta == 0) return 0;
        // 做除法之前，需要先减1，这是因为结果需要向上取整。如 8 / 3 == 2，应输出3，而能够整除时，9 / 3 == 3，应输出3
        return (int) ((delta - 1) / limit + 1);
    }

    public static void main(String[] args) {
        Two two = new Two();
        int[] nums = new int[]{2, 2, 2, 5, 1, -2};
        int limit = 5;
        int goal = 126614243;
        int res = two.minElements(nums, limit, goal);
        System.out.println(res);
    }
}

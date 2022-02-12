package src.leetcodeweeklycontest.d49;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/04 21:25:52
 * description:
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 *  - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 *  - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 *
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-nice-pairs-in-an-array
 *
 */
public class Three {
    // 用了两数之和的思想
    // 另外：(a + b + c) % n == (a + b) % n + c == a % n + b % n + c % n
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = (int) (1e9 + 7);
        int ret = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = nums[i] - getRev(nums[i]);
            int p = map.getOrDefault(temp, 0);
            ret = (ret + p) % mod;
            map.put(temp, p + 1); // temp出现次数加1
        }
        return ret;
    }

    public int getRev(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

    public int countNicePairs1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = (int) (1e9 + 7);
        long ret = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = nums[i] - getRev(nums[i]);
            int p = map.getOrDefault(temp, 0);
            ret += p;
            map.put(temp, p + 1); // temp出现次数加1
        }
        return (int) (ret % mod);
    }
}

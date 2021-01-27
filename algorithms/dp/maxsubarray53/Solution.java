package blogandquestion.algorithms.dp.maxsubarray53;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/08 20:19:59
 * description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 *
 * 对于 a = [a, b, c, d, e]这样一个整数数组，用dp[i]表示以a[i]为子序列末端的最大子序列的和。
 * 如要比较以a[3]结尾的最大子序列的和，就需要比较以下序列：
 * a b c d
 *   b c d
 *     c d
 *       d
 * 而观察可以发现，前三个可以表示为以a[2]结尾的最大子序列之和与a[i]的和，问题就转化为比较dp[i - 1] + nums[i] 和 nums[i]之间的大小
 * 由此可以得到状态转移方程 dp[i] = max(dp[i - 1] + nums[i], nums[i])
 *
 * see: https://leetcode-cn.com/problems/maximum-subarray/solution/xiang-xi-jie-du-dong-tai-gui-hua-de-shi-xian-yi-li/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int length = nums.length;
        int[] dp = new int[length]; // dp[i]代表以i结尾的最大子序和
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}

/*
示例: [a, b , c, d , e]

解答这类题目, 省略不掉遍历, 因此先从遍历方式说起

通常我们遍历子串或者子序列有三种遍历方式

1、以某个节点为开头的所有子序列: 如 [a]，[a, b]，[ a, b, c] ... 再从以 b 为开头的子序列开始遍历 [b] [b, c]。

2、根据子序列的长度为标杆，如先遍历出子序列长度为 1 的子序列，在遍历出长度为 2 的 等等。

3、以子序列的结束节点为基准，先遍历出以某个节点为结束的所有子序列，因为每个节点都可能会是子序列的结束节点，因此要遍历下整个序列，
如: 以 b 为结束点的所有子序列: [a , b] [b] 以 c 为结束点的所有子序列: [a, b, c] [b, c] [ c ]。
第一种遍历方式通常用于暴力解法, 第二种遍历方式 leetcode (5. 最长回文子串 ) 中的解法就用到了。

第三种遍历方式 因为可以产生递推关系, 采用动态规划时, 经常通过此种遍历方式, 如 背包问题, 最大公共子串等,
这里的动态规划解法也是以 先遍历出 以某个节点为结束节点的所有子序列 的思路。
 */

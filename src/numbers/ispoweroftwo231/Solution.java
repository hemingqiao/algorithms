package src.numbers.ispoweroftwo231;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 16:50:39
 * description:
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 *
 */
public class Solution {
    // 利用位运算
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    // 或者是利用数学解法
    public boolean isPowerOfTwoOpt(int n) {
        if (n == 0) return false;
        return (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }

    public boolean isPowerOfTwoNormal(int n) {
        // 常规解法
        if (n == 0) return false;
        while(n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwoNormal(1));
    }
}

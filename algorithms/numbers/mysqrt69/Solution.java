package blogandquestion.algorithms.numbers.mysqrt69;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/07 10:21:08
 * description: 可以视为求解f(x) = x² - a 的解。f(0) = -a < 0, f(a) = a² - a >= 0 (a >= 1); 单独考虑a = 0的情况，其余情况
 * 解位于[1, a]之内。
 * 很迷。
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 *
 */
public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        int mid, res;
        while (left <= right) {
            mid = (left + right) / 2;
            res = x / mid;
            if (res == mid) {
                return mid;
            } else if (mid > res) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

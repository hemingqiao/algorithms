package blogandquestion.algorithms.binarysearch.mysqrt69;

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

    /**
     * 推荐使用这个方法
     *
     * 参考：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
     *
     * @param x
     * @return
     */
    public int mySqrtOpt(int x) {
        // 由于x平方根的整数部分是ans是满足k^2 <= x的k的最大值
        // 可以对k进行二分查找
        int left = 0, right = x, answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                // 由于是寻找使得k^2 <= x的最大k值，一旦满足mid * mid小于等于x，就更新answer的值
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.mySqrtOpt(5);
        System.out.println(res);
    }
}

class AnotherSolution {
    public int mySqrt(int x) {
        double x0 = x / 2.0;
        while (Math.abs(x0 * x0 - x) > 0.0001) {
            x0 = (x0 + x / x0) / 2;
        }
        double res = Math.ceil(x0);
        if (res - x0 < 0.001) {
            return (int) (res);
        }
        return (int) res - 1;
    }

    /**
     * 使用牛顿迭代法
     *
     * @param x
     * @return
     */
    public int mySqrtOpt(int x) {
        double x0 = x;
        while (Math.abs(x0 * x0 - x) > 1e-5) {
            x0 = (x0 + x / x0) / 2;
        }
        // double类型转为int时会进行截断
        return (int) x0;
    }

    public static void main(String[] args) {
        AnotherSolution s = new AnotherSolution();
        int res = s.mySqrtOpt(16);
        System.out.println(res);
    }
}

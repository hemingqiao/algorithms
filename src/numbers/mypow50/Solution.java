package src.numbers.mypow50;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/18 21:35:47
 * description: 二分的思想。
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 */
public class Solution {
    public double myPow(double x, int n) {
        int N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, int n) {
        if (n == 0) return 1.0;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}

class AnotherSolution {
    // 会溢出
    public double myPow(double x, int n) {
        if (n == 0) return 1; // base case（递归出口）
        if (n < 0) return myPow(1/x, -n);
        // 利用二分法
        if ((n & 1) == 1) return x * myPow(x, n - 1); // 如果n为奇数，单独抽出一个x使得n - 1为偶数
        double temp = myPow(x, n >> 1); // n为偶数，对半分，递归计算下去
        return temp * temp;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        double res = as.myPow(1.0, -2147483648);
        System.out.println(res);
    }
}

class AnotherSolutionOpt {
    public double myPow(double x, int n) {
        return myPowAuxiliary(x, n);
    }

    // 定义一个辅助方法，如果n为-2147483648，将其转为正数时就不至于溢出
    public double myPowAuxiliary(double x, long n) {
        if (n == 0) return 1; // base case（递归出口）
        if (n < 0) return myPowAuxiliary(1/x, -n);
        // 利用二分法
        if ((n & 1) == 1) return x * myPowAuxiliary(x, n - 1); // 如果n为奇数，单独抽出一个x使得n - 1为偶数
        double temp = myPowAuxiliary(x, n >> 1); // n为偶数，对半分，递归计算下去
        return temp * temp;
    }

    public static void main(String[] args) {
        System.out.println(new AnotherSolutionOpt().myPow(1.0, -2147483648));
    }
}

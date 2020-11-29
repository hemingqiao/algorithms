package blogandquestion.algorithms.numbers.tribonacci1137;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/29 20:24:44
 * description:
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *  
 *
 * 提示：
 *
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 *
 */
public class Solution {
    // 记忆化
    public int tribonacci(int n) {
        return tribonacci(n, new int[n + 1]);
    }

    public int tribonacci(int n, int[] memo) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 1;
        if (memo[n] != 0) {
            return memo[n];
        }
        int res = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo[n] = res;
        return res;
    }
}

class AnotherSolution {
    // 尾递归
    public int tribonacci(int n) {
        return tribonacciTail(n, 0, 1, 1);
    }

    public int tribonacciTail(int n, int a, int b, int c) {
        if (n == 0) return a;
        if (n == 1) return b;
        return tribonacciTail(n - 1, b, c, a + b + c);
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        for (int i = 0; i < 10; i++) {
            System.out.println(as.tribonacci(i));
        }
    }
}

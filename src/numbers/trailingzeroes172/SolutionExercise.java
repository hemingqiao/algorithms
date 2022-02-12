package src.trailingzeroes172;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/03 15:35:22
 * description:
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 */
public class SolutionExercise {
    public int trailingZeroes(int n) {
        double num = factorial(n, 1);
        int x = 0;
        while (true) {
            double y = num % 10;
            num /= 10;
            if (y == 0) {
                x++;
            } else {
                break;
            }
        }
        return x;
    }

    public double factorial(int n, double num) {
        if (n == 0) {
            return num;
        }

        return factorial(n - 1, num * n);
    }

    public static void main(String[] args) {
        SolutionExercise s = new SolutionExercise();
        for (int i = 0; i <= 20; i++) {
            System.out.println(s.factorial(i, 1));
        }
    }
}

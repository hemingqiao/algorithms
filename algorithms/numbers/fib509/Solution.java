package blogandquestion.algorithms.numbers.fib509;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 10:20:15
 * description:
 */
public class Solution {
    // 借助于尾递归
    public int fib(int n) {
        return fibAuxiliary(n, 0, 1);
    }

    private int fibAuxiliary(int n, int a, int b) {
        if (n == 0) return a;
        return fibAuxiliary(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(s.fib(i));
        }
    }
}

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

class AnotherSolution {
    // 记忆化
    public int fib(int n) {
        return fibAux(n, new int[n + 1]);
    }

    // 求解某个斐波那契数时，会一直递归到最底层的base case处，然后计算一些值，在此时这些最底层的值被缓存了下来
    // 求解上层的值时就方便很多
    public int fibAux(int n, int[] memo) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        if (memo[n] != 0) {
            return memo[n];
        }
        int res = fibAux(n - 1, memo) + fibAux(n - 2, memo);
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        for (int i = 0; i < 10; i++) {
            System.out.println(as.fib(i));
        }
    }
}

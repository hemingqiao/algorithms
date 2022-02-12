package src.hashtable.longestvalidparentheses32;

import java.util.Stack;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/21 19:28:50
 * description:
 * 二刷，不行，这题还得多刷
 * 参考：https://github.com/grandyang/leetcode/issues/32
 * 参考：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 */
public class ExerciseSolution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    // 这个有点牛，就是不好想到
    public int longestValidParentheses1(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // 动态规划解法
    // dp[i]表示以i处的字符结尾的最长有效括号的长度
    public int longestValidParentheses2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "()";
        int res = es.longestValidParentheses1(test);
        System.out.println(res);
    }
}

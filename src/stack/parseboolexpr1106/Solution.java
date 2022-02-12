package src.stack.parseboolexpr1106;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/06 18:56:53
 * description:
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 *
 * 有效的表达式需遵循以下约定：
 *
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *  
 *
 * 示例 1：
 *
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 *
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 *
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 *
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/parsing-a-boolean-expression
 *
 * 参考：https://leetcode-cn.com/problems/parsing-a-boolean-expression/solution/java-ti-jie-by-huangzhouwu/
 */
public class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char cur = expression.charAt(i);
            Deque<Character> temp = new ArrayDeque<>();
            if (cur == ',') continue;
            if (cur != ')') {
                stack.push(cur);
            } else {
                while (stack.peek() != '(') {
                    temp.push(stack.pop());
                }
                stack.pop(); // 弹出左括号(
                char operator = stack.pop(); // 弹出操作符
                stack.push(parseBlock(temp, operator));
            }
        }
        return stack.pop() == 't';
    }

    public Character parseBlock(Deque<Character> stack, char operator) {
        switch (operator) {
            case '!':
                return stack.pop() == 't' ? 'f' : 't';
            case '&':
                while (!stack.isEmpty()) {
                    if (stack.pop() == 'f') {
                        return 'f';
                    }
                }
                return 't';
            case '|':
                while (!stack.isEmpty()) {
                    if (stack.pop() == 't') {
                        return 't';
                    }
                }
                return 'f';
            default:
                return null;
        }
    }
}

class AnotherSolution {
    private int idx = 0;

    public boolean parseBoolExpr(String expression) {
        char ch = expression.charAt(idx++);
        if (ch == 't') {
            return true;
        }
        if (ch == 'f') {
            return false;
        }
        if (ch == '!') {
            idx++;
            boolean temp = parseBoolExpr(expression);
            idx++;
            return !temp;
        }
        if (ch == '&') {
            idx++;
            boolean res = true;
            while (true) {
                res &= parseBoolExpr(expression);
                if (expression.charAt(idx++) == ')') break;
            }
            return res;
        }
        // 此时只剩下|一种情况
        idx++;
        boolean res = false;
        while (true) {
            res |= parseBoolExpr(expression);
            if (expression.charAt(idx++) == ')') break;
        }
        return res;
    }
}

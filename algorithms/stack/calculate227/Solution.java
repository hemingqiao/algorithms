package blogandquestion.algorithms.stack.calculate227;

import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/07 19:01:22
 * description:
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 *
 * 参考：https://github.com/grandyang/leetcode/issues/227
 */
public class Solution {
    // 没有下面的解法好理解
    public int calculate(String s) {
        int res = 0, cur = 0, num = 0, n = s.length();
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
                switch (operator) {
                    case '+':
                        cur += num;
                        break;
                    case '-':
                        cur -= num;
                        break;
                    case '*':
                        cur *= num;
                        break;
                    case '/':
                        cur /= num;
                        break;
                }
                if (c == '+' || c == '-' || i == n - 1) {
                    res += cur;
                    cur = 0;
                }
                operator = c;
                num = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "3+2*2/1";
        int res = s.calculate(test);
        System.out.println(res);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/basic-calculator-ii/solution/li-yong-zhan-jiang-si-ze-yun-suan-hua-jian-cheng-j/
 * 参考：https://leetcode-cn.com/problems/basic-calculator-ii/solution/li-yong-zhan-jiang-si-ze-yun-suan-hua-jian-cheng-j/254693
 */
class AnotherSolution {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        s = s + "#"; // 避免遍历到最后越界
        int res = 0, cur = 0; // 最终结果、当前数字
        char preOperator = '+'; // 前一个运算符
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue; // 跳过空格
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + (c - '0');
            } else {
                switch (preOperator) {
                    case '+':
                        numStack.push(cur);
                        break;
                    case '-':
                        numStack.push(-cur);
                        break;
                    case '*':
                        numStack.push(numStack.pop() * cur);
                        break;
                    case '/':
                        numStack.push(numStack.pop() / cur);
                        break;
                }
                cur = 0; // 数字归零，重新计算
                preOperator = c; // 更新运算符
            }
        }
        while (!numStack.isEmpty()) {
            res += numStack.pop();
        }
        return res;
    }

    private int res(char op, int a, int b) {
        if (op == '*') return a * b;
        else if (op == '/') return a / b;
        else if (op == '+') return a + b; //其实加减运算可以忽略
        else return a - b;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        String test = "3+2*2/1";
        int res = as.calculate(test);
        System.out.println(res);
    }
}

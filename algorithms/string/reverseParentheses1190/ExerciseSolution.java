package blogandquestion.algorithms.string.reverseParentheses1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/26 21:06:19
 * description:
 */
public class ExerciseSolution {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (t == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                int m = sb.length();
                for (int j = 0; j < m; j++) stack.push(sb.charAt(j));
            } else {
                stack.push(t);
            }
        }
        StringBuilder ret = new StringBuilder();
        for (char c : stack) ret.append(c);
        return ret.reverse().toString();
    }
}

class AnotherSolution {
    char[] deque = new char[2009];
    int head = 0, tail = -1;
    char[] path = new char[2009];

    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            // 遇到反括号时，向前遍历到正括号，将这一段序列借助path数组进行反转
            if (t == ')') {
                int idx = 0;
                while (tail >= head) {
                    if (deque[tail] == '(') {
                        // 将序列从path中复制回deque中
                        for (int j = 0; j < idx; j++) {
                            deque[tail++] = path[j];
                        }
                        // 上面循环中tail++，先赋值，在自增，导致最后tail大了1，需要减去
                        --tail;
                        break;
                    } else {
                        path[idx++] = deque[tail--];
                    }
                }
            } else {
                deque[++tail] = t;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (tail >= head) sb.append(deque[head++]);
        return sb.toString();
    }

    public String reverseParentheses1(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == ')') {
                int idx = 0;
                while (tail >= head) {
                    if (deque[tail] == '(') {
                        tail--;
                        for (int j = 0; j < idx; j++) {
                            deque[++tail] = path[j];
                        }
                        break;
                    } else {
                        path[idx++] = deque[tail--];
                    }
                }
            } else {
                deque[++tail] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (tail >= head) sb.append(deque[head++]);
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "(u(love)i)";
        String s = "(abcd)";
        AnotherSolution as = new AnotherSolution();
        String res = as.reverseParentheses(s);
        System.out.println(res);
    }
}

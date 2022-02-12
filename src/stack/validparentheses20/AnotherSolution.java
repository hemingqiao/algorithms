package src.stack.validparentheses20;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/17 11:47:30
 * description:
 */
public class AnotherSolution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) { // 左括号，入栈
                stack.addFirst(c);
            } else { // 右括号
                if (!stack.isEmpty()) { // 栈非空
                    if (map.get(stack.pop()) != c) {
                        // 如果左右括号不匹配，返回false
                        return false;
                    }
                } else {
                    // 栈为空，但是此时遇到右括号，返回false
                    return false;
                }
            }
        }
        // 当遍历结束时栈为空，表明没有遇到无效符号，返回true
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) { // 左括号，入栈
                stack.push(c);
            } else { // 右括号
                if (!stack.isEmpty()) { // 如果此时栈非空（栈内有左括号）
                    if (map.get(stack.pop()) != c) {
                        // 如果左右括号不匹配，返回false
                        return false;
                    }
                } else {
                    // 栈为空，但是此时遇到右括号，返回false
                    return false;
                }
            }
        }
        // 当遍历结束时栈为空，表明没有遇到无效符号，返回true
        return stack.isEmpty();
    }

    /**
     * 这个执行速度比前两个使用map和stack的快上1ms（20%）
     * @param s 待判断的字符串
     * @return 字符串合法返回true，否则返回false
     */
    public boolean isValid3(String s) {
        Stack<Character> stack = new Stack<>();
        // 遍历字符
        for (char c : s.toCharArray()) {
            // 遇到左括号就压栈。否则判断遇到右括号时栈是否为空，或者左右括号是否匹配
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        // 字符遍历完后，如果stack为空，表明没有遇到非法字符
        return stack.isEmpty();
    }
}

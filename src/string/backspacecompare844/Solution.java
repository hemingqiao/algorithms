package src.string.backspacecompare844;


import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/19 20:57:56
 * description: 维护两个栈，时间效率不是很高，因为最后还要比较两个栈中的元素。只能击败54。
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 *
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;
        Stack<Character> sourceStack = new Stack<>();
        Stack<Character> targetStack = new Stack<>();
        int i = 0, j = 0;
        while (i < S.length()) {
            if (S.charAt(i) != '#') {
                sourceStack.push(S.charAt(i));
            } else if (!sourceStack.isEmpty()) {
                sourceStack.pop();
            }
            i++;
        }
        while (j < T.length()) {
            if (T.charAt(j) != '#') {
                targetStack.push(T.charAt(j));
            } else if (!targetStack.isEmpty()){
                targetStack.pop();
            }
            j++;
        }

        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        while (!sourceStack.isEmpty()) {
            s.append(sourceStack.pop());
        }
        while (!targetStack.isEmpty()) {
            t.append(targetStack.pop());
        }

        return s.toString().equals(t.toString());
    }
}

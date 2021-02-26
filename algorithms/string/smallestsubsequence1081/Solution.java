package blogandquestion.algorithms.string.smallestsubsequence1081;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/26 20:44:00
 * description:
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 *
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 *
 * @see blogandquestion.algorithms.greedy.removeduplicateletters316.ExerciseSolution
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Deque<Character> queue = new ArrayDeque<>();
        // set用来判断结果队列中是否含有某个字符，set判断时间复杂度是O(1)，直接用队列判断时间复杂度是O(n)
        Set<Character> set = new HashSet<>();
        // map用来记录每个字符出现的最后位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(chars[i], i);
        }
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            // 如果结果队列中不含有c字符
            if (!set.contains(c)) {
                // 如果此时队列非空，队尾元素的字典序大于字符c的字典序且队尾字符在后面还会出现的话，将队尾字符移除
                while (!queue.isEmpty() && queue.peekLast() > c && map.get(queue.peekLast()) > i) {
                    set.remove(queue.pollLast());
                }
                set.add(c);
                queue.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : queue) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String removeDuplicateLetters1(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[128];
        for (char c : chars) {
            ++counts[c];
        }
        char[] stack = new char[chars.length];
        boolean[] inStack = new boolean[128];
        int stackIndex = 0;
        // 贪心 没在栈里的进栈
        // 已经进栈的就不进了
        // 如果当前字符不在栈中，则和栈顶的进行字符比较，如果栈顶字符在后面还会出现且栈顶字符的字典序大于当前字符的字典序，则将栈顶字符出栈
        for (char c : chars) {
            --counts[c];
            if (!inStack[c]) {
                while (stackIndex > 0 && c < stack[stackIndex - 1] && counts[stack[stackIndex - 1]] > 0) {
                    --stackIndex;
                    inStack[stack[stackIndex]] = false; // 栈顶元素出栈
                }
                stack[stackIndex++] = c; // 新字符入栈
                inStack[c] = true;
            }
        }
        return new String(stack, 0, stackIndex);
    }
}

package src.greedy.removeduplicateletters316;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/11 19:08:33
 * description:
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
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
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 *
 * 参考：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/qu-chu-zhong-fu-zi-mu-by-leetcode/
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // 栈用来存储字符
        char[] source = s.toCharArray();
        int len = source.length;
        Set<Character> visited = new HashSet<>(); // 用来判断某个字符是否在栈中，set判断时间复杂度是O(1)，直接用栈判断时间复杂度是O(n)
        Map<Character, Integer> map = new HashMap<>(); // map用来记录每个字符最后出现的位置
        for (int i = 0; i < len; i++) {
            map.put(source[i], i);
        }
        for (int i = 0; i < len; i++) {
            char c = source[i];
            // 如果字符c不在栈中
            if (!visited.contains(c)) {
                // 如果栈非空，栈顶元素的字典序大于字符c的字典序且栈顶元素在后面还会出现，将栈顶元素弹出
                while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > i) {
                    visited.remove(stack.pop());
                }
                visited.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (char c : stack) {
            sb.insert(0, c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "cbacdcbc";
        String res = s.removeDuplicateLetters(test);
        System.out.println(res);
    }
}


/**
 * 参考：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/zhan-by-liweiwei1419/
 */
class AnotherSolution {
    // 为栈加一个哨兵
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // 栈用来存储字符
        stack.push('a');
        char[] source = s.toCharArray();
        int len = source.length;
        Set<Character> visited = new HashSet<>(); // 用来判断某个字符是否在栈中，set判断时间复杂度是O(1)，直接用栈判断时间复杂度是O(n)
        Map<Character, Integer> map = new HashMap<>(); // map用来记录每个字符最后出现的位置
        for (int i = 0; i < len; i++) {
            map.put(source[i], i);
        }
        for (int i = 0; i < len; i++) {
            char c = source[i];
            // 如果字符c不在栈中
            if (!visited.contains(c)) {
                // 如果栈非空，栈顶元素的字典序大于字符c的字典序且栈顶元素在后面还会出现，将栈顶元素弹出
                // 因为栈底加入了一个哨兵'a'，所以栈一定不为空，判断栈非空可以去掉
                while (stack.peek() > c && map.get(stack.peek()) > i) {
                    visited.remove(stack.pop());
                }
                visited.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        // 遍历到size - 1，移除最开始添加的哨兵
        for (int i = 0; i < size - 1; i++) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    /**
     * 不使用哈希表，使用数组来记录字符串的位置和是否存在于栈中
     * @param s
     * @return
     */
    public String removeDuplicateLetters1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();

        // 第 1 步：记录每个字符出现的最后一个位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        // 第 2 步：使用栈得到题目要求字典序最小的字符串
        Deque<Character> stack = new ArrayDeque<>();
        // 栈中有的字符记录在这里
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            char currentChar = charArray[i];
            // 如果栈中已经存在，就跳过
            if (visited[currentChar - 'a']) {
                continue;
            }

            // 在栈非空，当前元素字典序 < 栈顶元素，并且栈顶元素在以后还会出现，弹出栈元素
            while (!stack.isEmpty() && currentChar < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                char top = stack.removeLast();
                visited[top - 'a'] = false;
            }

            stack.addLast(currentChar);
            visited[currentChar - 'a'] = true;
        }

        // 第 3 步：此时 stack 就是题目要求字典序最小的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

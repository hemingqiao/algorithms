package blogandquestion.algorithms.leetcodeweeklycontest.c242;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/23 12:53:24
 * description:
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
 *
 * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 * s[j] == '0'.
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * 示例 2：
 *
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 2 <= s.length <= 10^5
 * s[i] 要么是 '0' ，要么是 '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-vii
 *
 * 参考：https://leetcode-cn.com/problems/jump-game-vii/solution/tiao-yue-you-xi-vii-dui-lie-hua-dong-chu-kpac/
 */
public class Three {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (chars[n - 1] == '1') return false;
        // 队列用来保存能够跳到的点的集合
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        for (int i = 1; i < n; i++) {
            // 如果队列首部的点已经被移出窗口，将这个点从队列中弹出
            while (!queue.isEmpty() && queue.peekFirst() + maxJump < i) {
                queue.pollFirst();
            }
            if (!queue.isEmpty() && chars[i] == '0' && i >= queue.peekFirst() + minJump) {
                if (i == n - 1) return true;
                queue.offer(i);
            }
        }
        return false;
    }
}

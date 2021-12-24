package blogandquestion.algorithms.graph.openlock752;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/25 20:13:57
 * description:
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由
 * 旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 *
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target)) return 0;
        Set<String> set = new HashSet<>();
        for (String s : deadends) set.add(s);
        if (set.contains(start)) return -1;
        Map<String, Integer> dist = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        dist.put(start, 0);
        while (!queue.isEmpty()) {
            String t = queue.poll();
            // 一共四个锁盘
            for (int i = 0; i < 4; i++) {
                // 每次可以将锁变大1或者减小1
                for (int j = -1; j <= 1; j += 2) {
                    StringBuilder state = new StringBuilder(t);
                    state.setCharAt(i, (char) ((state.charAt(i) - '0' + j + 10) % 10 + 48));
                    String a = state.toString();
                    // map中没有记录这个状态字符串对应的距离，并且这个状态不在deadends中
                    if (!dist.containsKey(a) && !set.contains(a)) {
                        // 状态 a 由状态 t 转化而来
                        dist.put(a, dist.get(t) + 1);
                        if (a.equals(target)) return dist.get(a);
                        queue.offer(a);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] test = {"0201", "0101", "0102", "1212", "2002"};
        int res = s.openLock(test, "0202");
        System.out.println(res);
    }
}

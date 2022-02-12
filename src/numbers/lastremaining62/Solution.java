package src.numbers.lastremaining62;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/03 10:25:29
 * description:
 * 参考：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        int index = 0; // 最终活下来的那个人的初始索引必定为0
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }

    // 单纯模拟
    // TLE
    public int lastRemaining1(int n, int m) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) queue.offer(i);
        int cnt = 1;
        while (queue.size() > 1) {
            int first = queue.poll();
            if (cnt % m == 0) {
                cnt = 1;
                continue;
            }
            queue.offer(first);
            cnt++;
        }
        return queue.poll();
    }
}

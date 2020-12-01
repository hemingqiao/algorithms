package blogandquestion.algorithms.linkedlist.nextlargernodes1019;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 12:38:21
 * description:
 * 参考：https://leetcode-cn.com/problems/next-greater-node-in-linked-list/solution/5chong-jie-jue-fang-shi-tu-wen-xiang-jie-by-sdwwld/
 */
public class AnotherSolution {
    // 维护一个单调栈
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> container = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            container.add(p.val);
            p = p.next;
        }

        // 栈中存储的是下标（索引），且下标对应的值从栈底到栈顶是递减的
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[container.size()];
        for (int i = 0; i < container.size(); i++) {
            // 如果栈非空，且当前索引对应的元素值大于栈顶索引对应的元素值，将栈顶元素出栈
            while (!stack.isEmpty() && container.get(stack.peek()) < container.get(i)) {
                int idx = stack.pop();
                res[idx] = container.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}

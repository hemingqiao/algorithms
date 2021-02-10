package blogandquestion.algorithms.doublepointer.detectcycle142;

import blogandquestion.algorithms.doublepointer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/10 10:10:39
 * description:
 * 二刷
 * 具体证明参见：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 */
public class ExerciseSolution {
    // 常规思路，使用哈希表
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // 快慢指针解法
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 链表中存在环
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}

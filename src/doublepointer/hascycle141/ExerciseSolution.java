package src.doublepointer.hascycle141;

import src.doublepointer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/10 09:29:10
 * description:
 * 参考：https://leetcode-cn.com/problems/linked-list-cycle/solution/xiang-jie-wei-shi-yao-yong-yi-bu-liang-b-i6xo/
 */
public class ExerciseSolution {
    // 用哈希表存储所有已经访问过的节点，每次遍历到一个节点时，判断这个节点是否存在于哈希表中
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (!set.add(p)) return true;
            p = p.next;
        }
        return false;
    }

    // 快慢指针解法
    public boolean hasCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    /*
    为什么一步两步快慢指针可以确定链表中存在环？

    如果快指针一次走两步，慢指针一次走一步，如果两者经过t时间后相遇（表明有环），设慢指针每单位时间走一步，所以t时间后，快指针走了2t步，
    慢指针走了t步，两者步数差为t。

    为什么保证会相遇：要使得快慢指针可能相遇，需要两者的步数差t为环的长度L的整数倍，（显然存在这样的t，如t为L的整数倍），而一旦两者可能相遇，
    那么下次肯定会相遇。

    快指针一次走三步、或者走四步可以吗？
        可以，走三步则相遇时的步数差为2t，只需要2t为L的整数倍即可
        走四步需要3t为L的整数倍
     */
}

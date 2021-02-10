package blogandquestion.algorithms.doublepointer.detectcycle142;


import blogandquestion.algorithms.doublepointer.ListNode;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 10:37:11
 * description: 使用快慢指针。
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 *
 * 解题思路：
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 判断是否有环
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    // 检测到有环之后，slow指针指向开头
                    // 之后fast和slow每次各走一步，再次相遇时就是环的入口
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

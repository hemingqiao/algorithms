package blogandquestion.algorithms.doublepointer.hascycle141;

import blogandquestion.algorithms.doublepointer.ListNode;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 10:24:41
 * description: 使用快慢指针
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 *
 * 解题思路：
 * see: https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/shuang-zhi-zhen-ji-qiao#yi-kuai-man-zhi-zhen-de-chang-jian-suan-fa
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}


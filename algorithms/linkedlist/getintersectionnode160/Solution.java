package blogandquestion.algorithms.linkedlist.getintersectionnode160;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 13:32:14
 * description:
 */
public class Solution {
    // 使用集合进行判断
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> setB = new HashSet<>();
        ListNode tempB = headB;
        while (tempB != null) {
            setB.add(tempB);
            tempB = tempB.next;
        }
        while (headA != null) {
            if (setB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/ji-he-shuang-zhi-zhen-deng-3chong-jie-jue-fang-s-2/
 */
class AnotherSolution {
    // 双指针解法，有点不好想
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            // 如果tempA指针走到了链表A的末尾，将这个指针移到链表B的开头
            tempA = tempA.next == null ? tempB : tempA.next;
            // 如果tempB指针走到了链表B的末尾，将这个指针移到链表A的开头
            tempB = tempB.next == null ? tempA : tempB.next;
        }
        // tempA要么是null，要么是两个链表的交点
        return tempA;
    }
}

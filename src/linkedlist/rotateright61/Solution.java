package src.linkedlist.rotateright61;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 15:47:03
 * description:
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 *
 * 参考：https://leetcode-cn.com/problems/rotate-list/solution/61-xuan-zhuan-lian-biao-tu-wen-xiang-jie-by-sdwwld/
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode fast = head, slow = head;
        int len = 1; // 记录链表长度
        // 找到链表的尾节点
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        fast.next = head; // 将链表首尾相连，成环
        int steps = len - k % len; // 慢指针移动的步数
        while (steps-- > 1) { // 大于1实际上少移动了1步
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null; // 将环打开
        return temp;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null) return head;
        ListNode fast = head, slow = head;
        //链表的长度
        int len = 1;
        //统计链表的长度，顺便找到链表的尾结点
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }
        //首尾相连，先构成环
        fast.next = head;
        //慢指针移动的步数
        int step = len - k % len;
        //移动步数，这里大于1实际上是少移了一步
        while (step-- > 1) {
            slow = slow.next;
        }
        //temp就是需要返回的结点
        ListNode temp = slow.next;
        //因为链表是环形的，slow就相当于尾结点了，
        //直接让他的next等于空
        slow.next = null;
        return temp;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

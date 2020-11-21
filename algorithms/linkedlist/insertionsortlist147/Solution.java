package blogandquestion.algorithms.linkedlist.insertionsortlist147;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/20 22:15:40
 * description:
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE); // 定义一个哑节点
        dummy.next = head;
        ListNode insertPos = dummy; // 初始插入位置是头结点处
        while (head != null && head.next != null) {
            // 移动head节点，如果head的值小于head.next的值，这两个节点是有序的，无需交换，head直接后移
            if (head.val < head.next.val) {
                head = head.next;
                continue;
            }
            // 如果此时插入位置处的值大于等于待插入节点的值，将insertPos重新移到头结点处
            if (insertPos.val >= head.next.val) {
                insertPos = dummy;
            }
            // 找到合适的插入位置（初始是头结点处）
            while (insertPos.next.val < head.next.val) {
                insertPos = insertPos.next;
            }
            // 将head.next插入到insertPos位置处
            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = insertPos.next;
            insertPos.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(4);
        test.next = new ListNode(2);
        test.next.next = new ListNode(1);
        test.next.next.next = new ListNode(3);
        test.next.next.next.next = null;
        ListNode res = new Solution().insertionSortList(test);
        System.out.println(res);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

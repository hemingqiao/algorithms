package src.linkedlist.insertionsortlist147;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 09:35:39
 * description:
 */
public class AnotherSolution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode insertPos = dummy;

        while (head != null) {
            ListNode temp = head.next;

            /* Before insert, the insertPos is at the last node of the sorted list.
            Only the last node's value is larger than the current inserting node
            should we move the temp(insertPos) back to the head*/
            // 如果待插入位置（insertPos）处的值大于等于待插入的节点的值，将insertPos重新移到头结点处，寻找合适的插入位置
            if (insertPos.val >= head.val) insertPos = dummy;

            // 从insertPos处开始，寻找合适的插入位置
            while (insertPos.next != null && insertPos.next.val < head.val) {
                insertPos = insertPos.next;
            }

            // 局部有序时不需要交换
            if (insertPos.next != head) {
                head.next = insertPos.next;
                insertPos.next = head;
                head = temp;
            }
        }
        return dummy.next;
    }
}

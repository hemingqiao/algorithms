package blogandquestion.algorithms.linkedlist.mergeklists23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/23 17:12:15
 * description:
 */
public class HeapSolution {
    // 使用小顶堆
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) { // l非空时才加入到堆中
                queue.add(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            ListNode rest = temp.next;
            // 链表剩余部分非空时，才加入到堆中
            if (rest != null) {
                queue.add(rest);
            }
            temp.next = null;
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
}

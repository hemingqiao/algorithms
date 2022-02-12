package src.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/28 22:27:03
 * description:
 * 用处不大
 */
public class ConstructLinkedList {
    public ListNode construct(int[] arr) {
        ListNode dummy = new ListNode(-1);
        for (int num : arr) {
            dummy.next = new ListNode(num);
        }
        return dummy.next;
    }

    public List<Integer> linkedlistToArray(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
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

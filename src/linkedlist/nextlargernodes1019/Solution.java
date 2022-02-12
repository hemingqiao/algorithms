package src.linkedlist.nextlargernodes1019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 11:13:35
 * description:
 */
public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> container = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            container.add(p.val);
            p = p.next;
        }
        int[] res = new int[container.size()];
        for (int i = 0; i < res.length; i++) {
            int temp = container.get(i);
            for (int j = i + 1; j < container.size(); j++) {
                if (container.get(j) > temp) {
                    res[i] = container.get(j);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = new ListNode(2);
        l.next = new ListNode(7);
        l.next.next = new ListNode(4);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(5);
        int[] res = s.nextLargerNodes(l);
        System.out.println(Arrays.toString(res));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

package blogandquestion.algorithms.linkedlist.deletenode237;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 17:04:36
 * description:
 *
 */
public class Solution {
    // 给定链表中的一个节点，然后从链表中删除这个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

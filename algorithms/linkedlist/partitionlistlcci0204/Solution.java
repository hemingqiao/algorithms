package blogandquestion.algorithms.linkedlist.partitionlistlcci0204;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 14:44:19
 * description:
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 *
 * 参考：https://leetcode-cn.com/problems/partition-list-lcci/solution/shuang-zhi-zhen-javashuang-100-by-tcl_love/
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode leftDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode rightDummy = new ListNode(-1);
        ListNode right = rightDummy;
        ListNode next;
        while (head != null) {
            next = head.next; // 记录当前节点的下一个节点

            // 节点值小于x的节点链接到左链表，其余的链接在右链表上
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head.next = null; // 断开与原链表之间的连接，否则，left链表和right链表会连接到原链表上，导致错误
            head = next;
        }
        // 将左右两段链表拼到一起
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
 }

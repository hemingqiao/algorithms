package src.linkedlist.oddevenlist328;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 19:03:26
 * description:
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 *
 * 参考：https://leetcode-cn.com/problems/odd-even-linked-list/solution/kuai-lai-wu-nao-miao-dong-qi-ou-lian-biao-by-sweet/
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenDummy = new ListNode(-1); // 偶数链表的哑节点
        ListNode evenCur = evenDummy;
        ListNode oddDummy = new ListNode(-1); // 奇数链表的哑节点
        ListNode oddCur = oddDummy;
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                // 奇数
                oddCur.next = head;
                oddCur = oddCur.next;
            } else {
                // 偶数
                evenCur.next = head;
                evenCur = evenCur.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        // 将偶数链表拼到奇数链表后面，并将偶数链表尾部指向null
        oddCur.next = evenDummy.next;
        evenCur.next = null;
        return oddDummy.next;
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



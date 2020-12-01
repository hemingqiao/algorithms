package blogandquestion.algorithms.linkedlist.removezerosumsublists1171;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 19:30:07
 * description:
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *  
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 *
 * 这个题解没有理解：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/solution/java-hashmap-liang-ci-bian-li-ji-ke-by-shane-34/
 */
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null) {
            ListNode cur = p.next;
            int sum = 0;
            while (cur != null) {
                sum += cur.val;
                cur = cur.next;
                if (sum == 0) {
                    p.next = cur;
                    break;
                }
            }
            if (cur == null) {
                // 如果以p为起点的链表遍历完了（cur == null），可以将p后移一位，继续遍历这个新链表
                // 否则，继续遍历以p为起点的链表
                p = p.next;
            }
        }
        return dummy.next;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/solution/cdi-gui-yu-zhou-zui-yi-dong-zui-jian-ji-kan-bu-don/
 */
class RecurSolution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        int sum = 0;
        while (p != null) {
            sum += p.val;
            p = p.next;
            if (sum == 0) {
                // 当sum == 0时就说明出现了从head开始和为0的连续序列，那么将这一连续序列删去，直接返回从迭代指针p的下一节点开始的新的递归
                return removeZeroSumSublists(p);
            }
        }
        // 如果从head开始没有连续序列的和为0，那么就递归计算head节点的下一个节点，并且返回head
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

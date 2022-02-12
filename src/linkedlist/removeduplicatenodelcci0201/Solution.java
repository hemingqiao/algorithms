package src.linkedlist.removeduplicatenodelcci0201;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 15:58:12
 * description:
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 *
 * 参考：https://leetcode-cn.com/problems/remove-duplicate-node-lcci/solution/javade-4chong-xie-fa-bao-gua-di-gui-wei-yun-suan-b/
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode p = head;
        while (p != null && p.next != null) {
            set.add(p.val);
            if (set.contains(p.next.val)) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}


class AnotherSolution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode cur = head;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                set.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;
    }

    // 因为题目限定链表元素在[0, 20000]范围内，所以可以使用数组替代哈希表
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null || head.next == null) return head;
        boolean[] visited = new boolean[20001];
        visited[head.val] = true;
        ListNode p = head;
        while (p.next != null) {
            if (visited[p.next.val]) {
                p.next = p.next.next;
            } else {
                visited[p.next.val] = true;
                p = p.next;
            }
        }
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

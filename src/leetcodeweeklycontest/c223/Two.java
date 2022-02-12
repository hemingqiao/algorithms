package src.leetcodeweeklycontest.c223;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/10 10:40:32
 * description:
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 示例 3：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 示例 4：
 *
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * 示例 5：
 *
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 *
 *
 * 提示：
 *
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 10^5
 * 0 <= Node.val <= 100
 *
 * 链接：https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 */
public class Two {
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;
        int len = 1;
        ListNode t = head;
        while (t != null) {
            len++;
            t = t.next;
        }
        ListNode f = getNode(head, k);
        ListNode l = getNode(head, len - k);
        int temp = f.val;
        f.val = l.val;
        l.val = temp;
        return head;
    }

    public ListNode getNode(ListNode head, int n) {
        int i = 1;
        while (head != null) {
            if (i++ == n) return head;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Two t = new Two();
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        ListNode ret = t.swapNodes(test, 2);
        System.out.println(ret);
    }
}


/**
 * 参考：https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/solution/java-shuang-bai-3-zhi-zhen-by-utopia-ufrn/
 */
class AnotherSolutionTwo {
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;
        ListNode f = head;
        ListNode l = head;
        ListNode p = head; // 辅助指针

        int i = 1;
        // 找到正数第k个节点
        while (f != null) {
            if (i++ == k) break;
            f = f.next;
            p = p.next;
        }
        // 找到倒数第k个节点
        while (p.next != null) {
            l = l.next;
            p = p.next;
        }
        int temp = f.val;
        f.val = l.val;
        l.val = temp;
        return head;
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

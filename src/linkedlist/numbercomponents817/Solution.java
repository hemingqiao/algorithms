package src.linkedlist.numbercomponents817;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 20:04:22
 * description:
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 *
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 *
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 *  
 *
 * 提示：
 *
 * 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为 [0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-components
 *
 * 傻逼题，你表达你🐎的题意呢？发布前自己不会读一遍🐎？傻逼傻逼
 * 参考：https://leetcode-cn.com/problems/linked-list-components/solution/lian-biao-zu-jian-by-leetcode/
 * 参考：https://leetcode-cn.com/problems/linked-list-components/solution/java-by-zxy0917-10/
 */
public class Solution {
    // G中的元素能够在链表中组成的最长一段距离称为一个组件
    public int numComponents(ListNode head, int[] G) {
        if (G.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                head = head.next;
                if (head == null || !set.contains(head.val)) {
                    res++;
                }
            } else {
                head = head.next;
            }
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

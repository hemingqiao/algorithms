package src.linkedlist.splitlisttoparts725;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 13:17:12
 * description:
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 *
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 *
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *  
 *
 * 提示:
 *
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 *
 * 参考：https://leetcode-cn.com/problems/split-linked-list-in-parts/solution/qiao-miao-lei-bi-si-lu-qing-xi-dai-ma-jian-dan-er-/
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p = root;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        int[] splitLen = new int[k];
        Arrays.fill(splitLen, length / k); // 每段的长度先设为 length / k
        for (int i = 0; i < length % k; i++) { // 将剩余的节点从前到后依次给每一段分一个
            splitLen[i]++;
        }

        ListNode[] res = new ListNode[k];
        ListNode dummy = new ListNode(-1);
        dummy.next = root;
        ListNode pre;
        ListNode cur = root;
        int i = 0; // splitLen数组中每段链表长度的索引
        int num = 0; // 记录每一段链表长度
        while (cur != null) {
            num++;
            pre = cur;
            cur = cur.next;

            if (num == splitLen[i]) {
                num = 0;
                pre.next = null; // 断开此段链表与后面链表之间的连接
                res[i] = dummy.next;
                i++;
                dummy.next = cur; // 更新dummy节点的next指针
            }
        }
        while (i < k) {
            res[i++] = null;
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

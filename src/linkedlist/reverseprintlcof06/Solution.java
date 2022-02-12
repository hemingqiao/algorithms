package src.linkedlist.reverseprintlcof06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 19:16:52
 * description:
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 *
 */
public class Solution {
    // 递归解法
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        recur(head, res);
        int[] result = new int[res.size()];
        int c = 0;
        for (int i : res) {
            result[c++] = i;
        }
        return result;
    }

    private void recur(ListNode head, List<Integer> res) {
        if (head == null) return;
        recur(head.next, res);
        res.add(head.val);
    }
}

/**
 * 迭代解法
 */
class AnotherSolution {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        int[] res = new int[c];
        int i = 0;
        p = head;
        while (p != null) {
            res[c - 1 - i] = p.val;
            i++;
            p = p.next;
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

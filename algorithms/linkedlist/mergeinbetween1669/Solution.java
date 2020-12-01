package blogandquestion.algorithms.linkedlist.mergeinbetween1669;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 08:41:18
 * description:
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * 下图中蓝色边和节点展示了操作后的结果：
 *
 *
 * 请你返回结果链表的头指针。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 *
 *
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *  
 *
 * 提示：
 *
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
 *
 * 题目限定a大于等于1，表明不会从头节点开始，所以不需要设置哑节点。
 */
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode fast = list1, slow = list1;
        ListNode tailTemp;
        ListNode list2Tail = list2;
        for (int i = 0; i < b && fast != null; i++) {
            fast = fast.next;
        }
        tailTemp = fast.next;
        for (int i = 0; i < a - 1; i++) {
            slow = slow.next;
        }
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }
        slow.next = list2;
        list2Tail.next = tailTemp;
        return list1;
    }
}

/**
 * 与上面相比，少遍历了一次
 */
class AnotherSolution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode slow = list1;
        for (int i = 0; i < a - 1; i++) {
            slow = slow.next;
        }
        ListNode f = slow;
        // 从a节点处找到b节点处，两个节点相隔b - a + 1个节点
        for (int i = 0; i < b - a + 1; i++) {
            f = f.next;
        }
        ListNode tailTemp = f.next;
        ListNode list2Tail = list2;
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }
        slow.next = list2;
        list2Tail.next = tailTemp;
        return list1;
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

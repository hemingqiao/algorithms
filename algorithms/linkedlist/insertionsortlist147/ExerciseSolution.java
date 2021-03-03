package blogandquestion.algorithms.linkedlist.insertionsortlist147;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/02 22:25:39
 * description:
 */
public class ExerciseSolution {
    // 参考：https://github.com/grandyang/leetcode/issues/147
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null) {
            ListNode temp = head.next;
            cur = dummy;
            // 从头向后遍历，找到head的插入位置
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }
            // 将head插入新链表
            head.next = cur.next;
            cur.next = head;
            head = temp; // 更新head
        }
        return dummy.next;
    }


    // 对上面进行一些优化
    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode insertPosNode = dummy;
        while (head != null) {
            ListNode next = head.next; // 保存待插入节点的后续节点
            // 如果待插入节点head的值小于等于插入位置处节点的值，从头开始寻找插入位置
            // 否则，insertPosNode是左侧有序链表的最后一个节点，其next属性始终为null
            if (insertPosNode.val >= head.val) insertPosNode = dummy;
            // 开始寻找合适的插入位置
            while (insertPosNode.next != null && insertPosNode.next.val <= head.val) {
                insertPosNode = insertPosNode.next;
            }
            // 将head插入到左侧的有序链表中
            head.next = insertPosNode.next;
            insertPosNode.next = head;
            head = next;
        }
        return dummy.next;
    }


    // merge sort solution
    public ListNode insertionSortList1(ListNode head) {
        // 这里必须加上head.next == null的判断，否则当head.next == null时，会一直递归下去，不能跳出
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rest = slow.next;
        slow.next = null;
        ListNode left = insertionSortList1(head);
        ListNode right = insertionSortList1(rest);
        return mergeTwoList(left, right);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j;
            int temporary = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temporary; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temporary;
        }
    }

    public int[] generateRandomArray(int size, int boundary) {
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = (int) (Math.random() * boundary);
        }
        return ret;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = es.generateRandomArray(15, 100);
        System.out.println(Arrays.toString(test));
        es.insertionSort(test);
        System.out.println(Arrays.toString(test));
    }
}

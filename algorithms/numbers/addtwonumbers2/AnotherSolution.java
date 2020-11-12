package blogandquestion.algorithms.numbers.addtwonumbers2;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/04 14:41:38
 * description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * see: https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
 */
public class AnotherSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在头节点之前设置一个辅助节点
        ListNode pre = new ListNode();
        ListNode cur = pre;
        // 设置carry用于处理进位
        int carry = 0;

        // l1和l2只要有一个不为null，继续循环下去
        // 如对 1 2 3 和 1 8 5 6
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 处理如果最后一位相加后，还有进位的情况
        // 如果上面的while语句判断条件为l1 != null || l2 != null || carry != 0 这里的判断语句就可以省略
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }
}

package src.binarytree.connect116;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/17 19:28:33
 * description: 抄的大佬的解法。
 * see: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/bfshe-di-gui-zui-hou-liang-chong-ji-bai-liao-100-2/
 */
public class AnotherSolution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node cur = root; // 可以把连接同一层的节点视为一个单向链表
        while (cur != null) {
            // 遍历当前层的时候，为了方便操作在下一层的前面添加一个哑节点（注意这里是访问当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(-1);
            // pre表示下一层节点的前一个节点
            Node pre = dummy;

            // 然后开始遍历当前层的链表，将下一层的节点串成一个链表。当cur为null时，表明已经到达当前层末尾
            // 因为是完美二叉树，如果有左子节点就一定有右子节点
            while (cur != null && cur.left != null) {
                // 让pre节点的next指向当前节点的左子节点，也就是串成一个链表
                pre.next = cur.left;
                pre = pre.next; // 然后更新pre

                pre.next = cur.right; // pre节点的next指向当前节点的右子节点
                pre = pre.next; // 更新pre

                cur = cur.next; // 继续访问这一行的下一个节点，直到cur.next == null
            }

            cur = dummy.next; // 将下一层串成一个链表后，赋值给cur。继续循环，直到cur为null，也就是到达树的根部，cur.left == null
        }
        return root;
    }
}

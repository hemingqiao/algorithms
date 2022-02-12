package src.binarytree.connecttwo117;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/17 19:50:21
 * description: 与116的不同之处在于这题不是一个完美二叉树了。相同之处是我抄的是同一个大佬的解法～
 *
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 *
 *
 * 解题思路
 * see:
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node cur = root; // 可以把cur看作是每一层的链表
        while (cur != null) {
            // 遍历当前层的时候，为了方便操作在下一层的前面添加一个哑节点（注意这里是访问当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(-1);
            Node pre = dummy; // pre表示下一层节点的前一个节点

            // 开始遍历当前层的链表，同时将下一层的节点串成一个链表
            // 需要注意的是当前层的节点不一定具有子节点
            while (cur != null) { // cur == null 表明已经到达当前层链表末尾
                if (cur.left != null) { // 如果当前节点具有左子节点，将其串起来
                    pre.next = cur.left;
                    pre = pre.next; // 更新pre
                }

                if (cur.right != null) { // 同理判断当前节点是否具有右子节点
                    pre.next = cur.right;
                    pre = pre.next;
                }

                cur = cur.next; // 更新当前节点，访问这一层的下一个节点
            }

            cur = dummy.next; // 把下一层串成一个链表后，赋值给cur，继续循环。直到cur == null，此时表明到达了树的底部
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

package src.linkedlist.flatten430;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 20:05:46
 * description:
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或
 * 多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 * 扁平化后的链表如下图：
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 如何表示测试用例中的多级链表？
 *
 * 以 示例 1 为例：
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 序列化其中的每一级之后：
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *  
 *
 * 提示：
 *
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 *
 * 参考：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/dfs-er-cha-shu-xian-xu-bian-li-java-0ms-by-pusheen/
 */
public class Solution {
    // 多级链表结构的扁平化类似二叉树的先序遍历
    // child就相当于left tree，next相当于right tree
    // 需要维护一个prev指针用于访问当前节点的上一个节点
    // prev指针非空时，建立prev与当前节点的双向连接
    // 处理完一个child后记得把它设为null
    Node prev = null;
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    // 先序遍历，先处理根，在处理左右子树（节点）
    private void dfs(Node head) {
        if (head == null) return;
        Node next = head.next; // next相当于二叉树的右子树
        if (prev != null) {
            // 如果prev指针非空，建立prev与当前节点的双向连接
            prev.next = head;
            head.prev = prev;
        }
        prev = head; // 更新prev
        dfs(head.child); // 相当于左子树
        head.child = null; // 处理完child之后要将其设为null
        dfs(next); // 相当于右子树
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/java-simple-way-by-lincs/
 */
class AnotherSolution {
    public Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child != null) {
                Node next = p.next;
                Node child = p.child;
                p.next = child;

                p.child = null;
                child.prev = p;

                while (child.next != null) {
                    child = child.next;
                }
                child.next = next;
                if (next != null) {
                    next.prev = child;
                }
            }
            p = p.next;
        }
        return head;
    }
}


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

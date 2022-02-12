package src.linkedlist.flatten430;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/24 19:50:56
 * description:
 */
public class ExerciseSolution {
    public Node flatten(Node head) {
        Node[] res = dfs(head);
        return res[0];
    }

    public Node[] dfs(Node head) {
        if (head == null) return new Node[2];
        Node cur = head, tail = head;
        while (cur != null) {
            tail = cur;
            if (cur.child != null) {
                Node[] n = dfs(cur.child);
                cur.child = null;
                n[1].next = cur.next;
                if (cur.next != null) cur.next.prev = n[1];
                cur.next = n[0];
                n[0].prev = cur;
                cur = n[1].next;
                tail = n[1];
            } else {
                cur = cur.next;
            }
        }
        return new Node[]{head, tail};
    }
}

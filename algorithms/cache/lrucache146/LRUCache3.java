package blogandquestion.algorithms.cache.lrucache146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/27 14:21:48
 * description:
 */
public class LRUCache3 {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(null, -1, -1, null);
    private Node tail = new Node(null, -1, -1, null);
    private int capacity;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int ret = node.val;
            unlink(node);
            moveToHead(node);
            return ret;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            unlink(node);
            moveToHead(node);
        } else {
            Node newNode = new Node(null, key, value, null);
            map.put(key, newNode);
            moveToHead(newNode);
            if (map.size() > this.capacity) {
                map.remove(tail.prev.key);
                unlink(tail.prev);
            }
        }
    }

    public void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(Node prev, int key, int val, Node next) {
            this.prev = prev;
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}

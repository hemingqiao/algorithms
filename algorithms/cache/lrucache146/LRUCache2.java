package blogandquestion.algorithms.cache.lrucache146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/27 11:54:52
 * description:
 * 二刷，还是不熟悉，需要多写几次
 */
public class LRUCache2 {
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    public LRUCache2(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            if (map.size() > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        Node firstNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = firstNode;
        firstNode.prev = node;
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

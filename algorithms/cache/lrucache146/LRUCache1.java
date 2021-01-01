package blogandquestion.algorithms.cache.lrucache146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 15:07:37
 * description:
 *
 * @see java.util.LinkedHashMap
 */
public class LRUCache1 {
    static class Node {
        Node prev;
        Node next;
        int val;
        int key;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int capacity;

    public LRUCache1(int capacity) {
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
            addToHead(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
//        Node prevNode = node.prev;
//        Node nextNode = node.next;
//        prevNode.next = nextNode;
//        nextNode.prev = prevNode;
    }

    public void addToHead(Node node) {
        Node firstNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = firstNode;
        firstNode.prev = node;
    }
}

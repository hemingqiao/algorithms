package src.cache.lrucache146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/27 11:54:52
 * description:
 * 二刷，还是不熟悉，需要多写几次
 * jdk中有类似的原生实现
 * @see java.util.LinkedHashMap
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

    // 普通的内部类对象隐式的保存了一个指向创建它的外部类对象的引用，而静态类对象则没有这个引用
    // 不能从静态内部类的对象访问外部类的非静态成员
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

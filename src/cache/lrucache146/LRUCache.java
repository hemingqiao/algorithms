package src.cache.lrucache146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 14:45:16
 * description:
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 * 参考：https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
 * 参考：https://leetcode-cn.com/problems/lru-cache/solution/bu-yong-yu-yan-nei-jian-de-map-gua-dang-feng-zhuan/
 */
public class LRUCache {
    private Map<Integer, Node> cache = new HashMap<>();
    private int size; // cache内node的数量
    private int capacity; // cache的容量
    private Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node); // 将访问的节点移到链表头部
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // 如果key不存在，创建一个新的节点
            Node newNode = new Node(null, key, value, null);
            // 添加进哈希表
            cache.put(key, newNode);
            // 将新节点添加到双向链表头部
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                Node removed = removeFromTail();
                cache.remove(removed.key);
                size--;
            }
        } else {
            // 如果key存在，通过哈希表定位到node，再修改节点的value，最后将节点移到双向链表的头部
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 将一个节点插入到双向链表头部
     * @param node 待插入的节点
     */
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

    }

    /**
     * 将给定节点从双向链表中移除
     * @param node 待移除的节点
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    /**
     * 将指定节点移到双向链表头部
     * @param node 待移动节点
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 移除双向链表尾部的节点
     * @return 待移除的节点
     */
    private Node removeFromTail() {
        Node ret = tail.prev;
        removeNode(ret);
        return ret;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {

        }

        public Node(Node prev, int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}

package blogandquestion.algorithms.hashtable.myhashset705;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/14 15:56:59
 * description:
 */
public class MyHashSet2 {
    // 长度取一个素数较好
    private Node[] nodes = new Node[10009];

    /** Initialize your data structure here. */
    public MyHashSet2() {

    }

    public void add(int key) {
        int hashIndex = getHashIndex(key);
        Node list = nodes[hashIndex];
        Node temp = list;
        while (temp != null && temp.value != key) {
            temp = temp.next;
        }
        if (temp != null) return; // Set不重复添加元素
        Node node = new Node(key);
        node.next = list;
        nodes[hashIndex] = node;
    }

    public void remove(int key) {
        int hashIndex = getHashIndex(key);
        Node list = nodes[hashIndex];
        Node dummy = new Node(-1);
        dummy.next = list;
        Node prev = dummy;
        while (list != null) {
            if (list.value == key) {
                prev.next = list.next;
                break;
            }
            prev = list;
            list = list.next;
        }
        nodes[hashIndex] = dummy.next;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashIndex = getHashIndex(key);
        Node list = nodes[hashIndex];
        while (list != null && list.value != key) {
            list = list.next;
        }
        return list != null;
    }

    private int getHashIndex(int value) {
        int hash = Integer.hashCode(value);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

package src.hashtable.myhashmap706;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/14 14:51:21
 * description:
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *  
 *
 * 提示：
 *
 * 0 <= key, value <= 10^6
 * 最多调用 104 次 put、get 和 remove 方法
 *  
 *
 * 进阶：你能否不使用内置的 HashMap 库解决此问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 *
 * 参考：https://leetcode-cn.com/problems/design-hashmap/solution/yi-ti-shuang-jie-jian-dan-shu-zu-lian-bi-yhiw/
 */

public class MyHashMap {
    // 长度取素数可以避免掉一些哈希冲突
    private Node[] nodes = new Node[10009];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashIndex = getHashIndex(key);
        Node list = nodes[hashIndex];
        Node temp = list;
//        if (temp != null) {
//            while (temp != null && temp.key != key) {
//                temp = temp.next;
//            }
//            if (temp == null) {
//                Node node = new Node(key, value);
//                node.next = list;
//                nodes[hashIndex] = node;
//            } else {
//                temp.value = value;
//            }
//        } else {
//            Node node = new Node(key, value);
//            node.next = list;
//            nodes[hashIndex] = node;
//        }

        while (temp != null && temp.key != key) {
            temp = temp.next;
        }
        if (temp != null) {
            temp.value = value;
            return;
        }
        Node node = new Node(key, value);
        node.next = list;
        nodes[hashIndex] = node;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashIndex = getHashIndex(key);
        Node list = nodes[hashIndex];
        while (list != null) {
            if (list.key == key) {
                return list.value;
            }
            list = list.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashIndex = getHashIndex(key);
        Node list = nodes[hashIndex];
        Node dummy = new Node(-1, -1);
        dummy.next = list;
        Node prev = dummy;
        while (list != null) {
            if (list.key == key) {
                prev.next = list.next;
                break;
            }
            prev = list;
            list = list.next;
        }
        nodes[hashIndex] = dummy.next;
    }

    private int getHashIndex(int key) {
        // 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
        // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
        // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }

    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap mhh = new MyHashMap();
        mhh.put(1, 1);
        mhh.put(2, 2);
        mhh.get(1);
        mhh.get(3);
        mhh.put(2, 1);
        mhh.get(2);
        mhh.remove(2);
        mhh.get(2);
    }
}


class MyHashMap1 {
    private int[] table = new int[1000005];
    /** Initialize your data structure here. */
    public MyHashMap1() {
        Arrays.fill(table, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        table[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return table[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        table[key] = -1;
    }
}

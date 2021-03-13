package blogandquestion.algorithms.hashtable.myhashset705;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/13 09:42:28
 * description:
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *  
 * 示例：
 *
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 *
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 *  
 *
 * 提示：
 *
 * 0 <= key <= 10^6
 * 最多调用 104 次 add、remove 和 contains 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 *
 */
public class MyHashSet {
    private List<Integer> container = new ArrayList<>();
    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        if (container.size() == 0) {
            container.add(key);
        } else {
            for (int i = 0; i < container.size(); i++) {
                if (key == container.get(i)) return;
            }
            container.add(key);
        }
    }

    public void remove(int key) {
        for (int i = 0; i < container.size(); i++) {
            if (container.get(i) == key) {
                container.remove(i);
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for (int i = 0; i < container.size(); i++) {
            if (container.get(i) == key) return true;
        }
        return false;
    }
}

class MyHashSet1 {
    private boolean[] map = new boolean[1000005];
    /** Initialize your data structure here. */
    public MyHashSet1() {

    }

    public void add(int key) {
        map[key] = true;
    }

    public void remove(int key) {
        map[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map[key];
    }
}

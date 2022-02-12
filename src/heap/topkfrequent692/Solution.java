package src.heap.topkfrequent692;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/20 20:51:53
 * description:
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 *
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = words[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int a = o1.getValue(), b = o2.getValue();
                // 如果两者出现频率相同，那么由于是一个小顶堆，而输出又是字典序小的在前，则在堆中字典序小的在下面，字典序更大的更靠近堆顶
                // 如果是o1.compareTo(o2)的话，字典序小的会更靠近堆顶，所以需要是o2.compareTo(o1)
                if (a == b) return o2.getKey().compareTo(o1.getKey());
                return a - b;
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) queue.poll();
        }
        List<String> ret = new ArrayList<>();
        while (!queue.isEmpty()) ret.add(queue.poll().getKey());
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
//        String a = "a", b = "b";
//        System.out.println(a.compareTo(b));
        String[] test = {"i", "love", "leetcode", "i", "love", "coding"};
//        String[] test = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        Solution s = new Solution();
        List<String> res = s.topKFrequent(test, 4);
        System.out.println(res);
    }

    public List<String> topKFrequent1(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = words[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) list.add(entry.getKey());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = map.get(o1), b = map.get(o2);
                return a == b ? o1.compareTo(o2) : b - a;
            }
        });
        return list.subList(0, k);
    }
}

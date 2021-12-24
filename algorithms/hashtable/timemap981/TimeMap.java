package blogandquestion.algorithms.hashtable.timemap981;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/10 08:21:28
 * description:
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 *     存储键 key、值 value，以及给定的时间戳 timestamp。
 *
 * 2. get(string key, int timestamp)
 *
 *     返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 *     如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 *     如果没有值，则返回空字符串（""）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释：
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
 * kv.get("foo", 1);  // 输出 "bar"
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // 输出 "bar2"
 * kv.get("foo", 5); // 输出 "bar2"
 *
 * 示例 2：
 *
 * 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * 输出：[null,null,null,"","high","high","low","low"]
 *
 *
 *
 * 提示：
 *
 *     所有的键/值字符串都是小写的。
 *     所有的键/值字符串长度都在 [1, 100] 范围内。
 *     所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
 *     1 <= timestamp <= 10^7
 *     TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
 *
 */
public class TimeMap {
    Map<String, ArrayList<String>> v = new HashMap<>();
    Map<String, ArrayList<Integer>> t = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (!v.containsKey(key)) {
            ArrayList<String> vv = new ArrayList<>();
            ArrayList<Integer> tt = new ArrayList<>();
            vv.add(value);
            tt.add(timestamp);
            v.put(key, vv);
            t.put(key, tt);
        } else {
            v.get(key).add(value);
            t.get(key).add(timestamp);
        }
    }

    public String get(String key, int timestamp) {
        ArrayList<Integer> tt = t.get(key);
        ArrayList<String> vv = v.get(key);
        // 如果这个key对应的值不存在或者timestamp小于存储的最小时间戳，直接返回""
        if (tt == null || timestamp < tt.get(0)) return "";
        if (timestamp >= tt.get(tt.size() - 1)) return vv.get(vv.size() - 1);
        int l = 0, r = tt.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (tt.get(mid) >= timestamp) r = mid;
            else l = mid + 1;
        }
        if (tt.get(l) == timestamp) return vv.get(l);
        return vv.get(l - 1);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

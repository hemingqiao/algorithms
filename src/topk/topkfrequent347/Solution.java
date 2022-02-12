package src.topk.topkfrequent347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 21:55:39
 * description:
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * <p>
 * 参考：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //map.put(num, map.getOrDefault(num, 0) + 1);
            // 下面这样写比使用getOrDefault稍快
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        // 取出最小堆中的元素
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.remove();
        }
        return res;
    }
}


class AnotherSolution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            // 在这道题中，反而是上面的要稍快些
            // if (map.containsKey(num)) {
            //     map.put(num, map.get(num) + 1);
            // } else {
            //     map.put(num, 1);
            // }
        }
        // 用最小堆保存频率最大的k个元素
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < freq) {
                    queue.remove();
                    queue.add(new int[]{num, freq});
                }
            } else {
                queue.add(new int[]{num, freq});
            }
        }

        // 取出最小堆中的元素
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}

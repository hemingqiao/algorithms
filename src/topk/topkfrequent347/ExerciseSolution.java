package src.topk.topkfrequent347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/04 20:15:42
 * description:
 * 二刷，多写多练
 */
public class ExerciseSolution {
    // 题目要求时间复杂度必须优于nlogn，那么直接排序是不能满足要求的
    // 而维护一个size为k的小顶堆，其时间复杂度可以降低为nlogk
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (queue.size() < k) {
                queue.add(new int[]{key, freq});
            } else {
                if (queue.peek()[1] < freq) {
                    queue.poll();
                    queue.add(new int[]{key, freq});
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}

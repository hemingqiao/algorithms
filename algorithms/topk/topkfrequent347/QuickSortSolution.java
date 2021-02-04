package blogandquestion.algorithms.topk.topkfrequent347;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 22:11:11
 * description:
 */
public class QuickSortSolution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k < 1) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //map.put(num, map.getOrDefault(num, 0) + 1);
            // 下面这样写比使用getOrDefault稍快
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 创建 Pair 数组, Pair.num 表示数组, Pair.freq 表示词频
        Pair[] pairs = new Pair[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            Pair p = new Pair(num, freq);
            pairs[i++] = p;
        }

        quickSelect(pairs, 0, pairs.length - 1, k);
        int[] res = new int[k];
        for (int j = 0; j < k; ++j) {
            res[j] = pairs[j].num;
        }
        return res;
    }

    private void quickSelect(Pair[] pairs, int l, int h, int k) {
        if (l > h) return;
        int pivot = partition(pairs, l, h);

        // 如果pivot 还不到 k, 说明左侧值不够, 先继续排右侧; 否则, 继续从 pivot 左侧找
        if (pivot > k) {
            quickSelect(pairs, l, pivot - 1, k);
        } else if (pivot < k) {
            quickSelect(pairs, pivot + 1, h, k);
        }

        // 当 pivot 的 index 为 k 时, 说明其左边已经有排好序的 K 个元素, 直接返回
        return;
    }

    private int partition(Pair[] pairs, int low, int high) {
        Pair pivot = pairs[low];
        int l = low, h = high;

        while (l < h) {
            while (l < h && pairs[h].freq <= pivot.freq) h--; // 从右向左找第一个大于 pivot 的值
            while (l < h && pairs[l].freq >= pivot.freq) l++; // 从左向右找第一个小于 pivot 的值
            swap(pairs, l, h);
        }

        //此时, l==h, pairs[l]是坑位, swap pairs[l], paris[low]
        swap(pairs, l, low);
        return l;
    }

    private void swap(Pair[] pairs, int i, int j) {
        Pair tmp = pairs[i];
        pairs[i] = pairs[j];
        pairs[j] = tmp;
    }
}


class Pair {
    int num;
    int freq;

    public Pair(int n, int f) {
        this.num = n;
        this.freq = f;
    }
}

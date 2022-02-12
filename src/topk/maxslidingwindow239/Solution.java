package src.topk.maxslidingwindow239;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/24 11:59:24
 * description:
 * 也可以使用优先队列来做，即最大堆，不过此时里面放一个 pair 对儿，由数字和其所在位置组成的，这样就可以知道每个数字的位置了，而不用再进行搜索了。
 * 在遍历每个数字时，进行 while 循环，假如优先队列中最大的数字此时不在窗口中了，就要移除，判断方法就是将队首元素的 pair 对儿中的 second（位置
 * 坐标）跟 i-k 对比，小于等于就移除。然后将当前数字和其位置组成 pair 对儿加入优先队列中。此时看若 i >= k-1，说明窗口大小正好是k，就将最大值
 * 加入结果 res 中即可
 */
public class Solution {
    // 86ms, 12.25%
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 大顶堆
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.value - o1.value;
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 当queue.peek().index == i - k，窗口内最大值的位置已经被移出窗口
            while (!queue.isEmpty() && queue.peek().index <= i - k) {
                queue.poll();
            }
            queue.add(new Pair(nums[i], i));
            if (i - k >= -1) { // i - k == -1 时窗口长度为k，i >= k - 1时窗口大小正好是k，就将最大值加入结果
                res.add(queue.peek().value);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution s = new Solution();
        int[] res = s.maxSlidingWindow(test, k);
        System.out.println(Arrays.toString(res));
    }
}

class Pair {
    public int value;
    public int index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

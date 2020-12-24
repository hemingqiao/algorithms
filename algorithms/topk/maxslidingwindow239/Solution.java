package blogandquestion.algorithms.topk.maxslidingwindow239;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/24 11:59:24
 * description:
 */
public class Solution {
    // 86ms, 12.25%
    public int[] maxSlidingWindow(int[] nums, int k) {
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
            if (i - k >= -1) { // i - k == -1 时窗口长度为k
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

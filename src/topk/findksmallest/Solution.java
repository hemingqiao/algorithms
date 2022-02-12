package src.topk.findksmallest;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/27 17:23:25
 * description:
 */
public class Solution {
    // 使用大顶堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int n = input.length;
        if (k > n) return new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : input) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) list.add(queue.poll());
//         Collections.sort(list);
        return list;
    }

    public ArrayList<Integer> findKSmallest(int[] input, int k) {
        int n = input.length;
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > n) return ret;
        // 利用冒泡排序的思想，外层循环k次
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            ret.add(input[n - 1 - i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = s.findKSmallest(test, 4);
        System.out.println(res);
    }
}

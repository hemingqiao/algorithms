package blogandquestion.algorithms.binarysearch.findclosestelements658;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/03 20:16:23
 * description:
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 *     |a - x| < |b - x| 或者
 *     |a - x| == |b - x| 且 a < b
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 *
 *
 * 提示：
 *
 *     1 <= k <= arr.length
 *     1 <= arr.length <= 10^4
 *     数组里的每个元素与 x 的绝对值不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 *
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= x) r = mid;
            else l = mid + 1;
        }
        List<Integer> res = new ArrayList<>();
        r = l;
        l = l - 1; // l从l - 1开始，是因为l处元素的值可能是大于x的
        while (l >= 0 && r < arr.length && res.size() < k) {
            int a = Math.abs(arr[l] - x);
            int b = arr[r] - x;
            if (a <= b) res.add(arr[l--]);
            else res.add(arr[r++]);
        }
        while (l >= 0 && res.size() < k) res.add(arr[l--]);
        while (r < arr.length && res.size() < k) res.add(arr[r++]);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        Solution s = new Solution();
        List<Integer> res = s.findClosestElements2(test, 4, 3);
        System.out.println(res);
    }

    // 不调用sort也可以，l左边的元素都从头部插入，l右边的元素都插入到尾部
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= x) r = mid;
            else l = mid + 1;
        }
        List<Integer> res = new ArrayList<>();
        r = l;
        l = l - 1;
        while (l >= 0 && r < arr.length && res.size() < k) {
            int a = Math.abs(arr[l] - x);
            int b = arr[r] - x;
            if (a <= b) res.add(0, arr[l--]);
            else res.add(arr[r++]);
        }
        while (l >= 0 && res.size() < k) res.add(0, arr[l--]);
        while (r < arr.length && res.size() < k) res.add(arr[r++]);
        return res;
    }

    // 求最小的k个数，应联想到使用大顶堆
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.abs == o2.abs) return o2.num - o1.num;
            return o2.abs - o1.abs;
        });
        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Pair(Math.abs(arr[i] - x), arr[i]));
            if (queue.size() > k) queue.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().num);
        }
        Collections.sort(res);
        return res;
    }

    static class Pair {
        int abs;
        int num;

        public Pair(int abs, int num) {
            this.abs = abs;
            this.num = num;
        }
    }
}

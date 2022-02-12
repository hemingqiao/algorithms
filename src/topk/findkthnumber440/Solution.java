package src.topk.findkthnumber440;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/27 18:52:33
 * description:
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 10^9。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 *
 *
 * @see src.topk.lexicalorder386.Solution
 */
public class Solution {
    // WA
    // 思路没错，但是通过不了OJ的特别大的测试用例
    public int findKthNumber(int n, int k) {
        // 求解字典序第k小的数字，使用大顶堆
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 1; i <= n; i++) {
            queue.offer(String.valueOf(i));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return Integer.valueOf(queue.poll());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 13, k = 2;
        int res = s.findKthNumber(n, k);
        System.out.println(res);
    }

    // 试试sort
    // 超出内存限制。。
    public int findKthNumber1(int n, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(String.valueOf(i));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return Integer.valueOf(list.get(k - 1));
    }


    // 参考：https://github.com/grandyang/leetcode/issues/440
    // 不太理解
    public int findKthNumber2(int n, int k) {
        int cur = 1;
        --k;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            // 统计这颗子树下所有的节点数（step）
            while (first <= n) {
                step += Math.min(last, (long) (n + 1)) - first;
                first *= 10;
                last *= 10;
            }

            if (step <= k) {
                ++cur;
                k -= step;
            } else {
                cur *= 10;
                --k;
            }
        }
        return cur;
    }
}

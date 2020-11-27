package blogandquestion.algorithms.array.findkthpositive1539;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 08:35:01
 * description:
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 *
 * 请你找到这个数组里第 k 个缺失的正整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-missing-positive-number
 *
 * 参考：https://leetcode-cn.com/problems/kth-missing-positive-number/solution/di-k-ge-que-shi-de-zheng-zheng-shu-by-leetcode-sol/
 */
public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int end = arr[arr.length - 1];
        Set<Integer> set = new HashSet<>();
        // 题目限定k小于等于1000
        for (int i = 1; i <= end + 1001; i++) {
            set.add(i);
        }
        for (int j : arr) {
            set.remove(j);
        }
        int i = 0;
        for (int t : set) {
            i++;
            if (i == k) return t;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1,2,3,4};
        int res = s.findKthPositiveOpt(test, 2);
        System.out.println(res);
    }

    public int findKthPositiveOpt(int[] arr, int k) {
        // missCount记录缺失的正整数个数，lastMiss记录上一个缺失的正整数
        int missCount = 0, lastMiss = -1;
        // current为从1开始的正整数，每次递增1，pos用来遍历数组arr
        int current = 1, pos = 0;
        for (missCount = 0; missCount < k; current++) {
            if (current == arr[pos]) {
                pos = (pos + 1) < arr.length ? pos + 1 : pos;
            } else {
                missCount++;
                lastMiss = current;
            }
        }
        return lastMiss;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/kth-missing-positive-number/solution/duo-chong-jie-fa-by-dao-chang-3/
 */
class AnotherSolution {
    // 不难发现，一个不缺失元素的序列，会有arr[i]=i+1这样的关系，而在缺失元素之后，会有arr[i]>i+1，简单移项可得 arr[i]-i-1 > 0，
    // 缺失一个的时候，相差1，缺失两个时则相差2，以此类推，缺失越多，两者差距越大，要找第k个缺失的，换言之，只要arr[i]-i-1 == k，
    // 便找到了题目要找的数字。
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + n;
    }
}

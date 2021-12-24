package blogandquestion.algorithms.binarysearch.mineatingspeed875;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/09 10:16:56
 * description:
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 示例 2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * 示例 3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 *
 *
 * 提示：
 *
 *     1 <= piles.length <= 10^4
 *     piles.length <= H <= 10^9
 *     1 <= piles[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 *
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) max = Math.max(max, piles[i]);
        int left = 1, right = max;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (canEat(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canEat(int[] piles, int k, int H) {
        int n = piles.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (piles[i] > k) {
                if (piles[i] % k == 0) res += piles[i] / k;
                else res += piles[i] / k + 1;
                // res += Math.ceil(piles[i] * 1.0 / k);
            } else {
                ++res;
            }
        }
        return res <= H;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {10};
        int res = s.minEatingSpeed(test, 2);
        System.out.println(res);
    }
}

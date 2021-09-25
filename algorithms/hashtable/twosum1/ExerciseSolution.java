package blogandquestion.algorithms.hashtable.twosum1;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/25 21:53:43
 * description:
 */
public class ExerciseSolution {
    // 排序 O(nlog(n)) 双指针查找 O(n)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) p[i] = new Pair(nums[i], i);
        Arrays.sort(p, (a, b) -> a.first - b.first);
        for (int i = 0, j = n - 1; i < j; i++) {
            int l = p[i].first;
            while (j > i && l + p[j].first > target) j--;
            if (l + p[j].first == target) return new int[]{p[i].second, p[j].second};
//            if (j > i && l + p[j].first == target) return new int[]{p[i].second, p[j].second};
        }
        return new int[]{-1, -1};
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

package blogandquestion.algorithms.array.thirdmax414;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/07 21:21:11
 * description:
 */
public class ExerciseSolution {
    public int thirdMax(int[] nums) {
        long INF = (long) 1e10, a = -INF, b = -INF, c = -INF;
        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];
            if (x > a) {
                c = b;
                b = a;
                a = x;
            } else if (x > b && x < a) {
                c = b;
                b = x;
            } else if (x > c && x < b) {
                c = x;
            }
        }
        return (int) (c == -INF ? a : c);
    }

    public int thirdMax1(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                q.offer(nums[i]);
            }
            max = Math.max(max, nums[i]);
            if (q.size() > 3) q.poll();
        }
        return q.size() == 3 ? q.peek() : max;
    }
}

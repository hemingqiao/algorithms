package blogandquestion.algorithms.numbers.tribonacci1137;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/08 11:19:05
 * description:
 */
public class SS {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, 1);
        List<Integer> q = new ArrayList<>();
        q.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x >= q.get(q.size() - 1)) {
                q.add(x);
                ret[i] = q.size();
            } else {
                int l = 0, r = q.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (q.get(mid) > x) r = mid;
                    else l = mid + 1;
                }
                q.set(l, x);
                ret[i] = l + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SS s = new SS();
        int[] test = {5, 1, 5, 5, 1, 3, 4, 5, 1, 4};
        int[] res = s.longestObstacleCourseAtEachPosition(test);
        System.out.println(Arrays.toString(res));
    }
    // [1,1,2,3,2,3,4,5,3,5]
}

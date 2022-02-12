package src.dp.lis.lengthoflis300;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/08 12:39:56
 * description:
 * @see src.dp.lis.longestobstacle.Solution
 */
public class ExerciseSolution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] q = new int[n];
        q[0] = nums[0];
        int res = 1, p = 0;
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            if (x > q[p]) {
                q[++p] = x;
                res = Math.max(res, p + 1);
            } else {
                int l = 0, r = p;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (q[mid] >= x) r = mid;
                    else l = mid + 1;
                }
                q[l] = x;
                res = Math.max(res, l + 1);
            }
        }
        return res;
    }
}

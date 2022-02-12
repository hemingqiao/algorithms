package src.doublepointer.trap42;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/25 20:05:11
 * description:
 */
public class ExerciseSolution {
    // 重视暴力解法
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = height[i];
            int lMax = 0, rMax = 0;
            for (int l = 0; l < i; l++) {
                lMax = Math.max(lMax, height[l]);
            }
            for (int r = n - 1; r > i; r--) {
                rMax = Math.max(rMax, height[r]);
            }
            int t = Math.min(lMax, rMax);
            t = Math.max(t, cur);
            res += t - cur;
        }
        return res;
    }

    public int trap1(int[] heights) {
        int n = heights.length;
        int[] lMax = new int[n], rMax = new int[n];
        lMax[0] = heights[0];
        rMax[n - 1] = heights[n - 1];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], heights[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], heights[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(lMax[i], rMax[i]) - heights[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = es.trap1(test);
        System.out.println(res);
    }
}

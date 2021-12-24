package blogandquestion.algorithms.doublepointer.maxarea11;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/13 20:39:12
 * description:
 */
public class ExerciseSolution {
    // 暴力解法
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int start = height[i];
            for (int j = i + 1; j < n; j++) {
                int temp = Math.min(start, height[j]) * (j - i);
                maxArea = Math.max(maxArea, temp);
            }
        }
        return maxArea;
    }

    public int maxArea1(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(maxArea, (right - left) * height[left++]);
            } else {
                maxArea = Math.max(maxArea, (right - left) * height[right--]);
            }
        }
        return maxArea;
    }
}

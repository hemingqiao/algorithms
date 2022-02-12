package src.greedy.candy135;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 19:36:14
 * description:
 */
public class ExerciseSolution {
    // 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果，这里的评分更高是指严格大于？
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
        }
        for (int i = 0; i < n; i++) {
            res += candies[i];
        }
        return res;
    }
}

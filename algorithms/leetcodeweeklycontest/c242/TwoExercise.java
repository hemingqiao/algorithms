package blogandquestion.algorithms.leetcodeweeklycontest.c242;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/23 18:34:29
 * description:
 */
public class TwoExercise {
    public int minSpeedOnTime(int[] dist, double hour) {
        // 题目保证速度的最大值不会超过1e7，所以二分查找的上限可以设置为1e7 + 5
        int maxSpeed = (int) 1e7 + 5;
        int left = 1, right = maxSpeed;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (canReach(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == maxSpeed ? -1 : left;
    }

    // 在这个版本的方法中，调用了上取整函数，同时做了double的除法，所以速度比较慢
    // 但是过程很直观，每次加上新的时间之前都要进行上取整，同时也说明了之前解法中为什么最后一个元素不需要进行取整的问题
    public boolean canReach(int[] dist, double hour, int speed) {
        double sum = 0;
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            sum = Math.ceil(sum);
            sum += (double) dist[i] / (double) speed;
        }
        return sum <= hour;
    }
}

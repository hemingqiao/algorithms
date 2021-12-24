package blogandquestion.algorithms.numbers.maxpoints149;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/24 20:07:47
 * description:
 * 参考：大雪菜，https://www.acwing.com/video/1520/
 */
public class Solution {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int[] p : points) {
            // v表示位于垂直于x轴的直线上点的个数，s表示和中点重合的点的个数
            int v = 0, s = 0;
            Map<Double, Integer> cnt = new HashMap<>();
            for (int[] q : points) {
                if (q[0] == p[0] && q[1] == p[1]) {
                    ++s;
                } else if (q[0] == p[0]) {
                    ++v;
                } else {
                    double k = (double) (q[1] - p[1]) / (q[0] - p[0]);
                    if (cnt.containsKey(k)) {
                        cnt.put(k, cnt.get(k) + 1);
                    } else {
                        cnt.put(k, 1);
                    }
                }
            }
            int temp = v;
            for (Map.Entry<Double, Integer> entry : cnt.entrySet()) temp = Math.max(temp, entry.getValue());
            res = Math.max(res, temp + s);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] p = {{1, 1}, {2, 2}, {3, 3}};
        int res = s.maxPoints(p);
        System.out.println(res);
    }
}

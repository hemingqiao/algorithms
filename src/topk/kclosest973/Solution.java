package src.topk.kclosest973;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 10:00:11
 * description:
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 *
 * 参考：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/java-top-k-3-by-donoghl/
 */
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // Java中的优先队列默认是小顶堆（堆顶元素是最小的）
        // 这里通过传入一个比较器将默认的小顶堆改为大顶堆
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return cal(o2) - cal(o1);
            }
        });
        for (int i = 0; i < K; i++) {
            maxHeap.add(points[i]);
        }
        for (int i = K; i < points.length; i++) {
            // 如果当前元素小于堆顶元素，将堆顶元素出队，当前元素入队
            if (cal(maxHeap.peek()) > cal(points[i])) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    private int cal(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

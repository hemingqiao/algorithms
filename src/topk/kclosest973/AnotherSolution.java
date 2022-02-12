package src.topk.kclosest973;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 10:14:48
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
 */
public class AnotherSolution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length < K || K <= 0) {
            return new int[0][0];
        }

        int len = points.length;
        int left = 0, right = len - 1;
        int curPos = -1;
        while (curPos != K - 1) {
            curPos = findIndex(points, left, right);
            if (curPos < K - 1) {
                left = curPos + 1;
            }
            if (curPos > K - 1) {
                right = curPos;
            }
        }

        // 将排好序的数组的前K项返回（升序）
        return Arrays.copyOf(points, K);
    }

    // 采用不同的快排策略
    private int findIndex(int[][] points, int left, int right) {
        int pivotIndex = (int) (Math.random() * (right - left + 1) + left);
        swap(points, left, pivotIndex);
        int pivot = points[left][0] * points[left][0] + points[left][1] * points[left][1];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < pivot) {
                swap(points, i, ++j);
            }
        }
        swap(points, left, j);
        return j;
    }

    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * 采取了不同的快排策略
 * 参考：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/java-liang-xing-dai-ma-de-shi-wei-shi-yao-yao-yong/
 */
class ThirdSolution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || K <= 0 || points.length < K) {
            return new int[0][0];
        }

        int length = points.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int curPosition = -1;

        /*
            对 points 进行快排
         */
        while (curPosition != K - 1) {
            curPosition = partition(points, leftIndex, rightIndex);
            if (curPosition < K - 1) {
                leftIndex = curPosition + 1;
            }
            if (curPosition > K - 1) {
                rightIndex = curPosition - 1;
            }
        }

        /*
            将 排序后的数组 前K个 取出并返回
         */
        return Arrays.copyOf(points, K);
    }

    /**
     * 将 指定数组 的 指定区间 进行 “一轮快排”
     *
     * @param points 指定数组
     * @param left   指定区间 的 左边界
     * @param right  指定区间 的 右边界
     * @return 快排一轮后，当前元素所在位置
     */
    private int partition(int[][] points, int left, int right) {
        int[] temp = points[left];
        int leftValue = points[left][0] * points[left][0] + points[left][1] * points[left][1];
        while (left < right) {
            while (left < right && (points[right][0] * points[right][0] + points[right][1] * points[right][1] >= leftValue)) {
                right--;
            }
            if (left < right) {
                swapPoints(points, left, right);
            }

            while (left < right && (points[left][0] * points[left][0] + points[left][1] * points[left][1] <= leftValue)) {
                left++;
            }
            if (left < right) {
                swapPoints(points, left, right);
            }
        }
        return left;
    }

    /**，
     * 交换 指定数组 的 指定下标 两元素
     *
     * @param sourcePoints 指定数组
     * @param index1       要交换的数组元素下标1
     * @param index2       要交换的数组元素下标2
     */
    private void swapPoints(int[][] sourcePoints, int index1, int index2) {
        int[] temp = sourcePoints[index1];
        sourcePoints[index1] = sourcePoints[index2];
        sourcePoints[index2] = temp;
    }
}

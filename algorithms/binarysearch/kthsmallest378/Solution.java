package blogandquestion.algorithms.binarysearch.kthsmallest378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/23 20:15:20
 * description:
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 *
 */
public class Solution {
    // 使用大顶堆记录前k个最小的元素
    // 遍历数组，如果元素值小于堆顶的值，则将堆顶值弹出，将当前值加入堆
    // 最后返回堆顶值

    // 这题最好的解法是利用二分，现在头有点晕，以后再看吧
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queue.size() < k) {
                    queue.add(matrix[i][j]);
                } else if (matrix[i][j] < queue.peek()) {
                    queue.poll();
                    queue.add(matrix[i][j]);
                }
            }
        }
        return queue.poll();
    }
}

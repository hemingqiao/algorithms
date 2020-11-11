package blogandquestion.algorithms.numbers.spiralorder54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/11 14:42:06
 * description: 与Solution.java中的解法相比，优化了退出循环的写法，省去了定义一个计数变量。
 * 解题思路
 * see: https://leetcode-cn.com/problems/spiral-matrix/solution/cxiang-xi-ti-jie-by-youlookdeliciousc-3/
 */
public class AnotherSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (true) {
            // 从左到右将第一行的元素放入list中
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            // 重新定义上边界，如果新定义的上边界大于下边界，则遍历完成，退出循环
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            // 重新设定右边界
            if (--right < left) break;
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            // 重新设定下边界
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            // 重新设定左边界
            if (++left > right) break;
        }
        return res;
    }
}

package src.numbers.generatematrix59;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/11 12:04:14
 * description: 这个解法妙啊。
 * 解题思路
 * see: https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
 */
public class AnotherSolution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1, tar = n * n;
        while (count <= tar) {
            for (int i = left; i <= right; i++) res[top][i] = count++;
            // 重新定义上边界
            top++;
            for (int i = top; i <= bottom; i++) res[i][right] = count++;
            // 重新定义右边界
            right--;
            for (int i = right; i >= left; i--) res[bottom][i] = count++;
            // 重新定义下边界
            bottom--;
            for (int i = bottom; i >= top; i--) res[i][left] = count++;
            // 重新定义左边界
            left++;
        }
        return res;
    }
}

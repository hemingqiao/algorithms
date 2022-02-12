package src.dfs.floodfill733;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/29 22:05:21
 * description:
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 * 示例 1:
 *
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 注意:
 *
 * image 和 image[0] 的长度在范围 [1, 50] 内。
 * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 *
 * 注：本题与 https://leetcode-cn.com/problems/color-fill-lcci/ 相同
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        // visited数组用来记录是否访问过某个左边
        boolean[][] visited = new boolean[m][n];
        dfs(image, sr, sc, newColor, m, n, image[sr][sc], visited);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int m, int n, int initColor, boolean[][] visited) {
        // 如果下边越界或者坐标对应的颜色与初始颜色不同或者已经访问过，直接返回
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != initColor || visited[i][j]) {
            return;
        }
        image[i][j] = newColor;
        visited[i][j] = true; // 标记该位置已访问
        dfs(image, i - 1, j, newColor, m, n, initColor, visited);
        dfs(image, i, j + 1, newColor, m, n, initColor, visited);
        dfs(image, i + 1, j, newColor, m, n, initColor, visited);
        dfs(image, i, j - 1, newColor, m, n, initColor, visited);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] image = new int[2][3];
        image[0] = new int[]{0,0,0};
        image[1] = new int[]{0, 1, 1};
        int[][] res = s.floodFill(image, 1, 1, 1);
        System.out.println(Arrays.deepToString(res));
    }
}

/**
 * // 参考：https://leetcode-cn.com/problems/flood-fill/solution/tu-xiang-xuan-ran-by-leetcode-solution/
 */
class AnotherSolution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image; // 感觉是取巧了，这里的判断恰好避开了死循环（如果当前颜色和新颜色相同，直接返回原图）
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int initColor) {
        int m = image.length, n = image[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != initColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i - 1, j, newColor, initColor);
        dfs(image, i, j + 1, newColor, initColor);
        dfs(image, i + 1, j, newColor, initColor);
        dfs(image, i, j - 1, newColor, initColor);
    }
}

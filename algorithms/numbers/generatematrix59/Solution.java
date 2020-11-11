package blogandquestion.algorithms.numbers.generatematrix59;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/11 11:44:40
 * description:
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s/KTPhaeqxbMK9CxHUUgFDmg
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1; // 从1开始赋值
        int offset = 1; // 每循环一圈，就可以少遍历两个格子，offset记录每一圈循环时需要少遍历的格子数
        int loopTimes = n / 2; // 定义总共需要循环多少次，如n等于3，则需要循环1次，中间的格子特殊处理
        int mid = n / 2; // 矩阵中间的位置，n为奇数时需要处理正中间的格子，n为偶数时则不需要处理正中间的格子
        int startx = 0, starty = 0; // 每一圈循环的起始位置
        int i, j;
        while (loopTimes-- > 0) {
            // 顺时针填充格子，区间均是左闭右开。垂直向下为i轴，水平向右为j轴

            // 从左到右填充上行
            for (j = starty; j < starty + n - offset; j++) {
                result[startx][j] = count++;
            }

            // 从上到下填充右列
            for (i = startx; i < startx + n - offset; i++) {
                result[i][j] = count++;
            }

            // 从右到左填充下行（不填充第一个，仍然是左闭右开，只不过顺序变成了从右到左）
            for (; j > starty; j--) {
                result[i][j] = count++;
            }

            // 从下到上填充左列
            for (; i > startx; i--) {
                result[i][j] = count++;
            }

            // 第二圈开始时，起始横纵坐标都要加1
            startx++;
            starty++;

            // 每填充一圈，就可以少填充两个格子
            offset += 2;
        }

        // 如果n为奇数，填充中间的格子
        if (n % 2 == 1) {
            result[mid][mid] = count;
        }
        return result;
    }
}

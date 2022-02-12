package src.binarysearch.guessnumber374;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 20:54:12
 * description:
 */
public class Solution {
    public int guessNumber(int n) {
        int left = 1, right = n;
        int res;
        while (left <= right) {
            // left 和 right 很大的时候，left + right 会发生整型溢出，变成负数
            // 怪不得提交一直错误
            int mid = (left + right) >> 1;
            res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // guess是由LeetCode提供的方法
    public int guess(int num) {
        return -1;
    }
}

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/shi-fen-hao-yong-de-er-fen-cha-zhao-fa-mo-ban-pyth/
 */
class AnotherSolution {
    public int guessNumber(int n) {
        int left = 1, right = n;
        int res;
        while (left <= right) {
            // left 和 right 很大的时候，left + right 会发生整型溢出，变成负数
            // 除了使用无符号右移之外，还可以使用 int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // guess是由LeetCode提供的方法
    public int guess(int num) {
        return -1;
    }
}

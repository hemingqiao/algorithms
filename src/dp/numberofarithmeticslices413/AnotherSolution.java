package src.dp.numberofarithmeticslices413;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/07 19:12:26
 * description:
 * see: https://leetcode-cn.com/problems/arithmetic-slices/solution/deng-chai-shu-lie-hua-fen-by-leetcode/
 */
public class AnotherSolution {
    int sum = 0;

    public int numberOfArithmeticSlices(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }

    private int slices(int[] A, int length) {
        if (length < 2) {
            return 0; // base case
        }

        int temp = 0;
        if (A[length] - A[length - 1] == A[length - 1] - A[length - 2]) {
            temp = 1 + slices(A, length - 1);
            sum += temp;
        } else {
            // 如果len - 1和len之间的差值和len - 1与len - 2的差值不等，则向前移动一位，继续判断
            slices(A, length - 1);
        }

        return temp;
    }
}

package blogandquestion.algorithms.binary.countbits338;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/03 08:33:47
 * description:
 */
public class ExerciseSolution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ret[i] = getBitOne(i);
        }
        return ret;
    }

    /*public int getBitOne(int number) {
        int cnt = 0;
        int i = 0;
        while (true) {
            if ((number >> i) == 0) break;
            if ((number >> i++ & 1) == 1) cnt++;
        }
        return cnt;
    }*/

    public int getBitOne(int number) {
        int cnt = 0;
        while (number != 0) {
            if ((number & 1) == 1) cnt++;
            number >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int number = 5;
        int[] res = es.countBits(number);
        System.out.println(Arrays.toString(res));
    }

    public int[] countBits1(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        for (int i = 1; i <= num; i++) {
            // 偶数，偶数y的二进制数中1的个数和y / 2的二进制数中1的个数相同，因为y / 2 右移一位得到y，右移一位低位补0
            if ((i & 1) == 0) {
                ret[i] = ret[i >> 1];
            } else {
                // 奇数，奇数x的二进制数中的1比x-1的二进制数中的1多一个，偶数加上一个1成为和偶数相邻的奇数
                ret[i] = ret[i - 1] + 1;
            }
        }
        return ret;
    }
}

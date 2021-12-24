package blogandquestion.algorithms.binary.reversebits190;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/29 12:54:16
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = (ret << 1) + (n & 1); // n 与 1 做与运算获取最后一位上的值
            n >>= 1;
//            n >>>= 1; // 无符号右移也可以
        }
        return ret;
    }
}

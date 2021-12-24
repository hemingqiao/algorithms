package blogandquestion.algorithms.binary.countnumberone191;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/05 09:13:57
 * description:
 */
public class ExerciseSolution {
    // you need to treat n as an unsigned value
    // lowbit操作，参见：https://www.acwing.com/video/14/
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n -= lowbit(n);
            ++cnt;
        }
        return cnt;
    }

    public int lowbit(int n) {
        return n & -n;
    }
}

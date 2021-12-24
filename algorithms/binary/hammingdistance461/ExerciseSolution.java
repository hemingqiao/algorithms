package blogandquestion.algorithms.binary.hammingdistance461;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/27 21:09:36
 * description:
 */
public class ExerciseSolution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y; // x ^ y将两个数二进制表示中的1合并到一个数上，异或：相同为0，不同为1
        int count = 0;
        while (n != 0) {
            n &= n - 1; // n & n - 1可以将n的二进制表示中最低位上的1变为0，只要n非零，表明n的二进制表示中还有1存在，循环继续
            ++count;
        }
        return count;
    }
}

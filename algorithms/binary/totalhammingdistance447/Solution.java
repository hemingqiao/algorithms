package blogandquestion.algorithms.binary.totalhammingdistance447;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/28 20:09:30
 * description:
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 *
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 *
 * 参考：https://github.com/grandyang/leetcode/issues/477
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int t = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += Integer.bitCount(t ^ nums[j]);
            }
        }
        return sum;
    }

    /*
    需要来找出某种规律来，比如看下面这个例子，4，14，2 和 1：
        4:     0 1 0 0

        14:   1 1 1 0

        2:     0 0 1 0

        1:     0 0 0 1

    先看最后一列，有三个0和一个1，那么它们之间相互的汉明距离就是3，即1和其他三个0分别的距离累加，然后在看第三列，累加汉明距离为4，因为每个1都会
    跟两个0产生两个汉明距离，同理第二列也是4，第一列是3。仔细观察累计汉明距离和0跟1的个数，可以发现其实就是0的个数乘以1的个数，发现了这个重要
    的规律，那么整道题就迎刃而解了，只要统计出每一位的1的个数即可，
     */
    public int totalHammingDistance1(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) ++cnt;
            }
            sum += (n - cnt) * cnt;
        }
        return sum;
    }
}

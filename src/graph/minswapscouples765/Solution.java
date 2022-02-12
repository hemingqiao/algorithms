package src.graph.minswapscouples765;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/14 09:35:18
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/765
 */
public class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int res = 0;
        // 注意这里用了一个 trick，一个数 ‘异或’ 上1就是其另一个位，这个不难理解，如果是偶数的话，最后位是0，‘异或’上1等于加了1。
        // 如果是奇数的话，最后位是1，‘异或’上1后变为了0，‘异或’上1等于减了1
        // 如4 ^ 1 == 5, 5 ^ 1 == 4
        for (int i = 0; i < n; i += 2) {
            if (row[i + 1] == (row[i] ^ 1)) continue;
            ++res;
            for (int j = i + 1; j < n; j++) {
                if (row[j] == (row[i] ^ 1)) {
                    // 交换位置
                    row[j] = row[i + 1];
                    row[i + 1] = row[i] ^ 1;
                    break;
                }
            }
        }
        return res;
    }

    /*
    当暂时对如何用代码来解决问题没啥头绪的时候，一个很好的办法是，先手动解决问题，意思是，假设这道题不要求你写代码，就让你按照要求排好序怎么做。
    随便举个例子来说吧，比如：

        [3   1   4   0   2   5]

    如何将其重新排序呢？首先明确，交换数字位置的动机是要凑对儿，如果交换的两个数字无法组成新对儿，那么这个交换就毫无意义。来手动交换吧，两个两个的来看数字，前两个数是3和1，知道其不成对儿，数字3的老相好是2，不是1，那么怎么办呢？就把1和2交换位置呗。好，那么现在3和2牵手成功，度假去了，再来看后面的：

        [3   2   4   0   1   5]

    再取两数字，4和0，互不认识！4跟5有一腿儿，不是0，那么就把0和5，交换一下吧，得到：

        [3   2   4   5   1   0]

    好了，再取最后两个数字，1和0，两口子，不用动！前面都成对的话，最后两个数字一定成对。而且这种方法所用的交换次数一定是最少的
     */
}

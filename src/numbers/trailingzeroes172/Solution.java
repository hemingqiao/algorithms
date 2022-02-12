package src.trailingzeroes172;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/03 15:55:26
 * description: 每出现一个10，结果就会多一个0，而 10 = 2 * 5，只要是偶数就能分解出一个2，所以问题变为寻找n!能分解出多少个因子5
 */
public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                res++;
                j /= 5;
            }
        }
        return res;
    }


//    /**
//     * 根据5出现的规律，简化上面的方法
//     * see: https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
//     *
//     * @param n
//     * @return
//     */
//    public int trailingZeroes(int n) {
//        int res = 0;
//        while (n > 0) {
//            // 每隔5个数就会出现一个5
//            res += n / 5;
//            n = n / 5;
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(5));
    }
}

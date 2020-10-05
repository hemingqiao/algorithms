package blogandquestion.algorithms.countprimes204;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/04 11:28:33
 * description:
 * 204、计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 *
 * see: https://leetcode-cn.com/problems/count-primes/solution/ru-he-gao-xiao-pan-ding-shai-xuan-su-shu-by-labula/
 */
public class Solution {
    public int countPrimes(int n) {
        // 使用false标记质数
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                // 如果i为质数，i的倍数就不可能为质数了
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int result = new Solution().countPrimes(10);
        System.out.println(result);
    }


    /**
     * 对上面的优化，主要是改变了外层循环的判断条件，i * i < n
     *
     * @param n
     * @return
     */
    public int countPrimesOpt(int n) {
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                for (int j = i * 2; j < n; j+= i) {
                    isPrime[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}

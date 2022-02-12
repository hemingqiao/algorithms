package src.numbers.countprimes204;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 21:32:18
 * description:
 * 另外一种思路
 */
public class AnotherSolution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            // 如果是合数，直接跳过
            if (notPrime[i]) {
                continue;
            }
            // 如果是质数，计数，同时将这个质数的倍数标记为非质数（false）
            count++;
            for (int j = i; j < n; j += i) {
                notPrime[j] = true;
            }
        }
        return count;
    }
}

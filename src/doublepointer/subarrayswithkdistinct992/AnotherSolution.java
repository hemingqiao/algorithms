package src.doublepointer.subarrayswithkdistinct992;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/09 14:05:58
 * description:
 * 参考：https://leetcode-cn.com/problems/subarrays-with-k-different-integers/solution/ba-dai-ma-gao-jian-ji-dian-o2nshe-qi-cha-0yy3/
 */
public class AnotherSolution {
    public int subarrayWithKDistinct(int[] A, int K) {
        return getKth(A, K) - getKth(A, K - 1);
    }

    public int getKth(int[] A, int K) {
        int n = A.length;
        int[] cnt = new int[n + 1];
        int res = 0, count = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (cnt[A[r]] == 0) count++;
            cnt[A[r]]++;
            while (count > K) {
               if (--cnt[A[l]] == 0) count--;
               l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}

package blogandquestion.algorithms.array.findlength718;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/26 19:54:28
 * description:
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *  
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 *
 * 参考：https://github.com/grandyang/leetcode/issues/718
 */
public class Solution {
//    public int findLength(int[] A, int[] B) {
//        int m = A.length, n = B.length;
//        int cnt;
//        int res = 0;
//        for (int i = 0; i < m; i++) {
//            cnt = 0;
//            for (int j = i, k = 0; j < m && k < n;) {
//                while (j < m && k < n && A[j++] == B[k++]) {
//                    cnt++;
//                }
//                res = Math.max(res, cnt);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            cnt = 0;
//            for (int j = i, k = 0; j < n && k < m;) {
//                while (j < n && k < m && B[j++] == A[k++]) {
//                    cnt++;
//                }
//                res = Math.max(res, cnt);
//            }
//        }
//        return res;
//    }

    public int findLength1(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            cnt = 0; // 每次移动外层循环的指针，将cnt置为0
            for (int j = i, k = 0; j < m && k < n; j++, k++) {
                if (A[j] == B[k]) {
                    cnt++;
                    res = Math.max(res, cnt);
                } else {
                    cnt = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = i, k = 0; j < n && k < m; j++, k++) {
                if (B[j] == A[k]) {
                    cnt++;
                    res = Math.max(res, cnt);
                } else {
                    cnt = 0;
                }
            }
        }
        return res;
    }
}

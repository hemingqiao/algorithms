package blogandquestion.algorithms.string.countandsay38;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 13:12:42
 * description:
 *
 * 参考：https://github.com/grandyang/leetcode/issues/38
 */
public class Solution {
    public String countAndSay(int n) {
        // 题目限定了1 <= n <= 30，不判断也可
        if (n <= 0) return "";
        String res = "1";
        // 因为已经给res赋值了"1"，相当于已经执行了一次
        // 所以剩下的执行次数是n - 1次，判断条件为--n
        while (--n > 0) {
            StringBuilder cur = new StringBuilder();
            int size = res.length();
            for (int i = 0; i < size; i++) {
                int cnt = 1;
                while (i + 1 < size && res.charAt(i) == res.charAt(i + 1)) {
                    cnt++;
                    i++;
                }
                cur.append(cnt).append(res.charAt(i));
            }
            res = cur.toString();
        }
        return res;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/count-and-say/solution/1-ms-zai-suo-you-java-ti-jiao-zhong-ji-bai-liao-97/
 */
class AnotherSolution {
    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) return "1";
        StringBuffer res = new StringBuffer();
        // 使用递归拿到上一层的字符串
        String str = countAndSay(n - 1);
        int length = str.length();
        // 开始时指针为0
        int start = 0;
        // 从1开始
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                // 如果是字符串的最后一位直接拼接
                res.append(i - start).append(str.charAt(start));
            } else if (str.charAt(i) != str.charAt(start)) {
                // 当start处的字符和i处的字符不同时，拼接并更新start
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }
}

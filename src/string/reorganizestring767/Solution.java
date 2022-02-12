package src.string.reorganizestring767;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 11:50:05
 * description:
 * 参考：https://leetcode-cn.com/problems/reorganize-string/solution/javadai-ma-ji-bai-liao-100de-yong-hu-by-sdwwld/
 */
public class Solution {
    public String reorganizeString(String S) {
        char[] chars = S.toCharArray();
        int[] record = new int[26]; // s只包含小写字母
        int len = record.length;
        int threshold = (len + 1) >> 1; // 阀值
        int max = 0, alphabet = 0; // max记录出现次数最多的字符出现次数，alphabet记录出现最多次的字符
        for (int i = 0; i < len; i++) {
            int idx = chars[i] - 'a';
            record[idx]++;
            if (record[idx] > max) {
                max = record[idx];
                alphabet = idx;
            }
            if (max > threshold) {
                return "";
            }
        }
        // 将得到的字符重组，拼接成新的字符串
        char[] res = new char[len];
        int idx = 0;
        // 先将出现次数最多的次数放到偶数位置上
        while (record[alphabet]-- > 0) {
            res[idx] = (char)(alphabet + 'a');
            idx += 2;
        }
        // 再将剩余的字符放到剩余的位置上
        for (int i = 0; i < record.length; i++) {
            while (record[i]-- > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char)(i + 'a');
                idx += 2;
            }
        }
        return new String(res);
    }
}

// 上面和下面的逻辑都是相同的，为什么下面这个比上面这个要快1ms呢？
class AnotherSolution {
    public String reorganizeString(String S) {
        // 把字符串S转化为字符数组
        char[] alphabetArr = S.toCharArray();
        // 记录每个字符出现的次数
        int[] alphabetCount = new int[26];
        // 字符串的长度
        int length = S.length();
        // 统计每个字符出现的次数
        for (int i = 0; i < length; i++) {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        // 找出出现次数最多的那个字符
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > max) {
                max = alphabetCount[i];
                alphabet = i;
                // 如果出现次数最多的那个字符的数量大于阈值，说明他不能使得
                // 两相邻的字符不同，直接返回空字符串即可
                if (max > threshold)
                    return "";
            }
        }
        // 到这一步说明他可以使得两相邻的字符不同，我们随便返回一个结果，res就是返回
        // 结果的数组形式，最后会再转化为字符串的
        char[] res = new char[length];
        int index = 0;
        // 先把出现次数最多的字符存储在数组下标为偶数的位置上
        while (alphabetCount[alphabet]-- > 0) {
            res[index] = (char) (alphabet + 'a');
            index += 2;
        }
        // 然后再把剩下的字符存储在其他位置上
        for (int i = 0; i < alphabetCount.length; i++) {
            while (alphabetCount[i]-- > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }
}

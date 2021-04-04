package blogandquestion.algorithms.leetcodeweeklycontest.d49;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/04 21:41:07
 * description:
 */
public class Template {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        // 保证 s1 是最长的那个字符串数组
        if (sentence1.length() < sentence2.length()) return areSentencesSimilar(sentence2, sentence1);
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        // 检查长度为 1 时的特殊情况
        if (s2.length == 1) return s2[0].equals(s1[0]) || s2[0].equals(s1[s1.length - 1]);

        // 从左往右遍历短句子 s2，检查是不是在右边插入新的句子
        int idx = 0;    // 用来遍历 s2 的下标，如果 s2[idx] == s1[idx] ，就一直往右移动
        while (idx < s2.length && s2[idx].equals(s1[idx])) idx++;
        // 如果遍历完了 s2，那么说明匹配到了
        if (idx == s2.length) return true;

        // 从右往左遍历短句子 s2，检查是不是在左边插入新的句子
        idx = s2.length - 1;
        // 偏移量是用来补齐 s1 中下标的
        int offset = s1.length - s2.length;
        while (idx >= 0 && s2[idx].equals(s1[offset + idx])) --idx;
        if (idx == -1) return true;

        // 检查是否是夹在中间，使用两套指针分别去遍历 s1 和 s2
        int l1 = 0, l2 = 0, r1 = s1.length - 1, r2 = s2.length - 1;
        while (l2 <= r2 && s1[l1].equals(s2[l2])) {
            l1++;
            l2++;
        }
        while (r2 >= 0 && s1[r1].equals(s2[r2])) {
            r1--;
            r2--;
        }
        // 如果两个指针相遇了，那么说明把 s2 检查完了，返回 true，否则 false
        return r2 == l2 - 1;
    }
}

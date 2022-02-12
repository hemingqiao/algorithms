package src.leetcodeweeklycontest.d49;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/04 20:28:11
 * description:
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，
 * "hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 *
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这
 * 两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2
 *  中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 *
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 
 * false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 * 示例 2：
 *
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 * 示例 3：
 *
 * 输入：sentence1 = "Eating right now", sentence2 = "Eating"
 * 输出：true
 * 解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
 * 示例 4：
 *
 * 输入：sentence1 = "Luky", sentence2 = "Lucccky"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 和 sentence2 都只包含大小写英文字母和空格。
 * sentence1 和 sentence2 中的单词都只由单个空格隔开。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sentence-similarity-iii
 *
 */
public class Two {
    /*
    对于题目，可以分成三种情况进行讨论：

        在左边插入一个句子
        在中间插入一个句子
        在右边插入一个句子
        那么满足上面三种任意一种，就返回 true，对于其他情况，都是 false。

    参考：https://leetcode-cn.com/problems/sentence-similarity-iii/solution/java-fen-san-chong-qing-kuang-tao-lun-zh-wzz6/
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        //  确保sentence1是比较长的那一个
        if (sentence1.length() < sentence2.length()) return areSentencesSimilar(sentence2, sentence1);
        String[] s1 = sentence1.split(" "), s2 = sentence2.split(" ");
        int n1 = s1.length, n2 = s2.length;
        // 长度为1的特殊情况
        if (n2 == 1) {
            return s1[0].equals(s2[0]) || s1[n1 - 1].equals(s2[0]);
        }
        // 从左往右遍历短句子，判断是不是在右边插入新句子的情况
        int idx = 0;
        while (idx < n2 && s2[idx].equals(s1[idx])) idx++;
        if (idx == n2) return true; // idx == n2，表明匹配到了

        // 从右往左遍历短句子，判断是不是在左边插入新句子的情况
        idx = n2 - 1;
        int offset = n1 - n2;
        while (idx >= 0 && s2[idx].equals(s1[idx + offset])) idx--;
        if (idx == 0) return true;

        // 检查是否是夹在中间的情况
        int l1 = 0, l2 = 0, r1 = n1 - 1, r2 = n2 - 1;
        // 先从sentence2的左边开始判断
        while (l2 <= r2 && s1[l1].equals(s2[l2])) {
            l2++;
            l1++;
        }
        while (r2 >= 0 && s1[r1].equals(s2[r2])) {
            r2--;
            r1--;
        }
        // 如果遍历sentence2的两个指针相遇了，说明把sentence2检查完了，此时可以返回true
        //   a lot of books
        //   a        books
        // r2      l2
        // 此时r2 = 0, l2 = 1
        return l2 == r2 + 1;
    }

    public static void main(String[] args) {
        Two t = new Two();
        String s1 = "Eating right now";
        String s2 = "Eating";
        boolean res = t.areSentencesSimilar(s1, s2);
        System.out.println(res);
    }
}

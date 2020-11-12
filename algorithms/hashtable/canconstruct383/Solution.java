package blogandquestion.algorithms.hashtable.canconstruct383;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 19:30:25
 * description:
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *  
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 *
 * 这题和242很类似，只不过不同的是这题只需要判断第一个字符串能否由第二个组成，所以可以先遍历第一个字符串，然后遍历第二个字符串时，需要判断
 * 字符是否在第一个字符串中出现过，如果出现过，将次数减一，一直减到0为止，最后遍历record数组，判断是否存在不为0的字符，如果存在，返回false。
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']++;
        }
        for (char d : magazine.toCharArray()) {
            if (record[d - 'a'] > 0) {
                record[d - 'a']--;
            }
        }
        for (int i : record) {
            if (i != 0) return false;
        }
        return true;
    }
}

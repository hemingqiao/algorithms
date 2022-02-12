package src.array.countcharacters1160;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 11:55:23
 * description:
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 *
 */
public class Solution {
    // 觉得这代码写的好烂
    public int countCharacters(String[] words, String chars) {
        int[] record = new int[128];
        char[] cs = chars.toCharArray();
        for (char c : cs) {
            record[c]++;
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            int[] clone = record.clone();
            String s = words[i];
            int len = s.length();
            for (int j = 0; j < len; j++) {
                if (clone[s.charAt(j)] == 0) {
                    break;
                }
                clone[s.charAt(j)]--;
                if (j == len - 1) {
                    count += len;
                }
            }
        }
        return count;
    }
}


class AnotherSolution {
    public int countCharacters(String[] words, String chars) {
        int [] table = new int[26];
        int [] temp = new int[26];
        for (int i = 0;i < chars.length(); i++){
            table[chars.charAt(i) - 'a']++;
        }
        int count = 0;
        for(String s : words){
            if(contains(table,temp,s)){
                count += s.length();
            }
        }
        return count;
    }

    private boolean contains(int[] table, int[] temp, String s){
        System.arraycopy(table, 0, temp, 0, 26);
        for(int j = 0; j < s.length(); j++){
            if(--temp[s.charAt(j) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}

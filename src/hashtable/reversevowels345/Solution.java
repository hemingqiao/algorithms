package src.hashtable.reversevowels345;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/03 20:23:20
 * description:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 *
 * 测试用例中元音字母包括大写的，我TM
 */
public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && !set.contains(chars[i])) {
                i++;
            }
            while (i < j && !set.contains(chars[j])) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "hello";
        String result = s.reverseVowels(test);
        System.out.println(result);
    }
}

class AnotherSolution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length - 1;
        while (low < high) {
            while (low < high && !isVowel(chars[low])) {
                low++;
            }
            while (low < high && !isVowel(chars[high])) {
                high--;
            }
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

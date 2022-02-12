package src.string.reversestring344;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/08 19:52:28
 * description: 双指针分别指向头和尾，然后依次移动。
 * 😅虽然执行用时只击败了14.5，但是没有抄题解😼。
 * 原来是不需要输出的。。。去掉输出就能击败99.98了。
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 *
 */
public class Solution {
    /*
    public void reverseString(char[] s) {
        if (s.length < 2) {
            System.out.println(Arrays.toString(s));
        }

        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }
    */

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseString("hello".toCharArray());
    }

    public void reverseString(char[] s) {
        if (s == null || s.length <= 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

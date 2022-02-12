package src.doublepointer.strstr28;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 11:29:43
 * description:
 */
public class AnotherSolution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0; // 特判，两个字符串都为""的情况
        // 每次查找长度为n的子字符串
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == n - 1) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("".length());
    }
}

package src.doublepointer.ispalindrome125;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/31 15:29:54
 * description:
 */
public class ExerciseSolution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        s = s.toLowerCase();
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) left++;
            while (left < right && !isValid(s.charAt(right))) right--;
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public boolean isValid(char c) {
        return Character.isDigit(c) || c - 'a' >= 0 && c - 'a' <= 25;
    }

    public boolean isPalindrome1(String s) {
        if (s == null) return false;
        if (s.equals("")) return true;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !isValid1(chars[left])) left++;
            while (left < right && !isValid1(chars[right])) right--;
            if (chars[left] != chars[right]) return false;
        }
        return true;
    }

    public boolean isValid1(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}

package blogandquestion.algorithms.doublepointer.ispalindrome125;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/15 22:22:06
 * description:
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        else if (s.equals("")) return true;

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char l =s.charAt(i);
            char r = s.charAt(j);
            if (l - '0' < 0 || l - '0' > 9 && l - '0' < 49 || l - '0' > 74) {
                i++;
                continue;
            }
            if (r - '0' < 0 || r - '0' > 9 && r - '0' < 49 || r - '0' > 74) {
                j--;
                continue;
            }
            if (l != r) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "A man, a plan, a canal: Panama";
        boolean result = s.isPalindrome(s1);
        System.out.println(result);
    }
}

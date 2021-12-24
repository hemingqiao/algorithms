package blogandquestion.algorithms.string.longestcommonprefix14;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/11 22:40:20
 * description:
 */
public class ExerciseSolution1 {
    public String longestCommonPrefix(String[] strs) {
        String f = strs[0];
        int res = 1010, n = f.length();
        for (int i = 0; i < strs.length; i++) {
            String t = strs[i];
            int p = 0, m = t.length();
            while (p < n && p < m && f.charAt(p) == t.charAt(p)) p++;
            res = Math.min(res, p);
        }
        if (res == 1010) return "";
        return f.substring(0, res);
    }

    public String longestCommonPrefix1(String[] strs) {
        StringBuilder res = new StringBuilder();
        for (int i = 0;; i++) {
            if (i >= strs[0].length()) return res.toString();
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) return res.toString();
            }
            res.append(c);
        }
    }
}

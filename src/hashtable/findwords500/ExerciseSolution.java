package src.hashtable.findwords500;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/31 20:02:10
 * description:
 */
public class ExerciseSolution {
    static String a = "qwertyuiop", b = "asdfghjkl", c = "zxcvbnm";

    public String[] findWords(String[] words) {
        List<String> l = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (check(words[i])) l.add(words[i]);
        }
        String[] ans = new String[l.size()];
        for (int i = 0; i < l.size(); i++) ans[i] = l.get(i);
        return ans;
    }

    public boolean check(String s) {
        int ca = 0, cb = 0, cc = 0;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (a.indexOf(t) >= 0) ca++;
            else if (b.indexOf(t) >= 0) cb++;
            else if (c.indexOf(t) >= 0) cc++;
        }
        if (ca != 0) return cb == 0 && cc == 0;
        else if (cb != 0) return ca == 0 && cc == 0;
        else return ca == 0 && cb == 0;
    }
}

package blogandquestion.algorithms.leetcodeweeklycontest.d52;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/26 23:21:29
 * description: 
 */
public class One {
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        List<Pair> list = new ArrayList<>();
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            String t = strs[i];
            int j = 0, m = t.length();
            StringBuilder sb = new StringBuilder();
            while (j < m && !Character.isDigit(t.charAt(j))) {
                sb.append(t.charAt(j++));
            }
            list.add(new Pair(sb.toString(), Integer.valueOf(t.substring(j))));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.num - o2.num;
            }
        });
        StringBuilder ret = new StringBuilder();
        for (int k = 0; k < n - 1; k++) ret.append(list.get(k).s).append(" ");
        ret.append(list.get(n - 1).s);
        return ret.toString();
    }

    static class Pair {
        String s;
        int num;

        public Pair(String s, int num) {
            this.s = s;
            this.num = num;
        }
    }
}

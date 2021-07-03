package blogandquestion.algorithms.topk.frequencysort451;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/03 09:20:19
 * description:
 */
public class ExerciseSolution {
    public String frequencySort(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        Pair[] b = new Pair[256];
        for (int i = 0; i < 256; i++) b[i] = new Pair(i, 0);
        for (int i = 0; i < n; i++) b[a[i]].fre++;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(b, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.fre - o1.fre;
            }
        });
        for (int i = 0; i < 256; i++) {
            if (b[i].fre == 0) continue;
            char t = (char) b[i].val;
            int f = b[i].fre;
            while (f-- > 0) sb.append(t);
        }
        return sb.toString();
    }

    static class Pair {
        int val;
        int fre;

        public Pair(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String t = "tree";
        String res = es.frequencySort(t);
        System.out.println(res);
    }

    // 使用lambda表达式和使用匿名内部类的运行时间基本上一致
    public String frequencySort1(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        Pair[] b = new Pair[256];
        for (int i = 0; i < 256; i++) b[i] = new Pair(i, 0);
        for (int i = 0; i < n; i++) b[a[i]].fre++;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(b, (o1, o2) -> o2.fre - o1.fre);
        for (int i = 0; i < 256; i++) {
            if (b[i].fre == 0) continue;
            char t = (char) b[i].val;
            int f = b[i].fre;
            while (f-- > 0) sb.append(t);
        }
        return sb.toString();
    }
}

package src.acwing.priorityqueue;

import java.util.*;
import java.io.*;

public class Main {
    static List<Character> c = new ArrayList<>();
    static int[] f = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] ss = in.readLine().split(" ");
            int n = Integer.parseInt(ss[0]), k = Integer.parseInt(ss[1]), g = k;
            String s = in.readLine();
            c = new ArrayList<>();
            f = new int[26];
            for (int i = 0; i < n; i++) {
                char cc = s.charAt(i);
                if (f[cc - 'a'] == 0) {
                    f[cc - 'a']++;
                    c.add(cc);
                }
            }
            Collections.sort(c);
            StringBuilder ret = new StringBuilder();
            if (k > n) {
                int fre = k - n;
                while (fre-- > 0) ret.append(c.get(0));
                System.out.println(s + ret.toString());
            } else {
                char temp = s.charAt(k - 1);
                int kk = c.size() - 1;
                while (kk > 0 && c.get(kk) > temp) kk--;
                if (kk == c.size() - 1) {
                    int p = k - 2;
                    while (p >= 0) {
                        char prev = s.charAt(p);
                        k = c.size() - 1;
                        while (k > 0 && c.get(k) > prev) k--;
                        if (k == c.size() - 1) p--;
                        else {
                            int fre = g - p - 1;
                            ret.append(c.get(k + 1));
                            while (fre-- > 0) ret.append(c.get(0));
                            System.out.println(s.substring(0, p) + ret.toString());
                            break;
                        }
                    }
                } else {
                    System.out.println(s.substring(0, k - 1) + c.get(kk + 1));
                }
            }
        }
    }
}

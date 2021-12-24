package blogandquestion.algorithms.acwing.hash;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/18 09:08:39
 * description:
 */
public class Simulation {
    public static int N = 100003;
    public static LinkedList[] h = new LinkedList[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] ss = in.readLine().split(" ");
            String op = ss[0];
            int x = Integer.parseInt(ss[1]);
            if ("I".equals(op)) {
                insert(x);
            } else {
                if (find(x)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    public static void insert(int x) {
        int hash = (x % N + N) % N;
        if (h[hash] == null) {
            h[hash] = new LinkedList();
        }
        h[hash].addFirst(x);
    }

    public static boolean find(int x) {
        int hash = (x % N + N) % N;
        LinkedList l = h[hash];
        if (l == null) return false;
        for (Object item : l) {
            if ((int) item == x) return true;
        }
        return false;
    }
}

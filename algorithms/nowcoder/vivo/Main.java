package blogandquestion.algorithms.nowcoder.vivo;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/07 19:18:49
 * description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            if (sb.toString().equals(sb.reverse().toString())) {
                System.out.println(sb.toString());
                return;
            }
        }
        System.out.println(false);
    }
}

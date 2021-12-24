package blogandquestion.algorithms.nowcoder.huawei;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 11:03:19
 * description:
 */
public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        List<String> list = new ArrayList<>();
        while (!"".equals(in = br.readLine())) {
            if (in == null) return;
            StringBuilder sb = new StringBuilder(in);
            if (sb.length() < 8) {
                int n = sb.length();
                for (int i = 0; i < 8 - n; i++) {
                    sb.append("0");
                }
            } else {
                while (sb.length() > 8) {
                    String temp = sb.substring(0, 8);
                    System.out.println(temp);
                    sb = new StringBuilder(sb.substring(8));
                }
                int n = sb.length();
                for (int i = 0; i < 8 - n; i++) {
                    sb.append("0");
                }
            }
            System.out.println(sb.toString());
        }
    }
}

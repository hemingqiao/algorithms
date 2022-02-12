package src.nowcoder.huawei;

import java.io.*;
import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 11:25:30
 * description:
 */
public class Five {
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner cin = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
//        String in;
        while (cin.hasNext()) {
//            if (in == null) return;
            Long ret = 0L;
            String in = cin.next();
            StringBuilder sb = new StringBuilder(in.substring(2).toLowerCase());
            int n = sb.length(), i = 0;
            while (i < n) {
                char t = sb.charAt(i++);
                if (Character.isDigit(t)) {
                    ret = ret * 16 + (t - '0');
                } else {
                    int temp = map.get(t);
                    ret = ret * 16 + temp;
                }
            }
            System.out.println(ret);
        }
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        String in;
        while (!"".equals(in = br.readLine())) {
            if (in == null) return;
            Long ret = 0L;
//            String in = cin.next();
            StringBuilder sb = new StringBuilder(in.substring(2).toLowerCase());
            int n = sb.length(), i = 0;
            while (i < n) {
                char t = sb.charAt(i++);
                if (Character.isDigit(t)) {
                    ret = ret * 16 + (t - '0');
                } else {
                    int temp = map.get(t);
                    ret = ret * 16 + temp;
                }
            }
            System.out.println(ret);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while (!"".equals(in = br.readLine())) {
            if (in == null) return;
            System.out.println(Integer.valueOf(in.substring(2), 16));
        }
    }
}

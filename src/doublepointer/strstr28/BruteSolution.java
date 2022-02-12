package src.doublepointer.strstr28;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/16 21:08:23
 * description: 改了6次，成功超时~
 */
public class BruteSolution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = i, m = 0; m < needle.length() && j < haystack.length(); j++, m++) {
                if (haystack.charAt(j) != needle.charAt(m)) {
                    break;
                }
                count++;
            }
            if (count == needle.length()) {
                return i;
            }
            count = 0;
        }
        return -1;
    }


    public static void main(String[] args) {
        BruteSolution bs = new BruteSolution();
        String s = "bbaa", t = "aab";
        int result = bs.strStr(s, t);
        System.out.println(result);
    }
}

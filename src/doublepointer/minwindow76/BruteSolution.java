package src.doublepointer.minwindow76;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 20:22:04
 * description: 暴力解法，最后超时了。超时之前的227/268个测试用例都通过了。
 */
public class BruteSolution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        String res = "";
        String temp;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length() - 1; j < s.length(); j++) {
                temp = s.substring(i, j + 1);
                if (validate(temp, t)) {
                    res = res == "" ? temp : temp.length() < res.length() ? temp : res;
                }
            }
        }

        return res;
    }

    /*// 这个验证方法验证了出现的顺序，但在这个问题中不需要验证顺序
    private boolean validate(String s, String t) {
        int index = -1;
        for (char c : t.toCharArray()) {
            index = s.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }*/

    private boolean validate(String s, String t) {
        int index = -1;
        for (char c : t.toCharArray()) {
            index = s.indexOf(c);
            if (index == -1) return false;
            s = s.substring(0, index) + s.substring(index + 1);
        }
        return true;
    }
}

package src.dfs.countofatoms726;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/05 21:37:58
 * description:
 *
 */
public class Solution {
    int u = 0; // u作为一个指针，从字符串的头部遍历到尾部，定义为全局变量，每次递归都需要更改这个u

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> res = dfs(formula);
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            s.append(entry.getKey());
            if (entry.getValue() > 1) s.append(entry.getValue());
        }
        return s.toString();
    }

    public TreeMap<String, Integer> dfs(String s) {
        TreeMap<String, Integer> res = new TreeMap<>();
        int n = s.length();
        while (u < n) {
            if (s.charAt(u) == '(') {
                ++u; // 跳过左括号
                TreeMap<String, Integer> t = dfs(s);
                ++u; // 跳过右括号
                int cnt = 1, k = u;
                while (k < n && Character.isDigit(s.charAt(k))) k++;
                if (k > u) {
                    cnt = Integer.parseInt(s.substring(u, k));
                    u = k;
                }
                for (Map.Entry<String, Integer> entry : t.entrySet())
                    res.put(entry.getKey(), res.getOrDefault(entry.getKey(), 0) + entry.getValue() * cnt);

            } else if (s.charAt(u) == ')') {
                break;
            } else {
                int k = u + 1;
                while (k < n && s.charAt(k) >= 'a' && s.charAt(k) <= 'z') k++;
                String key = s.substring(u, k);
                u = k;
                int cnt = 1;
                while (k < n && Character.isDigit(s.charAt(k))) k++;
                if (k > u) {
                    cnt = Integer.parseInt(s.substring(u, k));
                    u = k;
                }
                res.put(key, res.getOrDefault(key, 0) + cnt);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String res = s.countOfAtoms("Mg(OH)2");
        System.out.println(res);
    }
}

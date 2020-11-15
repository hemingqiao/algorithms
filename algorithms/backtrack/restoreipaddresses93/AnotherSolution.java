package blogandquestion.algorithms.backtrack.restoreipaddresses93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/15 11:53:22
 * description:
 * 参考：https://mp.weixin.qq.com/s/v--VmA8tp9vs4bXCqHhBuA
 */
public class AnotherSolution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(new StringBuilder(s), 0, 0);
        return result;
    }

    private void backtracking(StringBuilder s, int pointNum, int startIndex) {
        if (pointNum == 3) { // 逗点数量为3时，判断第四段子字符串是否合法，如果合法就放入result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(String.valueOf(s));
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, ".");
                pointNum++;
                backtracking(s, pointNum, i + 2); // 插入了一个逗点，所以下一轮迭代的startIndex向右移动两个位置
                pointNum--; // 回溯，上面一句的递归分支结束，撤销之前的操作，考察下一个切割点i
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    private boolean isValid(StringBuilder s, int left, int right) {
        int sum = 0;
        if (left > right) return false;
        if (s.charAt(left) == '0' && left != right) return false;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum > 255) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        String s1 = "1111";
        List<String> res = as.restoreIpAddresses(s1);
        System.out.println(res);
    }
}

/**
 * 稍微调整下校验方法
 * <p>
 * 参考：https://leetcode-cn.com/problems/restore-ip-addresses/solution/shuang-bai-ti-jie-zui-tong-su-yi-dong-de-c-hui-su-/
 */
class AnotherSolutionOpt {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(new StringBuilder(s), 0, 0);
        return result;
    }

    private void backtracking(StringBuilder s, int pointNum, int startIndex) {
        if (pointNum == 3) { // 逗点数量为3时，判断第四段子字符串是否合法，如果合法就放入result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(String.valueOf(s));
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                // 如果i + 1已经超过或者到达了字符串的末尾，而逗点数量不满三个，直接返回
                if (i + 1 < s.length()) {
                    s.insert(i + 1, ".");
                } else {
                    return;
                }
                pointNum++;
                backtracking(s, pointNum, i + 2); // 插入了一个逗点，所以下一轮迭代的startIndex向右移动两个位置
                pointNum--; // 回溯，上面一句的递归分支结束，撤销之前的操作，考察下一个切割点i
                s.deleteCharAt(i + 1);
            } else {
                return;
            }
        }
    }

    private boolean isValid(StringBuilder s, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (left != right && s.charAt(left) == '0') return false;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum > 255) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        AnotherSolutionOpt as = new AnotherSolutionOpt();
        String s1 = "1111";
        List<String> res = as.restoreIpAddresses(s1);
        System.out.println(res);
    }
}

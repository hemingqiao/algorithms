package blogandquestion.algorithms.backtrack.restoreipaddresses93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/15 10:39:44
 * description:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 *
 * 参考：
 * https://leetcode-cn.com/problems/restore-ip-addresses/solution/2020041693medianhui-su-di-gui-fu-yuan-ip-di-zhi-by/
 * https://leetcode-cn.com/problems/restore-ip-addresses/solution/shou-hua-tu-jie-huan-yuan-dfs-hui-su-de-xi-jie-by-/
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        backtracking(s, 0, res, new ArrayList<>());
        return res;
    }

    // pos记录当前遍历到s字符串中的位置，temp存放已经确定好的ip段
    private void backtracking(String s, int pos, List<String> res, List<String> temp) {
        // 如果ip段已经四个
        if (temp.size() == 4) {
            // 如果此时pos也恰好遍历完s
            if (pos == s.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }

        // ip段每段最多三个数，枚举出所有选择，三种切割长度：1、2、3
        for (int i = 1; i <= 3; i++) {
            // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
            // 加上要切的长度（i）就越界，不能切这个长度
            if (pos + i > s.length()) {
                break;
            }
            String segment = s.substring(pos, pos + i);
            int val = Integer.parseInt(segment);
            // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && val > 255)) return;

            temp.add(segment); // 片段符合要求就加入到temp中
            backtracking(s, pos + i, res, temp); // 递归
            temp.remove(temp.size() - 1); // 回溯，上面一句的递归分支结束，撤销最后的选择，进入下一轮迭代，考察下一个切割长度
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "25525511135";
        List<String> res = s.restoreIpAddresses(s1);
        System.out.println(res);
    }
}

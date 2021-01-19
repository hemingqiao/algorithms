package blogandquestion.algorithms.string.validipaddress468;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/19 13:13:22
 * description:
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 *
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：IP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 * 示例 2：
 *
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 * 示例 3：
 *
 * 输入：IP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 * 示例 4：
 *
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
 * 输出："Neither"
 * 示例 5：
 *
 * 输入：IP = "1e1.4.5.6"
 * 输出："Neither"
 *  
 *
 * 提示：
 *
 * IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 *
 * 参考：https://leetcode-cn.com/problems/validate-ip-address/solution/zhi-xing-yong-shi-1-ms-zai-suo-you-java-ti-jia-203/
 * 关于String.split()方法：https://zhuanlan.zhihu.com/p/45151144
 */
public class Solution {
    public String validIPAddress(String IP) {
        String[] ipv4Arr = IP.split("\\.", 0);
        if (ipv4Arr.length == 4) {
            return isIPV4(ipv4Arr);
        }
        String[] ipv6Arr = IP.split("\\:", 0);
        if (ipv6Arr.length == 8) {
            return isIPV6(ipv6Arr);
        }
        return "Neither";
    }

    public String isIPV4(String[] arr) {
        for (String ip : arr) {
            if (ip.length() > 3 || ip.length() <= 0) {
                return "Neither";
            }
            for (int i = 0; i < ip.length(); i++) {
                if (!Character.isDigit(ip.charAt(i))) {
                    return "Neither";
                }
            }
            int ipNum = Integer.parseInt(ip);
            // 第二个条件判断是否有先导的0
            if (ipNum > 255 || String.valueOf(ipNum).length() != ip.length()) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String isIPV6(String[] arr) {
        for (String ip : arr) {
            if (ip.length() > 4 || ip.length() <= 0) {
                return "Neither";
            }
            for (int i = 0; i < ip.length(); i++) {
                char c = ip.charAt(i);
                // 合法的IPV6字符是：0-9 || a - f || A - F，非法的IPV6字符就是对前面的条件取反
                if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}

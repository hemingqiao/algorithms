package blogandquestion.algorithms.array.validutf8393;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/21 18:53:22
 * description:
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 * 这是 UTF-8 编码的工作方式：
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 *
 * 注意:
 * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 * 示例 1:
 *
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 *
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 * 示例 2:
 *
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 *
 * 返回 false 。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/utf-8-validation
 *
 * 参考：https://github.com/grandyang/leetcode/issues/393
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int d = data[i];
            if (d < 0b10000000) {
                continue; // 小于0b10000000首位肯定是0，是合法的utf8序列
            } else {
                int cnt = 0;
                if (d == 0b10000000) {
                    return false; // 大小等于0b10000000，直接返回false
                } else {
                    // 因为在for循环中每次都执行了pow运算，时间效率不是很好
                    // 同时可以发现pow得到的结果是128，64...所以可以引入一个变量来记录
                    for (int j = 7; j >= 1; j--) {
                        if (d >= Math.pow(2, j)) {
                            cnt++;
                        } else {
                            break;
                        }
                        d -= Math.pow(2, j);
                    }
                    // cnt等于1或者大于4都是非法的
                    // 当cnt位于[2,4]时，如果后面没有cnt - 1个字节时，同样是非法的（即需要满足i + cnt <= len）
                    if (cnt == 1 || cnt > 4 || cnt + i > len) {
                        return false;
                    }
                    for (int k = i + 1; k < i + cnt; k++) {
                        if (data[k] < 0b10000000 || data[k] > 0b10111111) {
                            return false;
                        }
                    }
                }
                i += cnt; // 这里加上cnt后要减去1，因为外层for循环会对i执行一次自增
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[]{248,130,130,130};
        Solution s = new Solution();
        boolean res = s.validUtf8(test);
        System.out.println(res);
    }
}


class AnotherSolution {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        int pow = 128; // 用来记录Math.pow(2, 7)
        for (int i = 0; i < len; i++) {
            int d = data[i];
            if (d < 0b10000000) {
                continue; // 小于0b10000000首位肯定是0，是合法的utf8序列
            } else {
                int cnt = 0;
                if (d == 0b10000000) {
                    return false; // 大小等于0b10000000，直接返回false
                } else {
                    int temp = pow;
                    for (int j = 7; j >= 1; j--) {
                        if (d >= temp) {
                            cnt++;
                        } else {
                            break;
                        }
                        d -= temp;
                        temp /= 2;
                    }
                    // cnt等于1或者大于4都是非法的
                    // 当cnt位于[2,4]时，如果后面没有cnt - 1个字节时，同样是非法的（即需要满足i + cnt <= len）
                    if (cnt == 1 || cnt > 4 || cnt + i > len) {
                        return false;
                    }
                    for (int k = i + 1; k < i + cnt; k++) {
                        if (data[k] < 0b10000000 || data[k] > 0b10111111) {
                            return false;
                        }
                    }
                }
                i += cnt - 1; // 这里加上cnt后要减去1，因为外层for循环会对i执行一次自增
            }
        }
        return true;
    }
}
